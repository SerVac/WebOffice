package ru.office.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@Controller
//@RequestMapping("/office")
@RestController
public class OfficeController {

    /*
        @GetMapping("/")
        @ResponseBody
        @Transactional(readOnly = true)
    */
    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }


}
