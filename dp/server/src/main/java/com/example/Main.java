package com.example;

import com.example.facade.IntegrationFacade;
import com.example.proxy.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Main {

  private BookRepository bookRepository;

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

  @EventListener(ApplicationReadyEvent.class)
  public void doSomethingAfterStartup() {
//    proxy();
//    facade();
  }

  private void facade() {
    IntegrationFacade integrationFacade = new IntegrationFacade();
    System.out.println(integrationFacade.integratePolynomial(new double[]{0, 0, 2}, 0, 2)); // 2*x^3 / 3 = 5.33
  }

  private void proxy() {
    Book bookProxy = bookRepository.getOne(382);
    System.out.println(bookProxy.getClass());
    String title = bookProxy.getTitle();
    System.out.println(title);

    Book realBook = bookRepository.findById(390).orElse(null);
    System.out.println(realBook.getClass());
    title = realBook.getTitle();
    System.out.println(title);
  }

  @Autowired
  public void setBookRepository(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }
}