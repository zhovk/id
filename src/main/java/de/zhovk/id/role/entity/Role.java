package de.zhovk.id.role.entity;

import java.util.Collection;

import de.zhovk.id.common.entity.BaseEntity;
import de.zhovk.id.privilege.entity.Privilege;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Role extends BaseEntity {

	private String name;
	
	@ManyToMany
    private Collection<Privilege> privileges;
}
