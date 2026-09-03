package de.zhovk.id.account.dto;

import de.zhovk.id.account.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
    componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AccountMapper {

  AccountResponse toResponse(Account account);

  @Mappings({
    @Mapping(target = "id", ignore = true),
    @Mapping(target = "createdAt", ignore = true),
    @Mapping(target = "updatedAt", ignore = true),
    @Mapping(target = "deletedAt", ignore = true),
    @Mapping(target = "language", ignore = true),
    @Mapping(target = "birthday", ignore = true),
    @Mapping(target = "roles", ignore = true)
  })
  Account toInstance(CreateAccountRequest request);

  @Mappings({
    @Mapping(target = "id", ignore = true),
    @Mapping(target = "createdAt", ignore = true),
    @Mapping(target = "updatedAt", ignore = true),
    @Mapping(target = "deletedAt", ignore = true),
    @Mapping(target = "username", ignore = true),
    @Mapping(target = "password", ignore = true),
    @Mapping(target = "roles", ignore = true)
  })
  void updateAccountFromDto(UpdateAccountRequest request, @MappingTarget Account account);
}
