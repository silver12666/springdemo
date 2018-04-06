package com.akhambir.services;

import com.akhambir.configuration.AppConfig;
import com.akhambir.dao.UserDao;
import com.akhambir.model.User;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static com.akhambir.model.User.AccountStatus.PENDING_ACTIVATION;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServiceTestConfiguration.class)
public class UserServiceImplTest {

    @Mock
    private BCryptPasswordEncoder encoder;

    @Mock
    private NotificationService notificationService;

    @Mock
    private UserDao userDao;

    @Autowired
    @InjectMocks
    private UserServiceImpl userService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Ignore
    public void addUser() throws Exception {
        when(encoder.encode(any(String.class))).thenReturn("encodedPass");
        doNothing().when(notificationService).sendAccountActivation(any(User.class));
        User expectedResult = new User();
        expectedResult.setStatus(PENDING_ACTIVATION);
        expectedResult.setRegisterDate(LocalDateTime.now());
        expectedResult.setId(1L);
        when(userDao.addUser(any(User.class))).thenReturn(expectedResult);

        assertEquals(expectedResult, userService.addUser(new User()));
    }
}