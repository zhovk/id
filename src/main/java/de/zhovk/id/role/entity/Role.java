package de.zhovk.id.role.entity;

import de.zhovk.id.common.entity.BaseEntity;
import de.zhovk.id.privilege.entity.Privilege;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Role extends BaseEntity {

  @Column(nullable = false, unique = true)
  private String name;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "role_privileges",
      joinColumns = @JoinColumn(name = "role_id"),
      inverseJoinColumns = @JoinColumn(name = "privilege_id"))
  private Set<Privilege> privileges = new HashSet<>();
}
