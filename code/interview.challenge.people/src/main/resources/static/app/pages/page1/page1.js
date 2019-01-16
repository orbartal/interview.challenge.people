'use strict';

angular.module('myApp.page1', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/page1', {
    templateUrl: 'page1/page1.html',
    controller: 'Page1Ctrl'
  });
}])

.controller('Page1Ctrl', [function() {

}]);