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
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String phoneNumber;
    private Date birthDate;
    private Date creationDate;
    private Boolean isEnabled;
    private Boolean isDeleted;
    private String lastPassword;
    private Boolean forgotPassword;
    private String token;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Authority> authorities;

    @Transient
    private List<Integer> authoritiesId;
}
