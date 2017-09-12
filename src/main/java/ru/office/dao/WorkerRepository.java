package ru.office.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.office.data.entity.Worker;

@RepositoryRestResource(collectionResourceRel = "worker", path = "worker")
public interface WorkerRepository extends PagingAndSortingRepository<Worker, Long> {

}
