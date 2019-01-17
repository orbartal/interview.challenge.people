(function () {
    'use strict';
	
    var app = angular.module('myApp');
	app.config(function($routeProvider, $locationProvider) {
		$locationProvider.hashPrefix('!');
		$routeProvider.otherwise({redirectTo: '/page1'});
		$routeProvider
		.when("/page1", {
			templateUrl: 'app/pages/page1/page1.html',
			controller: 'PeopleCtrl as vm'
		})
		.when("/page2", {
			templateUrl: 'app/pages/page2/page2.html',
			controller: 'PieChartCtrl as vm'
		})
	});
})();