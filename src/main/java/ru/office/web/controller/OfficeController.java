package ru.office.web.controller;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


//@RestController
@RequestMapping("/offices")
@RepositoryRestController
public class OfficeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public  @ResponseBody String home() {
        return "Hello World!";
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public  @ResponseBody String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {

        model.addAttribute("name", name);
        return "greeting";
    }


}
