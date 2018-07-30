package ru.office.entity;

import ru.office.config.DefaultValues;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = Company.TABLE_NAME)
public class Company extends AbstractEntity{

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME = "company";

    /*
    id
    title (unique)
    office_id
     */
    @Column(name = "title", nullable = false, unique = true, length = DefaultValues.MAX_LENGTH_TITLE)
    private String title;
    @OneToMany(targetEntity=Office.class, mappedBy = "company", cascade = CascadeType.ALL)
    private Set<Office> offices;

    public Company() {
    }

    //	GET/SET

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Office> getOffices() {
        return offices;
    }

    public void setOffices(Set<Office> offices) {
        this.offices = offices;
    }

}