package de.zhovk.id;

import org.springframework.boot.SpringApplication;

public class TestIdApplication {

  public static void main(String[] args) {
    SpringApplication.from(IdApplication::main).with(TestcontainersConfiguration.class).run(args);
  }
}
