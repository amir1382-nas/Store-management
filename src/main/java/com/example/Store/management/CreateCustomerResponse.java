package com.example.Store.management;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCustomerResponse {
    private Long id;
    private String name;
    private String email;
    private String message;

    public CreateCustomerResponse(Long id, String name, String email, String message) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.message = message;
    }
}