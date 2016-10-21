import com.scym.frenchchic.Client
import com.scym.frenchchic.Produit

class BootStrap {

    def init = { servletContext ->
        Client client = new Client(login: "scym", mdp: "scym", nom: "scym", numeroClient:"FR-789-098-123-675")
        client.save(flush:true)

        Produit produit = new Produit(libelle: "UML in Action", description: "Livre sur la conception avec la notation UML", ht: 20.0F, qteEnStock: 10,produitDuJour: true);
        produit.save(flush:true)

    }
    def destroy = {
    }
}
