(function () {
    'use strict';
    
    function PeopleService($http) {
        var service = {};
        service.getAll = getAllPeople;
        return service;

        //public methods
        function getAllPeople() {
        	console.log('PeopleService getAllPeople');
            var url = getBaseUrl ()+"/list";
            return $http.get(url).then(onSuccess, onFailure);
        }

        //private functions
        function  getBaseUrl () {
          return "http://localhost:8080/person";
        }

        function onSuccess(result) {
        	return result.data;
        }

        function onFailure(error) {
            throw error;
        }
    }
    
    var app = angular.module('myApp');
    PeopleService.$inject = ['$http'];
    app.factory('PeopleService', PeopleService);

})();