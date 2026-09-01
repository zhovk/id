package de.zhovk.id.privilege.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.zhovk.id.privilege.entity.Privilege;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, UUID> {

}
