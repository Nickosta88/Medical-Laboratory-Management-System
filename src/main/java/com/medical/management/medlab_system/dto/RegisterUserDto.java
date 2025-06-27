package com.medical.management.medlab_system.dto;

import com.medical.management.medlab_system.validation.groups.OnRegisterPatient;
import lombok.Data;

import java.time.LocalDate;

import jakarta.validation.constraints.*;

@Data
public class RegisterUserDto {

    @Email(message = "Invalid email format")
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, and one digit"
    )
    private String password;

    @NotBlank
    private String telegramUsername;

    @NotBlank(groups = OnRegisterPatient.class)
    private String firstName;

    @NotBlank(groups = OnRegisterPatient.class)
    private String lastName;

    @Past
    @NotNull(groups = OnRegisterPatient.class)
    private LocalDate birthDate;

    @NotBlank(groups = OnRegisterPatient.class)
    private String phone;
}
