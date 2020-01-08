package edu.kea.group.springmvcweb.controller;

import edu.kea.group.springmvcweb.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MainViewController {


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/ajax")
    public String ajax() {
        return "ajax";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/studentinfo")
    public String studentInfo(Model model) {

        //Object instantiation would normally take place elsewhere in the program.
        //But it is done here for the sake of brevity.
        Student charlie = new Student();
        charlie.setFirstName("Charlie");
        charlie.setLastName("Brown");
        charlie.setId(101L);
        charlie.setImageURL("Charlie_Brown.png");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
        String strDoB = "02-10-1950 11:35:42";
        try {
            Date doB = dateFormat.parse(strDoB);
            charlie.setDob(doB);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        model.addAttribute("student", charlie);
        return "studentinfo";
    }

}
