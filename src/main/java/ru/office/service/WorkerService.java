package ru.office.service;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ru.office.dao.repository.WorkerRepository;
import ru.office.data.entity.Worker;

import javax.annotation.Resource;

@Service
public class WorkerService extends CrudService<Worker> {

    @Resource
    WorkerRepository repository;

    @Override
    protected CrudRepository<Worker, Long> getRepository() {
        return repository;
    }

}
