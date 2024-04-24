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
public class IdentityDto {
    private Long id;
    private String numeroIdentity;
    private Date expirationDate;
    private Date dateOfIssue;
    private String PlaceOfIssue;
    private Long identityTypeId;


}
