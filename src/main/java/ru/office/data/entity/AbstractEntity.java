package ru.office.data.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    @Transient
    protected Logger logger = LoggerFactory.getLogger(getClass());

    private Long id;
    @Version
    private long version;
    @Column(name = "creation_time")
    private Date creationTime;
    @Column(name = "modification_time")
    private Date modificationTime;

    @PrePersist
    public void prePersist() {
        Date now = new Date();
        creationTime = new Date();
        modificationTime = now;
    }

    @PreUpdate
    public void preUpdate() {
        modificationTime = new Date();
    }

//    @SequenceGenerator(name = TABLE_NAME+"_generator", sequenceName = TABLE_NAME+"_sequence")
//    @GeneratedValue(generator = TABLE_NAME+"_generator")
    @Id @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Transient
    public boolean isNew() {
        return id == null;
    }

    @Override
    @Transient
    public int hashCode() {
        if (isNew()) {
            return super.hashCode();
        }

        return 31 + id.hashCode();
    }

    @Override
    @Transient
    public boolean equals(Object other) {
        if (isNew()) {
            // New entities are only equal if the instance if the same
            return super.equals(other);
        }

        if (this == other) {
            return true;
        }
        if (!(other instanceof AbstractEntity)) {
            return false;
        }
        return id.equals(((AbstractEntity) other).id);
    }


    //    loggs
    @Transient
    public void info(String msg) {
        logger.info(msg);
    }

    @Transient
    public void warn(String msg) {
        logger.warn(msg);
    }

    @Transient
    public void error(String msg) {
        logger.error(msg);
    }

    @Transient
    public void debug(String msg) {
        logger.debug(msg);
    }
}