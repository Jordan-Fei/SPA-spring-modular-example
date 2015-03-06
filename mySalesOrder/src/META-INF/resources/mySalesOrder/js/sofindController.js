app.controllerProvider.register('salesOrderSummaryController', function($scope, $route, $routeParams, $location, SalesOrderService){
	$scope.orderInfo = {};
	
	$scope.retrieveData= function(){
		var soNbr = $location.search().soNbr;
		
		SalesOrderService.findSO(soNbr).then(function(response) {
            $scope.orderInfo = response;
        });
	};
});