package de.zhovk.id.account.service;

import java.util.UUID;

import de.zhovk.id.account.dto.AccountResponse;
import de.zhovk.id.account.dto.CreateAccountRequest;
import de.zhovk.id.account.dto.UpdateAccountRequest;

public interface AccountService {

	AccountResponse getAccount(UUID id);

	AccountResponse createAccount(CreateAccountRequest request);

	AccountResponse updateAccount(UUID id, UpdateAccountRequest request);

	void deleteAccount(UUID id);
}
