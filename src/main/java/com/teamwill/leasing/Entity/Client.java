package com.teamwill.leasing.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teamwill.leasing.Entity.Enum.Gender;
import com.teamwill.leasing.Entity.Enum.TypePersonne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //pp
    @Column (length = 60)
    private String lastName;
    private Boolean isDeleted;
    @Column (length = 60)
    private String firstName;
    @Enumerated(EnumType.STRING)
    @Column (length = 15)
    private Gender gender;
    private Date birthDate;
    @Column (length = 30)
    private String birthplace;
    private String jobTitle;
    private String maritalStatus;
    private String salaire;
    //shared between pp and pm
    @Column (length = 15)
    private String phoneNumber;
    @Column (length = 15)
    private String landLine;
    @Column (length = 30)
    private String email;
    private Date creationDate;
    private String legalStatusPm;
    private Boolean resident;
    private String nationality;
    private String password;
    //pm
    @Column(length = 13)
    private String commercialRegisterNumber;
    @Column(length=10)
    private String fiscalNumber;
    @Column(length = 90)
    private String companyName;
    @Column(length = 30)
    private String logo;
    private String typePm;
    private String legalFormPm;
    private String activityPm;
    private String regimePm;
    private Date legalStatusDate;
    private Long capitalAmount;
    private String webSite;
    private String document;



    @OneToMany(mappedBy = "client")
    private List<Identity> identities;
    @OneToMany (mappedBy = "client")
    private List<Address> addresses;
    @JsonIgnore
    @OneToMany(mappedBy = "client",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<DemandeDeCredit> DemandesDeCredit;

    @Enumerated(EnumType.STRING)
    private TypePersonne type;

}
