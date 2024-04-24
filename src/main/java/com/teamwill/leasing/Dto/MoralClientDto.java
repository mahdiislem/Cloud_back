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
public class MoralClientDto {
    private Long id;
    private String phoneNumber;
    private String landLine;
    private String email;
    private Date creationDate;
    private String legalStatusPm;
    private Boolean resident;
    private String nationality;
    private String commercialRegisterNumber;
    private String fiscalNumber;
    private String companyName;
    private String logo;
    private String typePm;
    private String legalFormPm;
    private String activityPm;
    private String regimePm;
    private Date legalStatusDate;
    private String webSite;
    private String password;
}
