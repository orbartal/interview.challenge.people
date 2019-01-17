(function () {
    'use strict';

    function PeopleCtrl(PeopleService) {
    	 var vm = this;
    	 vm.temp = {};
	     vm.people = [];
	     vm.lastError= undefined;
	     
	     vm.init = function (){
	    	 vm.getPeople();
	     }
	     
	     vm.isValidInputPerson = function() {
	    	 return (!!vm.temp && isValidAge(vm.temp.age) && isValidName(vm.temp.firstName) && isValidName(vm.temp.lastName));
	    
	    	 function isValidAge (age) {
	    		 return (!!age && Number.isInteger(age) && age > 17 && age < 121);
	    	 }
	    	 
	    	 function  isValidName (name) {
	    		 if (typeof name === 'string' || name instanceof String){
	    			 return (name.trim().length > 0); 
	    		 } 
	    		 return false;
	    	 }
	     }
	    	 
	    vm.createPerson = function() {
	    	PeopleService.create(vm.temp).then(onSuccess, onFailure);
	    	
	    	 function onSuccess(data) { 
	    		 vm.temp = {};
        		 vm.lastError = undefined;
        		 vm.getPeople();
             }

             function onFailure(error) {
            	 vm.lastError = error;
             }
	     }

	     vm.getPeople = function() {
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
	     
	    vm.init();
    }
    
    var app = angular.module('myApp');
    PeopleCtrl.$inject = ['PeopleService'];
    app.controller('PeopleCtrl', PeopleCtrl);
    
})();