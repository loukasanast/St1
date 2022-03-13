package io.anastasiou.controllers;

import io.anastasiou.models.Student;
import io.anastasiou.services.EntityService;
import io.anastasiou.util.DateEditor;
import io.anastasiou.util.FloatEditor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class StudentManagementController {
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        dataBinder.registerCustomEditor(Float.class, new FloatEditor());
        dataBinder.registerCustomEditor(Date.class, new DateEditor());
    }

    private EntityService<Student> service;

    @Autowired
    public StudentManagementController(EntityService<Student> service) {
        this.service = service;
    }

    @GetMapping("/")
    public String students(Model model) {
        List<Student> students = service.find();

        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/add")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "add";
    }

    @PostMapping("/addpost")
    public String addPost(@Valid @ModelAttribute("student") Student student,
            BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "add";
        }

        service.add(student);

        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        Student student = service.findById(id);

        if (student == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Student not found"
            );
        }

        service.remove(student);

        return "redirect:/";
    }

    @GetMapping("/update")
    public String update(@RequestParam Integer id, Model model) {
        Student student = service.findById(id);

        if (student == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Student not found"
            );
        }

        model.addAttribute("student", student);
        return "update";
    }

    @PostMapping("/updatepost")
    public String updatePost(@Valid @ModelAttribute("student") Student student,
                          BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "update";
        }

        service.edit(student);

        return "redirect:/";
    }
}
