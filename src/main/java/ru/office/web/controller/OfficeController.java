package ru.office.web.controller;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


//@RestController
@RequestMapping("/")
@RepositoryRestController
public class OfficeController {

   /* @RequestMapping(value = "/", method = RequestMethod.GET)
    public  @ResponseBody String home() {

        return "Hello World!";
    }*/

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

}
