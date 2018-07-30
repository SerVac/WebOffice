package ru.office.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    @Transient
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Id @GeneratedValue
    private Long id;

    @Version
    private long version = 0L;

    @Column(name = "creation_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationTime = new Date();

    @Column(name = "modification_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationTime = new Date();

    @PrePersist
    public void onSave() {
        System.out.println("On pre persist " + getId());
        Date now = new Date();
        creationTime = now;
        modificationTime = now;
    }

    @PreUpdate
    public void onUpdate() {
        System.out.println("On PreUpdate " + getId());
        modificationTime = new Date();
    }


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

    public void setVersion(long version) {
        this.version = version;
    }

    public long getVersion() {
        return version;
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