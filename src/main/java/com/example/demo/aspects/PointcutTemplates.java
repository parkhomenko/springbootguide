package com.example.demo.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutTemplates {

  @Pointcut("bean(@RestController) || bean(*Repository)")
  public void controllersAndServices() {

  }
}
