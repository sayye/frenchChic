import com.scym.frenchchic.Client

class BootStrap {

    def init = { servletContext ->
        Client client = new Client(login: "scym", mdp: "scym", nom: "scym")
        client.save(flush:true)
    }
    def destroy = {
    }
}
