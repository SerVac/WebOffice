package ru.office.service;


import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import ru.office.dao.DepartmentRepository;
import ru.office.data.entity.Department;
import ru.office.dto.DepartmentDTO;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    private ModelMapper modelMapper;// = new ModelMapper();

    public List<DepartmentDTO> findAll() {
        List<Department> departments = (List<Department>) departmentRepository.findAll();
        List<DepartmentDTO> departmentDTOS = new ArrayList<DepartmentDTO>();
        for(Department department:departments){
            departmentDTOS.add(convertToDto(department));
        }
        return departmentDTOS;
    }

    private DepartmentDTO convertToDto(Department department) {
        DepartmentDTO departmentDTO = modelMapper.map(department, DepartmentDTO.class);
        departmentDTO.setSubDepartments(department.getSubDepartments());
        return departmentDTO;
    }


    /*PropertyMap<Department, DepartmentDTO> departmentMap =
            new PropertyMap<Department, DepartmentDTO>() {
                protected void configure() {
                    map().setSubDepartments(source.getSubDepartments());
                }
            };
        modelMapper.addMappings(departmentMap);*/
}
