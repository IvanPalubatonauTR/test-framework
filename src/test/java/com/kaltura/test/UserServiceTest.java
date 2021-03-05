package com.kaltura.test;

import com.jayway.jsonpath.JsonPath;
import com.kaltura.service.UserService;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;


public class UserServiceTest extends BaseTestAPI {

    public static final int BOUND = 10000;

    @Autowired
    UserService userService;

    private String userName;
    private String externalId;
    private String password;

    @BeforeClass
    public void setUpData() {
        Random random = new Random();
        userName = String.valueOf(random.nextInt(BOUND));
        externalId = String.valueOf(random.nextInt(BOUND));
        password = String.valueOf(random.nextInt(BOUND));
    }


    @Test
    public void createNewUserTest() {
        Response response = userService.createUser(userName, externalId, password, spec);

        Object document = objectMapperHelper.convertStringToMap(response.getBody().print());

        String id = JsonPath.read(document, "$.result.id");
        int countryId = JsonPath.read(document, "$.result.country.id");

        soft.assertThat(response.getHeader("X-Kaltura-Session")).isNotNull();
        soft.assertThat(id).isNotNull();
        soft.assertThat(countryId).isNotNull();
        soft.assertThat(id).isInstanceOf(String.class);
        soft.assertThat(countryId).isInstanceOf(Integer.class);
        soft.assertAll();
    }

    @Test(dependsOnMethods = {"createNewUserTest"})
    public void loginUserTest() {
        Response response = userService.loginUser(userName, password, spec);

        Object document = objectMapperHelper.convertStringToMap(response.getBody().print());

        List<Integer> lastLoginDateLList = JsonPath.read(document, "$..lastLoginDate");

        Integer lastLoginDate = lastLoginDateLList.get(0);

        soft.assertThat(lastLoginDate).isNotNull();
        //Unfortunately did not get what "lastLoginDate": -62135596800 means so checked it on Int instance
        soft.assertThat(lastLoginDate).isInstanceOf(Integer.class);
        soft.assertAll();
    }

    @Test(dependsOnMethods = {"createNewUserTest"})
    public void repeatRegisterWithSameUserTest() {
        Response response = userService.createUser(userName, externalId, password, spec);

        Object document = objectMapperHelper.convertStringToMap(response.getBody().print());

        List<String> message = JsonPath.read(document, "$..message");

        assertThat(message.get(0)).isEqualTo("User exists");
    }

}
