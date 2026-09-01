package de.zhovk.id.account.dto;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;

import de.zhovk.id.role.entity.Role;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record AccountResponse(UUID id, String username, String email, String language, LocalDate birthday,
		@JsonInclude(JsonInclude.Include.NON_EMPTY) Set<Role> roles) {

}
