package ru.office.entity;

import ru.office.config.DefaultValues;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = Office.TABLE_NAME)
public class Office extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME = "office";

    /*
    id
    title (unique)
    address
    department_id
    company_id
     */
    @Column(name = "title", nullable = false, unique = true, length = DefaultValues.MAX_LENGTH_TITLE)
    private String title;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @OneToMany(targetEntity=Department.class, fetch = FetchType.LAZY, mappedBy = "office", cascade = CascadeType.ALL)
    private Set<Department> departments;

    public Office() {
    }

    //	GET/SET
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }
}
