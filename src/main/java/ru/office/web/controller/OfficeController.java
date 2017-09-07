package ru.office.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.office.data.entity.Department;
import ru.office.service.DepartmentRepository;

import java.util.List;


//@RestController
@RequestMapping("/")
@RepositoryRestController
public class OfficeController {
    @Autowired
    DepartmentRepository departmentRepository;

   /* @RequestMapping(value = "/", method = RequestMethod.GET)
    public  @ResponseBody String home() {

        return "Hello World!";
    }*/

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        List<Department> departmentList = (List<Department>) departmentRepository.findAll();
        model.addAttribute("departmentList", departmentList);

        for (Department department : departmentList) {
            ObjectMapper mapper = new ObjectMapper();
            String jsonInString = null;
            try {
                jsonInString = mapper.writeValueAsString(department);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            System.out.println("departmentid="+department.getId()+" JSON: \n"+jsonInString);
        }

        return "hello";
    }

}
