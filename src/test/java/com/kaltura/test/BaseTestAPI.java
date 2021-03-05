package com.kaltura.test;

import com.kaltura.core.config.AppConfig;
import com.kaltura.core.rest.SpecManager;
import com.kaltura.core.utills.ObjectMapperHelper;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;

@ContextConfiguration(classes = AppConfig.class)
public class BaseTestAPI extends AbstractTestNGSpringContextTests {

    @Autowired
    SpecManager specManager;

    @Autowired
    ObjectMapperHelper objectMapperHelper;

    protected RequestSpecification spec;

    protected SoftAssertions soft = new SoftAssertions();

    @BeforeClass
    public void initSpec() {
        spec = specManager.initSpec();
    }

}
