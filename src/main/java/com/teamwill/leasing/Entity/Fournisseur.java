package com.teamwill.leasing.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lastName;
    private String firstName;
    private Date birthDate;
    private String birthPlace;
    private String phoneNumber;
    private String email;
    private String ville;
    private Boolean isDeleted;
    private Boolean isEnabled;
    private Date creationDate;

    @OneToMany
    private List<Product> product;


}
