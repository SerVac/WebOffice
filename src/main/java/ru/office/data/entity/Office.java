package ru.office.data.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

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
//    @SequenceGenerator(name = TABLE_NAME+"_generator", sequenceName = TABLE_NAME+"_sequence")
//    @GeneratedValue(generator = TABLE_NAME+"_generator")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @OneToMany(mappedBy = TABLE_NAME, cascade = CascadeType.ALL)
    private Set<Department> departments;

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
