package ru.office.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.office.data.entity.Office;

@RepositoryRestResource(collectionResourceRel = "office", path = "office")
public interface OfficeRepository extends PagingAndSortingRepository<Office, Long> {

}
