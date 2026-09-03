package de.zhovk.id.account.dto;

import jakarta.validation.constraints.Email;
import java.time.LocalDate;

public record UpdateAccountRequest(@Email String email, String language, LocalDate birthday) {}
