package com.medical.management.medlab_system.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class TestRequestDTO {

    @Email
    @NotBlank
    private String patientEmail;

    @NotNull
    private String testTypeName;

    @NotNull
    private String labTelegramUsername;

    @NotNull
    private LocalDate tentativeDate;

    private String comment;
}