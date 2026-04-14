package com.pm.patientservice.dto;

import com.pm.patientservice.dto.validators.CreatePatientValidationGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientRequestDTO {

    @NotBlank(message = "name is required")
    @Size(max=100,message = "name cannot exceed 100 characters")
    private String name;

    @NotBlank(message = "email is required")
    @Email(message = "email should be valid")
    private String email;

    @NotBlank(message = "address is required")
    private String  address;

    @NotBlank(message = "date of birth is required")
    private String  dateOfBirth;

    @NotBlank(groups = CreatePatientValidationGroup.class,message = "registered date is required")
    private String  registeredDate;
}
