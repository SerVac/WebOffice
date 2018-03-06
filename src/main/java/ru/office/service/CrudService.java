package ru.office.service;

import org.aspectj.weaver.ast.Not;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.CrudRepository;
import ru.office.data.entity.AbstractEntity;
import ru.office.service.exception.NotFoundException;
import ru.office.service.utils.MsgFormatter;

import javax.persistence.MappedSuperclass;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@MappedSuperclass
public abstract class CrudService<T extends AbstractEntity> {
    private static final Logger logger = LoggerFactory.getLogger(CrudService.class);

    private static final String NOT_EXIST_MSG_WITH_ID = "Entity with Id = %s is NOT exist!";

    protected final Class<T> type;

    protected abstract CrudRepository<T, Long> getRepository();

    public CrudService(Class<T> type) {
        this.type = type;
    }

    @Transactional
    public T save(T entity) {
        return getRepository().save(entity);
    }

    public T get(long id) throws NotFoundException {
        T entity = getRepository().findOne(id);
        if (entity == null) {
            throwNFEById(id);
        }
        return entity;
    }

    public List<T> findAll() {
        return (List<T>) getRepository().findAll();
    }

    @Transactional
    public void delete(long id) {
        getRepository().delete(id);
    }

    @Transactional
    public void safeDelete(long id) {
        if (isExist(id)) {
            getRepository().delete(id);
        }
    }

    public boolean isExist(long id) {
        boolean isExist = getRepository().exists(id);
        if (!isExist) {
            logger.warn(MsgFormatter.formatMsgWithId(NOT_EXIST_MSG_WITH_ID, id));
        }
        return isExist;
    }

    protected void throwNFEById(long id) throws NotFoundException {
        NotFoundException nfe = new NotFoundException(id);
        logger.warn(nfe.getMsg());
        throw nfe;
    }
}
