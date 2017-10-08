package com.example.demo;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.demo.controller.StudentController;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentControllerTestWithSpring {

  @MockBean
  private StudentRepository studentRepository;

  @Autowired
  StudentController studentController;

  @Test
  public void testGetStudent() {
    Student student = new Student();
    student.setId(1L);
    when(studentRepository.findOne(1L)).thenReturn(student);

    Student st = studentController.get(1L);

    verify(studentRepository).findOne(1L);

    assertThat(st.getId(), is(1L));
  }
}
