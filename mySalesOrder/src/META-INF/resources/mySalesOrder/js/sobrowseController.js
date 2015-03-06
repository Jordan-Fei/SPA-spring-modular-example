app.controllerProvider.register('soBrowseController', function($scope, $route, $routeParams, $location, $rootScope, SalesOrderService){
	
	$rootScope.loadResource('/resources/css/so_browse.css');
	
	$scope.gridOptions = { 
	    data: 'soData',
	    columnDefs: [{field:'so_nbr', displayName:'SO Nbr'}, {field:'so_cust', displayName:'Customer'}, {field:'so_date', displayName:'Date'}]
	};
	
	$scope.browseSO = function(cust_f){
		$scope.soData = [];
		
		SalesOrderService.browseSO(cust_f).then(function(response){
			var soList = response;
			var index;
			if(angular.isArray(soList)){
				for(index = 0; index < soList.length; index++){
					$scope.soData[index] = {so_nbr:soList[index].so_nbr, so_cust:soList[index].so_cust, so_date:soList[index].so_date};
				}
			}
		});
	};
	
	$scope.fiterSO = function(){
		if($scope.cust_filter != null){
			$scope.browseSO($.trim($scope.cust_filter));
		}
	};
	
	$scope.browseSO('');
});