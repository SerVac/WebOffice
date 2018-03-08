package ru.office.service;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ru.office.dao.repository.DepartmentRepository;
import ru.office.data.entity.Department;

import javax.annotation.Resource;

@Service
public class DepartmentService extends CrudService<Department> {

    @Resource
    DepartmentRepository repository;

    @Override
    protected CrudRepository<Department, Long> getRepository() {
        return repository;
    }

    public DepartmentService() {
        logger.info("I'm in department service");
    }

    /* public DepartmentService() {
        super(Department.class);
    }*/
}
