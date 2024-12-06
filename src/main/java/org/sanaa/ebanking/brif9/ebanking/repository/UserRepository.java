package org.sanaa.ebanking.brif9.ebanking.repository;

import org.sanaa.ebanking.brif9.ebanking.models.entity.EbankUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<EbankUser , Long>  {
    Optional<EbankUser> findByUsername(String username);
}

