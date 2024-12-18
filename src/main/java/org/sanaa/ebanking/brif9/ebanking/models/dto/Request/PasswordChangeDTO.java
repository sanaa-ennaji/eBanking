package org.sanaa.ebanking.brif9.ebanking.models.dto.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordChangeDTO {
    @NotBlank(message = "Current password must not be empty")
    private String currentPassword;

    @NotBlank(message = "New password must not be empty")
    @Size(min = 8, message = "New password must be at least 8 characters long")
    private String newPassword;
}
