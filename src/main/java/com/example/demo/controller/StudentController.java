package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

  @Autowired
  StudentRepository studentRepository;

  @RequestMapping(value = "students", method = RequestMethod.GET)
  public List<Student> getAll() {
    return studentRepository.findAll();
  }

  @RequestMapping(value = "student/{id}", method = RequestMethod.GET)
  public Student get(@PathVariable Long id) {
    return studentRepository.findOne(id);
  }

  @RequestMapping(value = "student", method = RequestMethod.POST)
  public void create(@RequestBody Student student) {
    studentRepository.save(student);
  }

  @RequestMapping(value = "student/{id}", method = RequestMethod.PUT)
  public void update(@PathVariable Long id, @RequestBody Student student) {
    Student studentFromDb = studentRepository.findOne(id);
    studentFromDb.setAge(student.getAge());
    studentRepository.save(studentFromDb);
  }

  @RequestMapping(value = "student/{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable long id) {
    studentRepository.delete(id);
  }

  @RequestMapping(value = "students/custom", method = RequestMethod.GET)
  public List<Student> getAllCustom() {
    return studentRepository.findByFirstname("John");
  }

  @RequestMapping(value = "students/custom2", method = RequestMethod.GET)
  public List<Student> getAllCustom2() {
    return studentRepository.findByLastnameCustom("Wayne");
  }
}
