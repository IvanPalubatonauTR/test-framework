package com.epam.test.api.restassured;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static com.epam.core.utills.ObjectMapperHelper.convertFromJsonToMap;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;


public class HealthCheckTest extends BaseTestAPI {

    @Test
    public void localLoginTest() {
        Response response = given().
                spec(spec).
                when().
                get("user");

        Map<String, Object> jsonMap = convertFromJsonToMap(response.getBody().print());

        assertThat(jsonMap.get("userId")).isEqualTo("ivan_palubatonau");
    }

}
