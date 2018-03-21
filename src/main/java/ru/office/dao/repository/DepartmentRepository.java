package ru.office.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.office.data.entity.Department;

import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "department", path = "department")
public interface DepartmentRepository extends JpaRepository<Department, Long> {


	List<Department> findByTitle(@Param("title") String title);

	@Query("SELECT distinct d FROM Department d WHERE d.office.id in " +
			"( select offices from Company c JOIN c.offices offices where c.id = :companyId)")
	List<Department> findAllByCompanyId(@Param("companyId") long companyId);

}
