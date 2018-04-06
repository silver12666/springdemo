package com.akhambir.services;

import org.springframework.mail.SimpleMailMessage;

public interface MailService {

    void send(SimpleMailMessage message);

}
