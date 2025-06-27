package com.medical.management.medlab_system.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "test_requests")
public class TestRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "test_type_id", nullable = false)
    private TestType testType;

    @NotBlank
    private String status;

    private LocalDate requestedAt;

    private LocalDate tentativeDate;

    private String comment;


    @PrePersist
    protected void onCreate() {
        this.requestedAt = LocalDate.now();
        if (this.status == null) {
            this.status = "Pending";
        }
    }
}
