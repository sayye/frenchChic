package com.scym.frenchchic

class Login {
    String pseudo;
    String mdp;
    static hasOne = [client:Client];

    static constraints = {
    }
}
