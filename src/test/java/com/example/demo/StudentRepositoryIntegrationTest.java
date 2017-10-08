package com.example.demo;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentRepositoryIntegrationTest {

  @Autowired
  StudentRepository studentRepository;

  @Test
  public void shouldReturnAllStudents() {
    List<Student> students = studentRepository.findAll();
    assertThat(students.size(), is(2));
  }
}
