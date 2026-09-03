package de.zhovk.id.privilege.entity;

import de.zhovk.id.common.entity.BaseEntity;
import de.zhovk.id.role.entity.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import java.util.Collection;

@Entity
public class Privilege extends BaseEntity {
  private String name;

  @ManyToMany(mappedBy = "privileges")
  private Collection<Role> roles;
}
