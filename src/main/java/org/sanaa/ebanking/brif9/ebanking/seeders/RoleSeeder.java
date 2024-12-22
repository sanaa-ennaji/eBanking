package org.sanaa.ebanking.brif9.ebanking.seeders;

import org.sanaa.ebanking.brif9.ebanking.models.entity.EbankRole;
import org.sanaa.ebanking.brif9.ebanking.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class RoleSeeder implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleSeeder(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) {
        if (roleRepository.count() == 0) {
            EbankRole adminRole = new EbankRole();
            adminRole.setRoleName("ROLE_ADMIN");

            EbankRole userRole = new EbankRole();
            userRole.setRoleName("ROLE_USER");

            roleRepository.save(adminRole);
            roleRepository.save(userRole);

            System.out.println("Roles seeded: ROLE_ADMIN, ROLE_USER");
        }
    }
}
