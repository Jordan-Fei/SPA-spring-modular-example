app.controller('MenuController', function($scope, MenuService){
	$scope.init = function() {
		MenuService.getMenus().then(function(response) {
            $scope.menuItems = response;
        });
	};
});