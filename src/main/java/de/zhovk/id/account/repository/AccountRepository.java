package de.zhovk.id.account.repository;

import de.zhovk.id.account.entity.Account;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {

  Optional<Account> findByUsername(String username);

  Optional<Account> findByEmail(String email);
}
