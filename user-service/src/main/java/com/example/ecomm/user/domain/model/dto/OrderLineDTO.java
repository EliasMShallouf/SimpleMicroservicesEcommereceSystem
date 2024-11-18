package com.example.ecomm.user.domain.model.dto;

import java.io.Serializable;

public record OrderLineDTO(
    Integer id,
    Integer lineNumber,
    String orderId,
    String productId,
    Double price,
    Double qty,
    Double discount
) implements Serializable { }