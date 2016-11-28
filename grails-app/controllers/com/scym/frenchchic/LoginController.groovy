package com.scym.frenchchic

import grails.converters.JSON
import grails.rest.RestfulController

class LoginController /*extends RestfulController*/{

    def authenticate() {
        def currentParentData=request.JSON;
        if(currentParentData) {
            def pseudo= currentParentData.pseudo;
            def mdp=currentParentData.mdp;
            if(mdp && pseudo) {
                Login login=Login.findByPseudo(pseudo);
                Client client=null;
                if(login!=null && login.getMdp().equals(mdp)){
                    client= login.getClient();
                    render client as JSON;
                }
                else {
                    response.status = 401;
                }
            }
            else {
                response.status = 401;
            }
        }
        else {
            response.status = 400;
        }
    }
    def index() { }
}
