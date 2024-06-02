package com.teamwill.leasing.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private Date creationDate;
    private Boolean isDeleted;

    private String prix;

    //pVéhicule
    private String modele;
    private String nbrPlace;
    private String energie;
    private String boite;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<DemandeDeCredit> DemandesDeCredit;
    @ManyToOne
    private ProductType productType;
    public Product(String name,String prix,String modele,String nbrPlace,String energie,String boite,String description) {
    	this.name=name;
    	this.prix=prix;
    	this.modele=modele;
    	this.nbrPlace=nbrPlace;
    	this.energie=energie;
    	this.boite=boite;
    	this.description=description;
    }
}
