package ru.office.data.entity;

import ru.office.config.DefaultValues;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(
        name = Worker.TABLE_NAME,
        uniqueConstraints = {
                @UniqueConstraint(name = "name_constraint",
                        columnNames = {"name", "middle_name", "last_name"})
        }
)
public class Worker extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME = "worker";


    /*
    id
    department_id
    name
  - uniq group:
     middle_name
     last_name
     birth_date
    phone (uniq)
    email (uniq)
    */
    private String name;
    private String middleName;
    private String lastName;
    private Date birthDate;
    private String email;
    private Department department;

    public Worker() {
    }

    //	GET/SET
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "middle_name", nullable = false, length = DefaultValues.MAX_LENGTH_NAME)
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Column(name = "last_name", nullable = false, length = DefaultValues.MAX_LENGTH_NAME)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "birth_date", nullable = false, length = DefaultValues.MAX_LENGTH_NAME)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "email", nullable = false, unique = true, length = DefaultValues.MAX_LENGTH_EMAIL)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
