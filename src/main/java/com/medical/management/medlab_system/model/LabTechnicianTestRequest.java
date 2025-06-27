package com.medical.management.medlab_system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lab_technician_test_requests")
public class LabTechnicianTestRequest {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotNull
        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        private TestType testType;

        @NotNull
        private LocalDate assignedAt;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "lab_technician_id")
        private AppUser labTechnician;


}
