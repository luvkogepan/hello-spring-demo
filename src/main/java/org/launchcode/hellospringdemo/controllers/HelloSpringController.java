package org.launchcode.hellospringdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Bay
 */
@Controller
public class HelloSpringController {

    // Handles request of the form /hello?name=LaunchCode
    @RequestMapping(value="hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String name, Model model) {
        String greeting = "Hello, "+name+"!";
        //first attribute matches with what is on the template and second
        //matches with the variable name in the controller
        model.addAttribute("greeting", greeting);
        return "hello";
    }

     //Handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloAgain(@PathVariable String name, Model model) {
       // String greeting = "Hello, "+name+"!";
        model.addAttribute("greeting", "Hello, "+name+"!");
        return "hello";
    }

    @GetMapping("form")
    // no longer use when using template @ResponseBody
    public String helloForm() {
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("Javascript");
        model.addAttribute("names", names);
        return "hello-list";
    }
}