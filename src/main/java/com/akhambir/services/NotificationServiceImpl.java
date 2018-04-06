package com.akhambir.services;

import com.akhambir.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;
import java.util.function.Function;


@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private MailService mailService;

    //TODO create map with messages and topics.

    @Override
    public void sendAccountActivation(User user) {
        SimpleMailMessage message = createMessage(user);
        mailService.send(message);
    }

    private SimpleMailMessage createMessage(User user) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setText(getActivationUrl(user.getActivationToken()));
        message.setSubject("Account Activation");
        return message;
    }

    private String getActivationUrl(String string) {
        return String.format("http://localhost:8080/activate-user/%s", string);
    }
}
