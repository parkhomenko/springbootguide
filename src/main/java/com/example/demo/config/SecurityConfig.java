package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  DataSource dataSource;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .authorizeRequests()
      .antMatchers(
        "/",
        //"/students",
        "/index.html",
        "/h2database"
      ).permitAll()
      .antMatchers("/students").hasAuthority("USER")
      .antMatchers("/student/**").hasAuthority("ADMIN")
      .and()
      .httpBasic()
      .and()
      .csrf().disable();

  }

  @Override
  public void configure(WebSecurity webSecurity) {
    webSecurity
      .ignoring()
      .antMatchers("/static/**")
      .antMatchers("/h2database/**");
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.jdbcAuthentication().dataSource(dataSource)
      .usersByUsernameQuery(
        "select u.login as username, u.password, u.enable as enabled from users1 u where u.login=?")
      .authoritiesByUsernameQuery(
        "select u.login as username, r.name as role from user_roles ur join roles r on ur.role_id = r.id join users1 u on ur.user_id = u.id where u.login=?");
    //auth.inMemoryAuthentication().withUser("test").password("test").roles("USER");

  }

  /*
  @Bean
  public PasswordEncoder passwordEncoder() {
    PasswordEncoder encoder = new BCryptPasswordEncoder();
    return encoder;
  }
  */

}
