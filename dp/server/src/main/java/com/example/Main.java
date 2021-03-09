package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Main {

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

  @EventListener(ApplicationReadyEvent.class)
  public void doSomethingAfterStartup() {

  }
}