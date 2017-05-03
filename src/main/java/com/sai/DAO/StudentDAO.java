package com.sai.DAO;

import com.sai.Entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentDAO {
    private static Map<Integer, Student> students;
    static{
        students=new HashMap<Integer, Student>(){ //inline
            {
                put(1, new Student(1, "Sai","Computer Science"));
                put(2, new Student(2, "Madhavi","Finance"));
                put(3, new Student(3, "Sunkari","Maths"));
            }
        };
    }
    public Collection<Student> getAllStudents()
    {
        return this.students.values();
    }
    public Student getStudentById(int id){
        return this.students.get(id);
    }

    public void removeStudentById(int id) {
        this.students.remove(id);
    }
    public void updateStudent(Student student){
        Student searchStudent= students.get(student.getId()); //trace the concerned student details (intended to be changed) in the hashmap by id
        searchStudent.setCourse(student.getCourse()); //make the changes using setters and getters of entity variables.
        searchStudent.setName(student.getName());
        //students.put(student.getId(),student);
    }

    public void insertStudentToDB(Student student) {
        this.students.put(student.getId(),student);
    }
}
