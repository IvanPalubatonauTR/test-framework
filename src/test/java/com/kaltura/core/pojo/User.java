package com.kaltura.core.pojo;

import lombok.Builder;

@Builder
public class User {
        private String objectType;
        private String username;
        private String firstName;
        private String lastName;
        private String email;
        private String address;
        private String city;
        private Integer countryId;
        private String externalId;
}

