package ru.office.data.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = Office.TABLE_NAME)
public class Office implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "office";

    /*
    id
    title (unique)
    address
    department_id
    company_id
     */
    @Id
    @SequenceGenerator(name = TABLE_NAME+"_generator", sequenceName = TABLE_NAME+"_sequence")
    @GeneratedValue(generator = TABLE_NAME+"_generator")
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @OneToMany(mappedBy = TABLE_NAME)
    private List<Department> departments;

    protected Office() {
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
