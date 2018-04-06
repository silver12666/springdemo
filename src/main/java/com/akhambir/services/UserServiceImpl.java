package com.akhambir.services;

import com.akhambir.dao.UserDao;
import com.akhambir.model.ProductOrder;
import com.akhambir.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import static com.akhambir.model.User.AccountStatus.ACTIVE;
import static com.akhambir.model.User.AccountStatus.PENDING_ACTIVATION;
import static java.util.Collections.emptyList;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private UserDao userDao;

    @Override
    public User addUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRegisterDate(LocalDateTime.now());
        user.setActivationToken(getActivationToken());
        user.setStatus(PENDING_ACTIVATION);
        notificationService.sendAccountActivation(user);
        return userDao.addUser(user);
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User findByToken(String token) {
        return Objects.requireNonNull(userDao.findByToken(token));
    }

    @Override
    public void activate(User user) {
        user.setStatus(ACTIVE);
        userDao.updateUser(user);
    }

    private String getActivationToken() {
        return UUID.randomUUID().toString();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.findByEmail(email);
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), emptyList());
    }
}
