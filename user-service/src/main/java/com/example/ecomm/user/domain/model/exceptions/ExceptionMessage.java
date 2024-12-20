package com.example.ecomm.user.domain.model.exceptions;

public record ExceptionMessage(
    String timestamp,
   int status,
   String error,
   String message,
   String path
) { }
