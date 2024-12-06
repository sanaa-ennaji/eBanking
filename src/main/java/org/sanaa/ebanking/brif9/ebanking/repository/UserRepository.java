package org.sanaa.ebanking.brif9.ebanking.repository;

import org.sanaa.ebanking.brif9.ebanking.models.entity.EbankUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<EbankUser , Long>  {

}
