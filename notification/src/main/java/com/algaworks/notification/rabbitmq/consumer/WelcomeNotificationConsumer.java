package com.algaworks.notification.rabbitmq.consumer;

import com.algaworks.notification.model.dto.WelcomeEmailRequestDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class WelcomeNotificationConsumer {

  @RabbitListener(queues = "${rabbitmq.queues.notification-welcome-email}")
  public void consumer(WelcomeEmailRequestDTO emailRequest) {
    log.info("Consumed {} from queue", emailRequest);
  }
}
