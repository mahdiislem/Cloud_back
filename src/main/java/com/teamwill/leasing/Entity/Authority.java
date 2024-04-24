package com.teamwill.leasing.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Authority {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String role;
    @Column(length = 100)
    private String label;

    @JsonIgnore
    @ManyToMany(mappedBy="authorities")
    private List<User> users;

    @ManyToOne
    Authority authority;
    @JsonIgnore
    @OneToMany(mappedBy="authority")
    private List<Authority> authorities;
}
