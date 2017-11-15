package ru.office.data.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {


//    @SequenceGenerator(name = TABLE_NAME+"_generator", sequenceName = TABLE_NAME+"_sequence")
//    @GeneratedValue(generator = TABLE_NAME+"_generator")
    @Id
    @GeneratedValue
    private Long id;

//    @Version
//    @NotNull
//    private int version = 0;

    public boolean isNew() {
        return id == null;
    }

    public Long getId() {
        return id;
    }

   /* public int getVersion() {
        return version;
    }*/

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

  /*
  public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    */
}