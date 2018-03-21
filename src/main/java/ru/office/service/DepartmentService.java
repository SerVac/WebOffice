package ru.office.service;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ru.office.dao.repository.DepartmentRepository;
import ru.office.data.entity.Department;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentService extends CrudService<Department> {

    @Resource
    DepartmentRepository repository;

    @Override
    protected CrudRepository<Department, Long> getRepository() {
        return repository;
    }

    public List<Department> findByCompanyId(long companyId){
        return repository.findAllByCompanyId(companyId);
    }

}
