package org.sanaa.ebanking.brif9.ebanking.repository;

import org.sanaa.ebanking.brif9.ebanking.models.entity.EbankRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<EbankRole , Long>{
    Optional<EbankRole> findByRoleName(String roleName);
}
