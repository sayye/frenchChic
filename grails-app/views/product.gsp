<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>French Chic</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
    <asset:javascript src="angular.min.js" />
    <asset:javascript src="angular-resource.min.js" />
</head>


<script type="application/javascript">
    angular.module('frenchChic', [])
    .controller('Login', function($scope, $http) {
        $scope.username="";
        $scope.mdp="";

        $scope.authenticate = function() {
            var req={
                method: 'POST',
                url: 'http://localhost:8081/application/login/authenticate',
                headers: {
                    'Content-Type': 'application/json'
                },
                data: {pseudo: $scope.username, mdp: $scope.mdp}
            }

            $http(req).then(function (response) {
                $scope.client = response.data;
                console.log("response.data"+JSON.stringify(response.data));
            });
        }
    });



</script>


<div id="content">
    <div ng-app="frenchChic">
        <h1>French Chic</h1>
        <div ng-controller="Login">
            <p>{{client.id}}</p>
        </div>
        <p>{{client.id}}</p>
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
