package ru.office.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.CrudRepository;
import ru.office.entity.AbstractEntity;
import ru.office.service.exception.NotFoundException;
import ru.office.service.utils.MsgFormatter;

import javax.persistence.MappedSuperclass;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@MappedSuperclass
public abstract class CrudService<T extends AbstractEntity> {

    private static final String NOT_EXIST_MSG_WITH_ID = "Entity with Id = %s is NOT exist!";

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected final Class<T> type;

//    public CrudService(Class<T> type) {
//        this.type = type;
//    }

    protected abstract CrudRepository<T, Long> getRepository();

    public CrudService() {
        type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
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
    public void delete(long id) throws NotFoundException {
        try {
            get(id);
        } catch (NotFoundException e) {
            logger.warn("Can't delete entity for type [" + this.getClass().getSimpleName() + "] by Id=" + id);
            logger.warn(e.getMessage());
            throw e;
        }
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

    //    loggs
    public void info(String msg){
        logger.info(msg);
    }

    public void warn(String msg){
        logger.warn(msg);
    }

    public void error(String msg){
        logger.error(msg);
    }

    public void debug(String msg){
        logger.debug(msg);
    }

}
