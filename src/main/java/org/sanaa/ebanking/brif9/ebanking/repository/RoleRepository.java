package org.sanaa.ebanking.brif9.ebanking.repository;

import org.sanaa.ebanking.brif9.ebanking.models.entity.EbankRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<EbankRole , Long>{
}
