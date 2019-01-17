(function () {
    'use strict';

    function PeopleCtrl(PeopleService) {
    	 var vm = this;
	     vm.people = [];
	     vm.lastError= undefined;

	     vm.getAll = function() {
	    	 PeopleService.getAll().then(onSuccess, onFailure);
        	
        	 function onSuccess(data) { 
        		 vm.people = data;
        		 vm.lastError = undefined;
             }

             function onFailure(error) {
            	 vm.people = [];
            	 vm.lastError = error;
             }
        }
	     
	    vm.getAll();
    }
    
    var app = angular.module('myApp');
    PeopleCtrl.$inject = ['PeopleService'];
    app.controller('PeopleCtrl', PeopleCtrl);
    
})();