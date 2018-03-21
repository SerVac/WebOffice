package ru.office.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.office.dao.repository.CompanyRepository;
import ru.office.dao.repository.DepartmentRepository;
import ru.office.dao.repository.OfficeRepository;
import ru.office.dao.repository.WorkerRepository;
import ru.office.data.entity.Department;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class TestDataGenerator {

    private WorkerRepository workerRepository;
    private DepartmentRepository departmentRepository;
    private OfficeRepository officeRepository;
    private CompanyRepository companyRepository;


    @Autowired
    public TestDataGenerator(WorkerRepository workerRepository,
                             DepartmentRepository departmentRepository,
                             OfficeRepository officeRepository,
                             CompanyRepository companyRepository)   {
        this.workerRepository = workerRepository;
        this.departmentRepository = departmentRepository;
        this.officeRepository = officeRepository;
        this.companyRepository = companyRepository;
    }

    @PostConstruct
    public void PostInit() {
        List<Department> departmentList = departmentRepository.findAll();

//        List<Department> departmentList2 = departmentRepository.findAll();


    }

    public void generateWorker(){

    }
}
