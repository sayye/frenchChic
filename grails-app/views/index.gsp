<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>French Chic</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
    <asset:javascript src="angular.min.js" />
    <asset:javascript src="angular-resource.min.js" />
    <asset:javascript src="angular-cookies.min.js" />
</head>


<script type="application/javascript">
    angular.module('frenchChic', ['ngCookies'])
    .controller('Login', function($scope, $http, $cookies) {
        $scope.username="";
        $scope.mdp="";
        $scope.error=false;
        $scope.empty=false;
        // Retrieving a cookie
        //var favoriteCookie = $cookies.get('myFavorite');
        // Setting a cookie
        //$cookies.put('myFavorite', 'oatmeal');
        //var favoriteCookie = $cookies.get('myFavorite');


        $scope.authenticate = function() {
            if($scope.username && $scope.mdp) {
                var req={
                    method: 'POST',
                    url: 'http://localhost:8081/application/login/authenticate',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    data: {pseudo: $scope.username, mdp: $scope.mdp}
                }

                $http(req).then(function (response) {
                    if(response){
                        $scope.client = response.data;
                        console.log("response.data"+JSON.stringify(response.data));
                        $scope.error = false;
                        $scope.empty = false;

                    }
                    else {
                        console.log("Erreur: reponse vide");
                        $scope.error = true;
                        $scope.empty = false;
                    }
                    console.log(response);
                }, function(data) {
                    console.log("Erreur: reponse vide");
                    $scope.error = true;
                    $scope.empty = false;
                });
            }
            else {
                $scope.empty = true;
            }
        }
    });



</script>


<div id="content">
    <div ng-app="frenchChic">
        <h1>French Chic</h1>
        <div ng-controller="Login">
            <form ng-submit="authenticate()"  method="post" >
                <table>
                    <tr>
                        <td>
                            <label>Pseudo </label>
                        </td>
                        <td>
                            <input type="text" ng-model="username"/>
                        </td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td>
                            <label>Mot de passe </label>
                        </td>
                        <td>
                            <input type="password" ng-model="mdp"/>
                        </td>
                    </tr>
                </table>
            </br>
                <button type="submit">S'identifier</button>
            </form>
            <div ng-if="error">
                <p>
                    Erreur, identification invalide.
                </p>
            </div>
            <div ng-if="empty">
                <p>
                    Veuillez indiquez votre pseudo et votre mot de passe.
                </p>
            </div>
        </div>
    </div>
</div>



<style type="text/css">
#content {
    position: absolute;
    width: 300px;
    height: 200px;
    z-index: 15;
    top: 50%;
    left: 50%;
    margin: -100px 0 0 -150px;
    text-align: center;
}
h1 {
    color:#cc00cc;
    text-align: center;
}
form {
    margin: 0 auto;
}
button {
    border: none;
}
</style>

</body>
</html>
