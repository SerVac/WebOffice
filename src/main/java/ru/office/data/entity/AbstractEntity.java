package ru.office.data.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    protected Logger logger = LoggerFactory.getLogger(getClass());

//    @SequenceGenerator(name = TABLE_NAME+"_generator", sequenceName = TABLE_NAME+"_sequence")
//    @GeneratedValue(generator = TABLE_NAME+"_generator")
    @Id
    @GeneratedValue
    private Long id;

    @Version
    private long version;

    @Column(name = "creation_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationTime;

    @Column(name = "modification_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isNew() {
        return id == null;
    }

    @Override
    public int hashCode() {
        if (isNew()) {
            return super.hashCode();
        }

        return 31 + id.hashCode();
    }

    @Override
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

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
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