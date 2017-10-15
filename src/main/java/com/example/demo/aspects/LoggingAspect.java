package com.example.demo.aspects;

import com.example.demo.model.Student;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class LoggingAspect {

  Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

  /*
  @Before("execution(java.util.List<com.example.demo.model.Student> com.example.demo.controller.StudentController.getAll())")
  public void beforeTheMethod() {
    logger.info("at the beginning of a method");
  }

  @Before("execution(* com.example.demo.controller.StudentController.*(..))")
  public void beforeTheMethod2() {
    logger.info("at the beginning of a method 2");
  }

  @After("execution(* com.example.demo.controller.StudentController.*(..))")
  public void beforeTheMethod3() {
    logger.info("at the end of a method");
  }

  @AfterThrowing("execution(* com.example.demo.controller.StudentController.*(..))")
  public void testException() {
    logger.info("after the exception");
  }

  @AfterReturning(value = "execution(* com.example.demo.controller.StudentController.*(..))",
      returning = "students")
  public void testReturning(List<Student> students) {
    logger.info(students.toString());
  }
  */

  /*
  @Around("execution(* com.example.demo.controller.StudentController.*(..))")
  public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    return proceedingJoinPoint.proceed();
  }
  */

  /*
  @AfterThrowing(pointcut = "execution(* com.example.demo.controller.StudentController.*(..))",
  throwing = "exception")
  public void testException(RuntimeException exception) {
    logger.info("after the exception");
  }
  */

  /*
  @Around("execution(* com.example.demo.controller.StudentController.*(..))")
  public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    logger.info(proceedingJoinPoint.getSignature().toString());
    try {
      return proceedingJoinPoint.proceed();
    } catch (RuntimeException exception) {
      return null;
    }
  }
  */

  /*
  @After("execution(@org.springframework.web.bind.annotation.RestController * *(..))")
  public void beforeTheMethod3() {
    logger.info("at the end of a method");
  }

  @After("execution(* (@org.springframework.web.bind.annotation.RestController *).*(..))")
  public void beforeTheMethod4(JoinPoint joinPoint) {
    logger.info(joinPoint.getSignature().toString());
    logger.info("at the end of a method");
  }

  @After("bean(studentController)")
  public void beforeTheMethod5(JoinPoint joinPoint) {
    logger.info(joinPoint.getSignature().toString());
    logger.info("at the end of a method");
  }

  @After("PointcutTemplates.controllersAndServices()")
  public void afterTheMethod6(JoinPoint joinPoint) {
    logger.info("after the method");
  }
  */
}
