package com.kaltura.core.utills;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.spi.json.JsonProvider;
import org.springframework.stereotype.Component;

@Component
public class ObjectMapperHelper {

    ObjectMapper objectMapper = new ObjectMapper();
    JsonProvider jsonProvider = Configuration.defaultConfiguration().jsonProvider();

    public String convertObjectToJson(Object pojo) {
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        try {
            return objectMapper.writeValueAsString(pojo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public Object convertStringToMap(String string) {
        return jsonProvider.parse(string);
    }
}
