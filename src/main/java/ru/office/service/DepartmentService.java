package ru.office.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ru.office.dao.repository.DepartmentRepository;
import ru.office.data.entity.Department;

import javax.annotation.Resource;

@Service
public class DepartmentService extends CrudService<Department> {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentService.class);

    @Resource
    DepartmentRepository repository;

    @Override
    protected CrudRepository<Department, Long> getRepository() {
        return repository;
    }

    public DepartmentService(Class<Department> type) {
        super(type);
    }

}
