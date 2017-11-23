package ru.office.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.CrudRepository;
import ru.office.data.entity.AbstractEntity;
import ru.office.service.exception.NotFoundException;

import javax.persistence.MappedSuperclass;
import java.util.List;

@MappedSuperclass
public abstract class CrudService<T extends AbstractEntity> {
    private static final Logger logger = LoggerFactory.getLogger(CrudService.class);

    protected final Class<T> type;

    protected abstract CrudRepository<T, Long> getRepository();

    public CrudService(Class<T> type) {
        this.type = type;
    }

    public T save(T entity) {
        return getRepository().save(entity);
    }

    public void delete(long id) throws NotFoundException {
        try {
            get(id);
        }catch (NotFoundException e){
            logger.warn("Can't delete entity for type ["+ type.getSimpleName()+"] by Id="+id);
            logger.warn(e.getMessage());
            throw e;
        }
        getRepository().delete(id);
    }

    public T get(long id) throws NotFoundException {
        return getRepository().findOne(id);
    }

    public List<T> findAll(){
        return (List<T>) getRepository().findAll();
    }
}
