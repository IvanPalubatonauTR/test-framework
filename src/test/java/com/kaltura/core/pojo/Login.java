package com.kaltura.core.pojo;

import lombok.Builder;

@Builder
public class Login {
    private String apiVersion;
    private int partnerId;
    private String username;
    private String password;
    private ExtraParams extraParams;
}
