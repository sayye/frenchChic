import com.scym.frenchchic.Client
import com.scym.frenchchic.Login
import com.scym.frenchchic.Produit

class BootStrap {

    def init = { servletContext ->
        Login login = new Login(pseudo: "test", mdp: "test");

        Client client = new Client(nom: "scym", numeroClient:"FR-789-098-123-675")
        login.setClient(client);
        login.save(flush: true);
        //client.save(flush:true)

        Produit produit = new Produit(libelle: "UML in Action", description: "Livre sur la conception avec la notation UML", ht: 20.0F, qteEnStock: 10,produitDuJour: true);
        produit.save(flush:true)

        Produit produit2 = new Produit(libelle: "Chaussures Rikiel ", description: "Paire de chaussures Rikiel", ht: 80.0F, qteEnStock: 10,produitDuJour: false);
        produit2.save(flush:true)

        Produit produit3 = new Produit(libelle: "Parfum Hugo Boss", description: "Hugo Boss for men n 6", ht: 60.0F, qteEnStock: 10,produitDuJour: false);
        produit3.save(flush:true)

    }
    def destroy = {
    }
}
