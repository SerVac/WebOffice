package ru.office.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.office.entity.Worker;

//@RepositoryRestResource(collectionResourceRel = "worker", path = "worker")
public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
