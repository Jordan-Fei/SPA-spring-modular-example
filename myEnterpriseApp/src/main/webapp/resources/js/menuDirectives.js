app.directive('collection', function () {
  return {
      restrict: "E",
      replace: true,
      scope: {
          collection: '='
      },
      template: "<member ng-repeat='member in collection' member='member'></member>"
  }
});

app.directive('member', function ($compile, $rootScope) {
  return {
      restrict: "E",
      replace: true,
      scope: {
          member: '='
      },
      template: "<li><a>{{member.name}}</a></li>",
      link: function (scope, element, attrs) {
    	  element.find("a").attr("href",  $rootScope.baseUrl + scope.member.path);
          if (angular.isArray(scope.member.children)) {
              element.append("<ul class='dropdown-menu'><collection collection='member.children'></collection></ul>");
              element.addClass("dropdown");
              element.find("a").addClass("dropdown-toggle");
              element.find("a").attr("data-toggle", "dropdown");
              element.find("a").append("<span class='caret'>");
              $compile(element.contents())(scope);
          }
      }
  }
});

