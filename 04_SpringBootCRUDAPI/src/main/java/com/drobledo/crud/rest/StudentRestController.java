package com.drobledo.crud.rest;

import com.drobledo.crud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    List<Student> studentsList;

    @PostConstruct
    private void LoadStudentData() {
        studentsList = new ArrayList<>();

        studentsList.add(new Student("Finn", "Mertens"));
        studentsList.add(new Student("Jake", "Sr. The Dog"));
        studentsList.add(new Student("BMO", "Football"));
    }

    @GetMapping("/students")
    public List<Student> GetStudents() {
        return studentsList;
    }

    @GetMapping("/students/{studentId}")
    public Student GetStudentById(@PathVariable int studentId) {
        if (studentId < 0 || studentId > studentsList.size()) {
            throw new StudentNotFoundException("No student found for id - " + studentId);
        }

        return studentsList.get(studentId);
    }
}
