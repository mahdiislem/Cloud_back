package com.teamwill.leasing.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Identity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 20)
    private String identityNumber;
    private Date expirationDate;
    private Date dateOfIssue;
    @Column(length = 60)
    private String PlaceOfIssue;
    private String identityType;
    @ManyToOne
    private Client client;

}
