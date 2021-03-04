package com.epam.test.api.restassured;

import com.epam.core.config.AppConfig;
import com.epam.core.rest.rest.SpecManager;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.util.ArrayList;
import java.util.List;

@ContextConfiguration(classes = AppConfig.class)
public class BaseTestAPI extends AbstractTestNGSpringContextTests {

    @Autowired
    SpecManager specManager;

    protected RequestSpecification spec;

    @BeforeClass
    public void initSpec() {
        spec = specManager.initSpec();
    }

}
