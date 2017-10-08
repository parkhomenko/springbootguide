package com.example.demo;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.demo.controller.StudentController;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StudentControllerTest {

  @InjectMocks
  private StudentController studentController;

  @Mock
  private StudentRepository studentRepository;

  /*
  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }
  */

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
