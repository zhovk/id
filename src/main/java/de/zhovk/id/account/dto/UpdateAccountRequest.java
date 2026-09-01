package de.zhovk.id.account.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;

public record UpdateAccountRequest(@Email String email, String language, LocalDate birthday) {

}
