package org.sanaa.ebanking.brif9.ebanking.models.dto.Request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
    @NotNull
    private String userName;
    @NotNull
    private String password;
    @NotNull
    private long roleId;
}
