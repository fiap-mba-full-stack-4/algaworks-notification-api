package com.algaworks.notification;

import com.algaworks.notification.config.RabbitMQMessageProducer;
import com.algaworks.notification.model.dto.WelcomeEmailRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotificationApplication implements CommandLineRunner {

  @Autowired
  private RabbitMQMessageProducer producer;

  public static void main(String[] args) {
    SpringApplication.run(NotificationApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("### Enviando mensagem para fila");
    WelcomeEmailRequestDTO request = WelcomeEmailRequestDTO.builder()
        .userEmail("algaworks.fiap@gmail.com")
        .userName("Algaworks Fiap")
        .build();

    producer.publish(request, "internal.exchange", "internal.notification.routing-key");
  }
}
