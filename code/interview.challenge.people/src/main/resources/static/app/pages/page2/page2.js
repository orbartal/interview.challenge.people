(function () {
    'use strict';

    function PieChartCtrl(PeopleService) {
    	 var vm = this;
    	 vm.data = [
    			{
    				name : "Blue",
    				value : 10,
    				color : "#4a87ee"
    			},
    			{
    				name : "Green",
    				value : 40,
    				color : "#66cc33"
    			},
    			{
    				name : "Orange",
    				value : 70,
    				color : "#f0b840"
    			},
    			{
    				name : "Red",
    				value : 2,
    				color : "#ef4e3a"
    			}
    		];
    }
    
    var app = angular.module('myApp');
    PieChartCtrl.$inject = ['PeopleService'];
    app.controller('PieChartCtrl', PieChartCtrl);
    
})();