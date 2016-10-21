package com.scym.frenchchic
import grails.rest.Resource


@Resource(uri = '/clients', formats = ['json','xml'])
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
