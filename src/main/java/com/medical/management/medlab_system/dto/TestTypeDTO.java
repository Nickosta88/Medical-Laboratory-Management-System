package com.medical.management.medlab_system.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TestTypeDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    @DecimalMin(value = "0.0",message = "Price can't be lower than 0")
    private BigDecimal price;

}
