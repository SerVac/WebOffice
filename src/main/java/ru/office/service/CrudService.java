package ru.office.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.CrudRepository;
import ru.office.entity.AbstractEntity;
import ru.office.service.exception.NotFoundException;

import javax.persistence.MappedSuperclass;
import java.util.List;

@MappedSuperclass
public abstract class CrudService<T extends AbstractEntity> {
    private static final Logger logger = LoggerFactory.getLogger(CrudService.class);

    protected abstract CrudRepository<T, Long> getRepository();

    public T save(T entity) {
        return getRepository().save(entity);
    }

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

    public T get(long id) throws NotFoundException {
        T entity = getRepository().findOne(id);
        if (entity == null) throw new NotFoundException("No such element with id =" + id);
        return entity;
    }

    public List<T> findAll() {
        return (List<T>) getRepository().findAll();
    }
}
