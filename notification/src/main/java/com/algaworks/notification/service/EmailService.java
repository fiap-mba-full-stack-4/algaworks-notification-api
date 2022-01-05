package com.algaworks.notification.service;

import com.algaworks.notification.model.dto.WelcomeEmailRequestDTO;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {

  public void sendUserWelcomeEmail(WelcomeEmailRequestDTO email);
}
