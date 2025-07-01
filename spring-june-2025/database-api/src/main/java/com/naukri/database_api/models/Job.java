package com.naukri.database_api.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String state;
    @Column(nullable = false)
    String shortDescription;
    @Column(nullable = false)
    String location;
    @Column(nullable = false)
    String jobDescription;
    @OneToOne
    Company company;
    @OneToOne
    ApplicationForm applicationForm;
    @ManyToOne
    AppUser createdBy; // This is the recruiter who created the job
    LocalDateTime postedDate;
    int totalApplicants;
    @CreationTimestamp
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime updatedAt;
    @ManyToMany
    List<Skill> skills;
    @OneToMany
    List<FormSubmission> jobApplications;
}
