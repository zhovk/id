package de.zhovk.id.privilege.repository;

import de.zhovk.id.privilege.entity.Privilege;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, UUID> {}
