package com.teamwill.leasing.Dto;

import com.teamwill.leasing.Entity.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PhysicalClientDto {
    private Long id;
    private String phoneNumber;
    private String landLine;
    private String email;
    private String password;
    private Date creationDate;
    private String legalStatusPm;
    private Boolean resident;
    private String nationality;
    private String lastName;
    private String firstName;
    private Gender gender;
    private Date birthDate;
    private String birthplace;
    private String jobTitle;
    private String maritalStatus;
    private String salaire;
    private String document;
}
