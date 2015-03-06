var app = angular.module('myEnterpriseApp', ['ngRoute','ui.bootstrap', 'ngGrid']);

app.run(function($rootScope, $location, $timeout, $route) {
	$rootScope.baseUrl = "/myEnterpriseApp";
	
	$rootScope.$on("$locationChangeStart", function(event, next, current){
		//$rootScope.loadResource($location.url());
		//event.preventDefault();
	});
	
	$rootScope.loadResource = function(css){
		
		var script = document.querySelector("link[href*='" + css + "']");
		if(!script){
			var heads = document.getElementsByTagName("head");
			if(heads && heads.length){
				var head = heads[0];
				if(head){
					script = document.createElement('link');
                    script.setAttribute('href', $rootScope.baseUrl + css);
                    script.setAttribute('rel', 'stylesheet');
                    script.setAttribute('type', 'text/css');
                    head.appendChild(script);
                   /* 
                    $timeout(function(){
                    	$location.path(path);
                    	$route.reload();
                    	console.log("come back from sleep");
                    	}, 2000); 
					*/
                    /*
					console.log("lazy load: " + css);
					*/
				}
			}
		}
	};
});