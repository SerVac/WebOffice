package ru.office.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.office.entity.Office;

//@RepositoryRestResource(collectionResourceRel = "office", path = "office")
public interface OfficeRepository extends JpaRepository<Office, Long> {

}
