package ru.office.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.office.data.entity.Department;
import ru.office.service.DepartmentService;

import java.util.List;


//@RestController
@RequestMapping("/")
@RepositoryRestController
public class OfficeController {


    @Autowired
    DepartmentService departmentService;


    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
//    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
    public String greeting(Model model) {
        List<Department> departmentList =  departmentService.findAll();
        model.addAttribute("departmentList", departmentList);
        return "welcome";
    }



}
