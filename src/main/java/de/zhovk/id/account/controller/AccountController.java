package de.zhovk.id.account.controller;

import de.zhovk.id.account.dto.AccountResponse;
import de.zhovk.id.account.dto.CreateAccountRequest;
import de.zhovk.id.account.dto.UpdateAccountRequest;
import de.zhovk.id.account.service.AccountService;
import de.zhovk.id.common.entity.ApiResponse;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/account")
@RestController
@RequiredArgsConstructor
public class AccountController {

  private final AccountService accountService;

  @GetMapping("/{id}")
  public ResponseEntity<ApiResponse<AccountResponse>> getAccount(@PathVariable UUID id) {
    AccountResponse response = accountService.getAccount(id);
    return ResponseEntity.ok(
        ApiResponse.success(response, "Account found successfully", "/api/v1/account/" + id));
  }

  @PostMapping
  public ResponseEntity<ApiResponse<AccountResponse>> createAccount(
      @RequestBody CreateAccountRequest request) {

    AccountResponse response = accountService.createAccount(request);

    return ResponseEntity.ok(
        ApiResponse.success(response, "Account created succesfully", "/api/v1/account"));
  }

  @PutMapping("/{id}")
  public ResponseEntity<ApiResponse<AccountResponse>> updateAccount(
      @PathVariable UUID id, @RequestBody UpdateAccountRequest request) {

    AccountResponse response = accountService.updateAccount(id, request);
    return ResponseEntity.ok(
        ApiResponse.success(response, "Account updated successfully", "/api/v1/account/" + id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteAccount(@PathVariable UUID id) {
    accountService.deleteAccount(id);
    return ResponseEntity.noContent().build();
  }
}
