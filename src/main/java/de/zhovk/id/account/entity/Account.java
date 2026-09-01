package de.zhovk.id.account.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import de.zhovk.id.common.entity.BaseEntity;
import de.zhovk.id.role.entity.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@EqualsAndHashCode
public class Account extends BaseEntity {

	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;

	private String language = "en";

	private LocalDate birthday;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "account_roles", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<Role>();
}