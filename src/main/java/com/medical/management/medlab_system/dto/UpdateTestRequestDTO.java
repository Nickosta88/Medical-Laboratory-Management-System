package com.medical.management.medlab_system.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateTestRequestDTO {

    @NotBlank
    private String status;
}
