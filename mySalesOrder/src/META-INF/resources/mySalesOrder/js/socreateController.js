app.controllerProvider.register('salesOrderController', function($scope, $route, $routeParams, $location, $rootScope, SalesOrderService){
	$scope.orderInfo = {};
	
	/* Lazy loading css files*/
	$rootScope.loadResource('/resources/css/so_create.css');
	
	/* Date control*/
	$scope.today = function() {
	    $scope.orderInfo.so_date = new Date();
	  };
	  $scope.today();

	  $scope.clear = function () {
	    $scope.orderInfo.so_date = null;
	  };

	  $scope.toggleMin = function() {
	    $scope.minDate = $scope.minDate ? null : new Date();
	  };
	  $scope.toggleMin();

	  $scope.open = function($event) {
	    $event.preventDefault();
	    $event.stopPropagation();

	    $scope.opened = true;
	  };

	  $scope.dateOptions = {
	    formatYear: 'yy',
	    startingDay: 1
	  };
	  
	  /* Commit sales order */
	  $scope.commitSO = function(){
		SalesOrderService.commitSO($scope.orderInfo).then(function(response) {
	       $scope.message = response;
		   //Redirect to successful page.
	       $location.path("/page/so/find").search({soNbr:$scope.orderInfo.so_nbr});
	    });
	  };
});