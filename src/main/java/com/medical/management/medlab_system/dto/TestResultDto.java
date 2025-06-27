package com.medical.management.medlab_system.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class TestResultDto {

    @NotBlank
    private String testRequest;

    @NotBlank
    private String resultData;


    private LocalDate readyAt;

    @NotBlank
    private String labTechnicianId;

}
