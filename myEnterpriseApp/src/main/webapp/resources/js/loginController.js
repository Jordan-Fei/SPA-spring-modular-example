app.controller('LoginController', function($scope, $rootScope, AuthenticationService, $http, $location){
	$rootScope.isMenuDisplay = false;
	$scope.alerts = [];
	
	$scope.login = function(credentials){
		$scope.alerts = [];
		AuthenticationService.authenticate(credentials.username, credentials.password).then(function(targetPath) {
	        $rootScope.isMenuDisplay = true;
	        $location.path(targetPath);
        },
        function(){
        	$scope.addAlert('danger', 'Invalid credential');
        	//console.log('Invalid credential');
        });
	};	
	
    $scope.addAlert = function(msgType, message) {
      $scope.alerts.push({type:msgType, msg: message});
    };

    $scope.closeAlert = function(index) {
      $scope.alerts.splice(index, 1);
    };	
});