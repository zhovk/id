package de.zhovk.id.account.service;

import java.util.UUID;

import de.zhovk.id.account.dto.AccountResponse;
import de.zhovk.id.account.dto.UpdateAccountRequest;

public interface IAccountService {
	AccountResponse getAccount(UUID id);

	AccountResponse updateAccount(UUID id, UpdateAccountRequest request);

	void deleteAccount(UUID id);
}