'use strict';

describe('Testing PeopleCtrl', function () {
	  var $scope;
	  var $q;
	  var $controller;
	  var peopleService;

	  beforeEach(module('myApp'));

	  beforeEach(inject(function(_$controller_, _$rootScope_, _$q_, _PeopleService_, $templateCache) {
		$templateCache.put('app/pages/page1/page1.html',''); 
	    $q = _$q_;
	    peopleService = _PeopleService_;
	    $controller = _$controller_;
	    $scope = _$rootScope_.$new();
	  }));

	  it('PeopleCtrl init should call getAll and set people when resolve promise', function () {
		// We use the $q service to create a mock instance of defer
		var deferred = $q.defer();
		// Use a Jasmine Spy to return the deferred promise
		spyOn(peopleService, 'getAll').and.returnValue(deferred.promise);
		// Init the controller, passing our spy service instance
		var fixture = $controller('PeopleCtrl', { 
		      $scope: $scope, 
		      PeopleService: peopleService
		});  
	    // Setup the data we wish to return for the .then function in the controller
		var expectPeople = getPeople();
	    deferred.resolve(expectPeople);
	    // We have to call apply for this to work
	    fixture.people = [];
	    $scope.$apply();
	    // Since we called apply, now we can perform our assertions
	    expect(fixture.people.length).toBe(expectPeople.length);
	    expect(fixture.lastError).toBe(undefined);
	  });
	 
	  it('PeopleCtrl init should call getAll and set error when reject promise', function () {
		var deferred = $q.defer();
		spyOn(peopleService, 'getAll').and.returnValue(deferred.promise);
		var fixture = $controller('PeopleCtrl', { 
			      $scope: $scope, 
			      PeopleService: peopleService
		});    
		var expectedErrorMessage = new Error('There has been an error!');
	    // This will call the .catch function in the controller
	    deferred.reject(expectedErrorMessage);
	    
	    // We have to call apply for this to work
	    fixture.people = [];
	    $scope.$apply();

	    // Since we called apply, not we can perform our assertions
	    expect(fixture.people.length).toBe(0);
	    expect(fixture.lastError).toBe(expectedErrorMessage);
	  });

	  it('PeopleCtrl should use PeopleService create and getAll when resolve promise on create', function () {
		// We use the $q service to create a mock instance of defer
		var deferreds = [$q.defer(), $q.defer(), $q.defer()];
		var calls = [];
		// Use a Jasmine Spy to return the deferred promise
		spyOn(peopleService, 'getAll').and.callFake(function() {
	  		var deferred = deferreds[calls.length];
	  		calls.push("getAll");
	  	    return  deferred.promise;
	  	});
		spyOn(peopleService, 'create').and.callFake(function() {
	  		var deferred = deferreds[calls.length];
	  		calls.push("create");
	  	    return  deferred.promise;
	  	});
		var fixture = $controller('PeopleCtrl', { 
		      $scope: $scope, 
		      PeopleService: peopleService
		});
		fixture.temp = {'firstName': 'ali', 'lastName': 'zaza', 'age':22};
		var expectPeople1 = getPeople();
		var expectPeople2 = getPeople();
		expectPeople2.push(fixture.temp);
	    deferreds[0].resolve(expectPeople1);
	    deferreds[1].resolve("");
	    deferreds[2].resolve(expectPeople2);
	    fixture.createPerson();
	    $scope.$apply();
	    expect(calls.length).toBe(3);
	    expect(calls[0]).toBe("getAll");
	    expect(calls[1]).toBe("create");
	    expect(calls[2]).toBe("getAll");
	    expect(fixture.people.length).toBe(expectPeople2.length);
	    expect(fixture.lastError).toBe(undefined);
	});
 
	it('PeopleCtrl should use PeopleService create when reject promise on create', function () {
			// We use the $q service to create a mock instance of defer
			var deferreds = [$q.defer(), $q.defer()];
			var calls = [];
			// Use a Jasmine Spy to return the deferred promise
			spyOn(peopleService, 'getAll').and.callFake(function() {
		  		var deferred = deferreds[calls.length];
		  		calls.push("getAll");
		  	    return  deferred.promise;
		  	});
			spyOn(peopleService, 'create').and.callFake(function() {
		  		var deferred = deferreds[calls.length];
		  		calls.push("create");
		  	    return  deferred.promise;
		  	});
			var fixture = $controller('PeopleCtrl', { 
			      $scope: $scope, 
			      PeopleService: peopleService
			});
			fixture.temp = {'firstName': 'ali', 'lastName': 'zaza', 'age':22};
			var expectPeople1 = getPeople();
		    deferreds[0].resolve(expectPeople1);
		    var expectedErrorMessage = new Error('There has been an error!');
		    deferreds[1].reject(expectedErrorMessage);
		    fixture.createPerson();
		    $scope.$apply();
		    expect(calls.length).toBe(2);
		    expect(calls[0]).toBe("getAll");
		    expect(calls[1]).toBe("create");
		    expect(fixture.people.length).toBe(expectPeople1.length);
		    expect(fixture.lastError).toBe(expectedErrorMessage);
		});

	function getPeople() {
			var p1 = {'id': 1, 'firstName': 'ali', 'lastName': 'zaza', 'age':22};
			var p2 = {'id': 2, 'firstName': 'carl', 'lastName': 'bar', 'age':76};
			var p3 = {'id': 3, 'firstName': 'dina', 'lastName': 'tal', 'age':33};
			var p4 = {'id': 4, 'firstName': 'beri', 'lastName': 'zozo', 'age':15};
			var p5 = {'id': 5, 'firstName': 'carl', 'lastName': 'bashy', 'age':86};
			return [p1, p2, p3, p4, p5];
	}

});