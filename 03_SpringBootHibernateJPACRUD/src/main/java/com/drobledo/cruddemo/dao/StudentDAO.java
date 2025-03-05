package com.drobledo.cruddemo.dao;

import com.drobledo.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    void update(Student student);

    void delete(Integer id);
}
