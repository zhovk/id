package de.zhovk.id.account.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.zhovk.id.account.dto.AccountMapper;
import de.zhovk.id.account.dto.AccountResponse;
import de.zhovk.id.account.dto.UpdateAccountRequest;
import de.zhovk.id.account.entity.Account;
import de.zhovk.id.account.repository.AccountRepository;
import de.zhovk.id.exception.NotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements IAccountService {

	private final AccountRepository accountRepository;
	private final AccountMapper accountMapper;

	@Override
	@Transactional(readOnly = true)
	public AccountResponse getAccount(UUID id) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Account not found with ID: " + id));
		return accountMapper.toResponse(account);
	}

	@Override
	@Transactional
	public AccountResponse updateAccount(UUID id, UpdateAccountRequest request) {
		Account account = accountRepository.findById(id).orElseThrow(() -> new NotFoundException("Account not found"));

		accountMapper.updateAccountFromDto(request, account);

		return accountMapper.toResponse(accountRepository.save(account));
	}

	@Override
	@Transactional
	public void deleteAccount(UUID id) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Account not found with ID: " + id));

		account.delete();
		accountRepository.save(account);
	}

}
