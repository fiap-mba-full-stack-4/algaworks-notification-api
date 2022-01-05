package com.algaworks.notification.service.impl;

import com.algaworks.notification.model.dto.WelcomeEmailRequestDTO;
import com.algaworks.notification.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

  @Autowired
  private JavaMailSender emailSender;

  @Override
  public void sendUserWelcomeEmail(WelcomeEmailRequestDTO email) {
    log.info("### Iniciando envio de email de boas-vindas.");
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom("noreply@algaworks-fiap.com");
    message.setTo(email.getUserEmail());
    message.setSubject(email.getUserName() + " bem-vindo a plataforma Algaworks-fiap.");
    message.setText("Este é um email de boas-vindas para " + email.getUserEmail() + ".");

    try {
      emailSender.send(message);
      log.info("### Email enviado com sucesso para {}.", email.getUserName());
    } catch (Exception e) {
      log.info("### Falha ao enviar email para {}.", email.getUserName());
      log.error(e.getMessage());
    }

  }
}
