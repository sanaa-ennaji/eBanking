package org.sanaa.ebanking.brif9.ebanking.models.dto.Request;

import lombok.Data;

@Data
public class PasswordChangeDTO {
    private String currentPassword;
    private String newPassword;
}
