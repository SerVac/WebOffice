package ru.office.data.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(
        name = "worker",
        uniqueConstraints = {
                @UniqueConstraint(name="name_constraint",
                        columnNames = {"name", "middle_name", "last_name"})
        }
)
public class Worker implements Serializable {

    private static final long serialVersionUID = 1L;

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
    @Id
    @SequenceGenerator(name = "worker_generator", sequenceName = "worker_sequence")
    @GeneratedValue(generator = "worker_generator")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "middle_name", nullable = false)
    private String middleName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    protected Worker() {
    }

    //	GET/SET
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
