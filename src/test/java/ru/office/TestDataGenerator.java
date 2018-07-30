package ru.office;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import ru.office.entity.*;
import ru.office.service.*;


@Component
public class TestDataGenerator {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    private WorkerService workerService;
    private DepartmentService departmentService;

    private StringBuilder strBuilder = new StringBuilder();

    @Autowired
    public TestDataGenerator(WorkerService workerService, DepartmentService departmentService) {
        this.workerService = workerService;
        this.departmentService = departmentService;
    }

    @PostConstruct
    public void PostInit() {
        logger.info("Test data generator started");

        int minWorkers = 1;
        int maxWorkers = 10;

        List<Department> departmentList = departmentService.findAll();

        for (Department department : departmentList) {
            generateWorkers(department, minWorkers, maxWorkers);
        }

//        List<Department> departmentList2 = departmentRepository.findAll();

    }

    public void generateWorkers(Department department, int minWorkers, int maxWorkers) {
        logger.info("Generate workers for ");
        Office office = department.getOffice();
        strBuilder.setLength(0);

        long companyId = office.getCompany().getId();
        logger.info("Office: "+office.getTitle()+" / Company: "+office.getCompany().getTitle());
        strBuilder.append("c_");
        strBuilder.append(companyId);
        strBuilder.append("-");

        long officeId = office.getId();
        strBuilder.append("o_");
        strBuilder.append(officeId);
        strBuilder.append("-");

        strBuilder.append("d_");
        strBuilder.append(department.getId());
        strBuilder.append("-");
        strBuilder.append("worker_");

        String prefixWorker = strBuilder.toString();
        int workerId = 0;
        maxWorkers = (minWorkers >= maxWorkers) ? 1 : rndRange(minWorkers, maxWorkers);
        maxWorkers = maxWorkers == minWorkers ? minWorkers + 1 : maxWorkers;
        logger.info("Generate (" + (maxWorkers - minWorkers) + ") Workers for Department id=[" + department.getId() + "] title = '" + department.getTitle() + "'");

        for (int i = minWorkers; i <= maxWorkers; i++) {
            workerId++;
            Worker worker = new Worker();
            worker.setName(prefixWorker + workerId);
            worker.setMiddleName(worker.getName() + "-middle-"+workerId);
            worker.setLastName(worker.getName() + "-last-"+workerId);
            worker.setEmail(worker.getName() + "@weboffice.com");
            worker.setBirthDate(rndBirthDate());
            worker.setDepartment(department);
            workerService.save(worker);
        }

    }

    private static Random rnd = new Random();

    public static Date rndBirthDate() {
        Calendar calendar = Calendar.getInstance();
        int year = rndRange(1900, calendar.get(Calendar.YEAR));
        calendar.set(Calendar.YEAR, year);
        int dayOfYear = rndRange(calendar.getActualMinimum(Calendar.DAY_OF_YEAR), calendar.getActualMaximum(Calendar.DAY_OF_YEAR));
        calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);
        return calendar.getTime();
    }

    public static int rndRange(int min, int max) {
        return rnd.nextInt((max - min) + 1) + min;
    }
}
