package ru.office.data.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "department")
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;

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
	@SequenceGenerator(name="department_generator", sequenceName="department_sequence")
	@GeneratedValue(generator = "department_generator")
	private Long id;

	@Column(nullable = false)
	private String title;

	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="sub_department_id")
	private Department subDepartment;

	@OneToMany(mappedBy="subDepartment")
	private Set<Department> subDepartments = new HashSet<Department>();

    @OneToMany(mappedBy="department")
    private List<Worker> workers;

	protected Department() {
	}

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
