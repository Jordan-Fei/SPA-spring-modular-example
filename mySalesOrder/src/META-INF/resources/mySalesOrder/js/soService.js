app.provide.service('SalesOrderService', function($http, $q){
	this.commitSO = function(so){
		var d = $q.defer();
		
		$http.post('commitSO',so).success(function(response) {
			d.resolve(response);
		});
		
		return d.promise;
	};
	
	this.findSO = function(soNbr){
		var d = $q.defer();
		
		$http.get('findSO', {params:{nbr:soNbr}}).success(function(response) {
			d.resolve(response);
		});
		
		return d.promise;
	};
	
	this.browseSO = function(soCust){
		var d = $q.defer();
		
		$http.get('browseSO',{params:{cust:soCust}}).success(function(response){
			d.resolve(response);
		});
		
		return d.promise;
	}
});