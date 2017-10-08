package com.example.demo.repository;

import com.example.demo.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

  List<Student> findByFirstname(String firstname);

  @Query("from Student s where s.lastname = :lastname")
  List<Student> findByLastnameCustom(@Param("lastname") String lastname);

}
