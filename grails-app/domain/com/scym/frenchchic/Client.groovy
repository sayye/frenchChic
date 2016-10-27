package com.scym.frenchchic
import grails.rest.Resource


@Resource(uri = '/clients', formats = ['json','xml'])
class Client {
    String numeroClient;
    String nom;
    static belongsTo = [login:Login];

    static constraints = {
        numeroClient nullable: true
        nom blank: false
    }
}
