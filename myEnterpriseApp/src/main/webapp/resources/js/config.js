app.config([ '$routeProvider', '$httpProvider','$locationProvider','$controllerProvider','$provide', function($routeProvider, $httpProvider, $locationProvider, $controllerProvider, $provide) {

	app.controllerProvider = $controllerProvider;
	app.provide            = $provide;

	/* Another way to lazyly load js file via jQuery $.getScript */
	function controller(name){
	    return {
	        load: function($q, $rootScope){
	            $.getScript('/myEnterpriseApp/resources/js/' + name + '.js');
	        }  
	    };
	}	
	
	// ======= router configuration =============
	/* Resource file Name Convention:
	 * view html file should be named with :businessObject + :action like so_create.html
	 * javascript files: for controller files should be named with :businessObject + :action + 'Controller.js' like socreatController.js
	 *                   for service file should be name with  :businessObject + 'Service.js' like soService.js
	 * Multiple controllers share one service regarding one businessObject.
	 * TO DO: css file should be named with :businessObject + :action + '.css' like socreate.css
	 * */
	$routeProvider.when('/page/:businessObject/:action', {
        templateUrl: function(urlattr){
        	
            /*return '/myEnterpriseApp/' + urlattr.businessObject + 'Resources/views/' + urlattr.businessObject + '_' + urlattr.action + '.html';*/
            
        	var suffix = '.html';
        	return 'resources/views/' + urlattr.businessObject + '_' + urlattr.action + suffix;
        },
        /*resolve:controller('salesOrderController')*/
        
        resolve: {load:function($q, $rootScope, $route){
        	var deferred = $q.defer();
        	
        	var dependencies =
                [
                    '/myEnterpriseApp/resources/js/' + $route.current.params.businessObject + 'Service.js',
                    '/myEnterpriseApp/resources/js/' + $route.current.params.businessObject + $route.current.params.action + 'Controller.js'
                    
                ];
        	

            $script(dependencies, function()
                    {
            	       $rootScope.$apply(function()
                        {
                            deferred.resolve();
                        });
                        
                    });
            
            return deferred.promise;
        }}
    })
    .when('/login',{
    	templateUrl: 'resources/views/login.html'
    })
	/*
	.otherwise({
        template: '<h1>Home</h1>',
        controller: function () {
            console.log('Home');
            }
	})*/;
	
	$locationProvider.html5Mode(true);
	
}]);