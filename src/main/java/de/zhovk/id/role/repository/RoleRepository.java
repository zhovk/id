package de.zhovk.id.role.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.zhovk.id.role.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {

}
