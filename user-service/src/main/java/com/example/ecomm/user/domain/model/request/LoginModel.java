package com.example.ecomm.user.domain.model.request;

import java.io.Serializable;

public record LoginModel (
    String email,
    String password
) implements Serializable { }