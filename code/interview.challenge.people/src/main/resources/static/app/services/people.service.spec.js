'use strict';

describe('Testing PeopleService', function(){
    var PeopleService,
        $httpBackend;

    beforeEach(function(){
        module('myApp');

        inject(function(_$httpBackend_, _PeopleService_, $templateCache){
        	$templateCache.put('app/pages/page1/page1.html',''); 
            $httpBackend = _$httpBackend_;
            PeopleService = _PeopleService_;
        })
    });

    afterEach(function() {
        $httpBackend.verifyNoOutstandingExpectation();
        $httpBackend.verifyNoOutstandingRequest()
    });

    it('PeopleService should be define', function(){
        expect(PeopleService).toBeDefined();
    });
    
    it('PeopleService.getAll should be define', function(){
        expect(PeopleService.getAll).toBeDefined();
    });
    
    it('PeopleService.getAll should return data when response is ok', function(){
    	var url = getBaseUrl ()+"/list";
    	var dataFromServer = getPeople();
    	var responseFromServer = {"data": dataFromServer};
        $httpBackend.expectGET(url).respond(responseFromServer);
        var deferredResponse =  PeopleService.getAll();
        var actualData = null;
        deferredResponse.then(function(response){
        	actualData = response.data;
        });
        $httpBackend.flush();
        expect(actualData).toEqual(dataFromServer)
    });

    it('PeopleService.getAll should throw error when response is error', function(){
    	var url = getBaseUrl ()+"/list";
    	var error = new Error('There has been an error!');
        $httpBackend.expectGET(url).respond(500, error);
        var deferredResponse =  PeopleService.getAll();
        var actual = null;
        var onSuccess = function(data){
    		actual = 'No error';
    	};
    	 var onFailure = function(error){
             actual = error;
         };
        deferredResponse.then(onSuccess,onFailure);
        $httpBackend.flush();
        expect(actual.status).toEqual(500)
    });
   
    function getPeople() {
		var p1 = {'id': 1, 'firstName': 'ali', 'lastName': 'zaza', 'age':22};
		var p2 = {'id': 2, 'firstName': 'carl', 'lastName': 'bar', 'age':76};
		var p3 = {'id': 3, 'firstName': 'dina', 'lastName': 'tal', 'age':33};
		var p4 = {'id': 4, 'firstName': 'beri', 'lastName': 'zozo', 'age':15};
		var p5 = {'id': 5, 'firstName': 'carl', 'lastName': 'bashy', 'age':86};
		return [p1, p2, p3, p4, p5];
    }
    
    function  getBaseUrl () {
        return "http://localhost:8080/person";
    }

});