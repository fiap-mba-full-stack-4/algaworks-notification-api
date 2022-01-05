package com.algaworks.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotificationApplication {

//  @Autowired
//  private RabbitMQMessageProducer producer;

  public static void main(String[] args) {
    SpringApplication.run(NotificationApplication.class, args);
  }

//  @Override
//  public void run(String... args) throws Exception {
//    System.out.println("Enviando mensagem para fila");
//    WelcomeEmailRequestDTO request = WelcomeEmailRequestDTO.builder()
//        .userEmail("teste@gmail.com")
//        .userName("Aluno Teste")
//        .build();
//
//    producer.publish(request, "internal.exchange", "internal.notification.routing-key");
//  }
}
