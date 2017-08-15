package ru.office.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.office.data.entity.Department;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "department", path = "department")
public interface DepartmentRepository extends PagingAndSortingRepository<Department, Long> {

	List<Department> findByTitle(@Param("title") String name);

}
