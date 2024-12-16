package org.sanaa.ebanking.brif9.ebanking.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDTO {
    private int statusCode;
    private String message;
}
