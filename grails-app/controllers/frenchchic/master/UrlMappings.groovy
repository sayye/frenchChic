package frenchchic.master

class UrlMappings {

    static mappings = {
        "/produits" (resources: 'produit')
        "/clients" (resources: 'client')
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')

    }
}
