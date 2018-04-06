package com.akhambir.services;

import com.akhambir.model.User;

public interface NotificationService {
    void sendAccountActivation(User user);
}
