package ru.office.data.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = Department.TABLE_NAME)
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;
    static final String TABLE_NAME = "department";
    /*
    id
    office_id
    sub_department_id
    chief_id
    worker_id
    title
    address
     */
    @Id
    @SequenceGenerator(name = TABLE_NAME + "_generator", sequenceName = TABLE_NAME + "_sequence")
    @GeneratedValue(generator = TABLE_NAME + "_generator")
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "office_id", nullable = false)
    private Office office;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "main_department_id")
    private Department mainDepartment;

    @OneToMany(mappedBy = "mainDepartment")
    private Set<Department> subDepartments = new HashSet<Department>();


    protected Department() {
    }

    //	GET/SET
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
