package com.scym.frenchchic

class Produit {
    String libelle
    String description
    Float ht
    Integer qteEnStock
    Boolean produitDuJour



    static constraints = {
        libelle blank: true
        description nullable: true, blank: true
        ht nullable: true
        qteEnStock nullable: true
        produitDuJour nullable: true

    }

    static mapping = {
        description type: "text"
    }
}
