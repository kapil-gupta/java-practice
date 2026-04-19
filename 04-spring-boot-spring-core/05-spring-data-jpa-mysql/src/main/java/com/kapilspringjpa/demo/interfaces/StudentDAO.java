package com.kapilspringjpa.demo.interfaces;

import com.kapilspringjpa.demo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findAllByFirstName(String theName);

    void update(Student s);
    void delete(Integer id);
    int deleteAll();
}
