package com.nihongo.model.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeePutRequest {

    private String username;

    private String mail;

    private String dob;

    private String address;

    public String getUsername() {
        return username;
    }

    public String getMail() {
        return mail;
    }

    public String getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }
}
