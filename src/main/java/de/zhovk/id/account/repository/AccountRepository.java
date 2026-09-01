package de.zhovk.id.account.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.zhovk.id.account.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {

}
