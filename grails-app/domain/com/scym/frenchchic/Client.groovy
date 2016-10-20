package com.scym.frenchchic

class Client {
    String numeroClient
    String login
    String mdp
    String nom

    static constraints = {
        numeroClient nullable: true
        login blank: false
        mdp blank: false
        nom blank: false
    }
}
