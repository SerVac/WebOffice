package ru.office.entity;

import ru.office.config.DefaultValues;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = Department.TABLE_NAME)
public class Department extends AbstractEntity {

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

    private String title;
    private Office office;
    private Department mainDepartment;
    private Set<Department> subDepartments = new HashSet<Department>();
    private Set<Worker> workers;

    public Department() {
    }

    //	GET/SET
    @Column(name = "title", nullable = false, unique = true, length = DefaultValues.MAX_LENGTH_TITLE)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToOne
    @JoinColumn(name = "office_id", nullable = false)
    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    @ManyToOne
    @JoinColumn(name = "main_department_id")
    public Department getMainDepartment() {
        return mainDepartment;
    }

    public void setMainDepartment(Department mainDepartment) {
        this.mainDepartment = mainDepartment;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mainDepartment", cascade = CascadeType.ALL)
    public Set<Department> getSubDepartments() {
        return subDepartments;
    }

    public void setSubDepartments(Set<Department> subDepartments) {
        this.subDepartments = subDepartments;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department", cascade = CascadeType.ALL)
    public Set<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<Worker> workers) {
        this.workers = workers;
    }
}
