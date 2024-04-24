package com.teamwill.leasing.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FournisseurDto {
    private Long id;
    private String lastName;
    private String firstName;
    private Date birthDate;
    private String birthPlace;
    private String phoneNumber;
    private String email;
    private String codePostal;
    private String ville;
}
