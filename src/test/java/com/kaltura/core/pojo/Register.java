package com.kaltura.core.pojo;

import lombok.Builder;

@Builder
public class Register {
    private String apiVersion;
    private int partnerId;
    private User user;
    private String password;
}
