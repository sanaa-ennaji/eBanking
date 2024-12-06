package org.sanaa.ebanking.brif9.ebanking.models.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEmbeddedDTO {
    private Long id ;
    private String username;
}
