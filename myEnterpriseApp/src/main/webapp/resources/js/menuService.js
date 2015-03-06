app.service('MenuService', function($http, $q){
	this.getMenus = function(){
		var d = $q.defer();
		
		$http.get('menu').success(function(response) {
			d.resolve(response);
		});
		
		return d.promise;
	};
});