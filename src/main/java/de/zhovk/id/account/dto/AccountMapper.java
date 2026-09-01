package de.zhovk.id.account.dto;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import de.zhovk.id.account.entity.Account;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AccountMapper {

	AccountResponse toResponse(Account account);

	void updateAccountFromDto(UpdateAccountRequest request, @MappingTarget Account account);

}