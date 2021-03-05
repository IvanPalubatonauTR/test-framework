package com.kaltura.service;

import com.kaltura.core.pojo.Login;
import com.kaltura.core.pojo.Register;
import com.kaltura.core.pojo.User;
import com.kaltura.core.utills.ObjectMapperHelper;
import com.kaltura.core.utills.TestDataProvider;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;

@Component
public class UserService {

    @Autowired
    TestDataProvider testDataProvider;

    @Autowired
    ObjectMapperHelper objectMapperHelper;

    public Response createUser(String userName, String externalId, String password, RequestSpecification spec) {
        User user = testDataProvider.createUserObject(userName, externalId);
        Register register = testDataProvider.createRegisterObject(user, password);
        String registerJson = objectMapperHelper.convertObjectToJson(register);
        return given().spec(spec).body(registerJson).post("register");
    }

    public Response loginUser(String userName, String password, RequestSpecification spec) {
        Login login = testDataProvider.createLoginObject(userName, password);
        String loginJson = objectMapperHelper.convertObjectToJson(login);
        return given().spec(spec).body(loginJson).post("login");
    }
}
