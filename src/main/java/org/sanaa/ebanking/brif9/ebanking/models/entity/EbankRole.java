package org.sanaa.ebanking.brif9.ebanking.models.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class EbankRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String roleName;
}
