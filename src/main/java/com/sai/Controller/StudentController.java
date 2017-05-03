package com.sai.Controller;

import com.sai.Entity.Student;
import com.sai.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Collection;
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentservice;//we need to create an instance of service to use this layer

    @RequestMapping(value="/", method= RequestMethod.GET)
    public Collection<Student> getAllStudents()
    {
        return studentservice.getAllStudents();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Student getStudentById(@PathVariable("id") int id)
    {
        return studentservice.getStudentById(id);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public void deleteStudentById(@PathVariable("id") int id){
        studentservice.removeStudentById(id);
    }
    @RequestMapping(method=RequestMethod.PUT, consumes= MediaType.APPLICATION_JSON_VALUE)
    public void updateStudent(@RequestBody Student student){
        studentservice.updateStudent(student);

    }
    @RequestMapping(method=RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
    public void insertStudent(@RequestBody Student student){
        studentservice.insertStudent(student);

    }
}
