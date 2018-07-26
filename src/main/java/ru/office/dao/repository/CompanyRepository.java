package ru.office.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.office.entity.Company;

//@RepositoryRestResource(collectionResourceRel = "company", path = "company")
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
