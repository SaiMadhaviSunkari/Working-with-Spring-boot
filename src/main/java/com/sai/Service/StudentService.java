package com.sai.Service;

import com.sai.DAO.StudentDAO;
import com.sai.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {
    @Autowired
    private StudentDAO studentdao; //we need to create an instance of DAO to use DAO layer
    public Collection<Student> getAllStudents()
    {
        return this.studentdao.getAllStudents();
    }
    public Student getStudentById(int id){
        return this.studentdao.getStudentById(id);
    }

    public void removeStudentById(int id) {
         this.studentdao.removeStudentById(id);
    }
    public void updateStudent(Student student){
        this.studentdao.updateStudent(student);
    }

    public void insertStudent(Student student) {
        this.studentdao.insertStudentToDB(student);
    }
}
