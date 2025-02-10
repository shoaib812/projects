package com.nihongo.model.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeePostRequest {

    private String username;

    private String email;

    private String dob;

    private String address;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }
}
