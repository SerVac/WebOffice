package ru.office.data.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = Company.TABLE_NAME)
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;
    static final String TABLE_NAME = "company";

    /*
    id
    title (unique)
    office_id
     */
    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
    @SequenceGenerator(name = TABLE_NAME+"_generator", sequenceName = TABLE_NAME+"_sequence")
    @GeneratedValue(generator = TABLE_NAME+"_generator")
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @OneToMany(mappedBy = TABLE_NAME)
    @NotNull
    private List<Office> offices;

    protected Company() {
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
