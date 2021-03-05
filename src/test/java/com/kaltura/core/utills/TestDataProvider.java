package com.kaltura.core.utills;

import com.kaltura.core.pojo.Login;
import com.kaltura.core.pojo.Register;
import com.kaltura.core.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class TestDataProvider {

    public User createUserObject(String userName, String externalId) {
        return User.builder()
                .objectType("KalturaOTTUser")
                .username(userName)
                .firstName("ott_user_lWkiwzTJJGYI")
                .lastName("1585130417330")
                .email("QATest_1585130417313@mailinator.com")
                .address("ott_user_lWkiwzTJJGYI fake address")
                .city("ott_user_lWkiwzTJJGYI fake city")
                .countryId(5)
                .externalId(externalId)
                .build();
    }

    public Register createRegisterObject(User user, String password) {
        return Register.builder()
                .apiVersion("5.3.0")
                .partnerId(3197)
                .user(user)
                .password(password)
                .build();
    }

    public Login createLoginObject(String userName, String password) {
        return Login.builder()
                .apiVersion("5.3.0")
                .partnerId(3197)
                .username(userName)
                .password(password)
                .build();
    }
}
