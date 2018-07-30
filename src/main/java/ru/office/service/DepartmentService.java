package ru.office.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ru.office.dao.repository.DepartmentRepository;
import ru.office.entity.Department;

import java.util.List;

@Service
public class DepartmentService extends CrudService<Department> {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    private DepartmentRepository repository;

    @Override
    protected CrudRepository<Department, Long> getRepository() {
        return repository;
    }

    public List<Department> findAllByCompanyId(long companyId){
        return repository.findAllByCompanyId(companyId);
    }

}
