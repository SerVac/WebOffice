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
    public static final String TABLE_NAME = "department";
    /*
    id
    office_id
    sub_department_id
    chief_id
    worker_id
    title
    address
     */
//    @SequenceGenerator(name = TABLE_NAME + "_generator", sequenceName = TABLE_NAME + "_sequence")
//    @GeneratedValue(generator = TABLE_NAME + "_generator")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @ManyToOne
    @JoinColumn(name = "office_id", nullable = false)
    private Office office;

    @ManyToOne
    @JoinColumn(name = "main_department_id")
    private Department mainDepartment;

    @OneToMany(mappedBy = "mainDepartment", cascade = CascadeType.ALL)
    private Set<Department> subDepartments = new HashSet<Department>();

    @OneToMany(mappedBy = TABLE_NAME, cascade = CascadeType.ALL)
    private Set<Worker> workers;

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

    public Set<Department> getSubDepartments() {
        return subDepartments;
    }
}
