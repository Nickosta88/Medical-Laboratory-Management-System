package com.medical.management.medlab_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;


    private LocalDate createdAt;

    // later get it from telegram api
    private String telegramUsername;

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private Patient patient;

    @OneToMany(mappedBy = "labTechnician")
    @JsonIgnore
    private Set<TestResult> testResults = new LinkedHashSet<>();

    @OneToMany(mappedBy = "labTechnician")
    private Set<LabTechnicianTestRequest> labTechnicianTestRequests = new LinkedHashSet<>();

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDate.now();
    }
}
