package de.zhovk.id.account.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.zhovk.id.account.dto.AccountMapper;
import de.zhovk.id.account.dto.AccountResponse;
import de.zhovk.id.account.dto.CreateAccountRequest;
import de.zhovk.id.account.dto.UpdateAccountRequest;
import de.zhovk.id.account.entity.Account;
import de.zhovk.id.account.repository.AccountRepository;
import de.zhovk.id.exception.ConflictException;
import de.zhovk.id.exception.NotFoundException;
import jakarta.validation.Valid;
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
	public AccountResponse createAccount(@Valid CreateAccountRequest request) {

		if (accountRepository.findByUsername(request.username()).isPresent()
				|| accountRepository.findByEmail(request.email()).isPresent()) {
			throw new ConflictException("Username or E-Mail already taken.");
		}

		Account account = accountRepository.save(accountMapper.toInstance(request));

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
