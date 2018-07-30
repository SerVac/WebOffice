package ru.office.entity;

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
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "middle_name", nullable = false, length = DefaultValues.MAX_LENGTH_NAME)
    private String middleName;
    @Column(name = "last_name", nullable = false, length = DefaultValues.MAX_LENGTH_NAME)
    private String lastName;
    @Column(name = "birth_date", nullable = false, length = DefaultValues.MAX_LENGTH_NAME)
    private Date birthDate;
    @Column(name = "email", nullable = false, unique = true, length = DefaultValues.MAX_LENGTH_EMAIL)
    private String email;
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    public Worker() {
    }

    //	GET/SET
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
