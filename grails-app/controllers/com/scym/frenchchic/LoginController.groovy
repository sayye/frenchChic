package com.scym.frenchchic

import grails.converters.JSON
import grails.rest.RestfulController

class LoginController /*extends RestfulController*/{

    def authenticate() {
        def currentParentData=request.JSON;
        def pseudo= currentParentData.pseudo;
        def mdp=currentParentData.mdp;
        Login login=Login.findByPseudo(pseudo);
        Client client=null;
        if(login!=null && login.getMdp().equals(mdp)){
               client= login.getClient();
        }
        render client as JSON;

    }
    def index() { }
}
