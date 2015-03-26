app.controller('MenuController', function($scope, $rootScope, MenuService){
	$scope.init = function() {
		MenuService.getMenus().then(function(response) {
            $scope.menuItems = response;
        });
	};
});