package com.medical.management.medlab_system.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class TestRequestResponseDTO {
    private Long id;
    private String patientEmail;
    private String testTypeName;
    private LocalDate requestedDate;
    private LocalDate tentativeDate;
    private String comment;
    private String status;
}
