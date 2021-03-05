package com.kaltura.core.rest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class SpecManager {

    @Value("${kaltura.url}")
    private String kalturaURL;
    @Value("${common.user.service.uri}")
    private String userServiceUri;

    public RequestSpecification initSpec() {

        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(kalturaURL + userServiceUri)
                .setUrlEncodingEnabled(false)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

}
