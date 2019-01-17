(function () {
    'use strict';
    
    function PeopleService($http) {
        var service = {};
        service.getAll = getAllPeople;
        service.create = createPerson;
        service.deleteById = deletePersonById;
        return service;

        //public methods
        function getAllPeople() {
            var url = getBaseUrl ()+"/list";
            return $http.get(url).then(onSuccess, onFailure);
        }
        
        function createPerson(person) {
            var url = getBaseUrl () + "/add";
            return $http.post(url, person).then(onSuccess, onFailure);
        }
        
        function deletePersonById(id) {
            var url = getBaseUrl ()+"/delete/"+id;
            return $http.delete(url).then(onSuccess, onFailure);
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