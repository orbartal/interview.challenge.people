'use strict';

describe('Testing PeopleCtrl', function () {
	  var $scope;
	  var $q;
	  var deferred;
	  var fixture;

	  beforeEach(module('myApp'));

	  beforeEach(inject(function($controller, _$rootScope_, _$q_, PeopleService, $templateCache) {
		$templateCache.put('app/pages/page1/page1.html',''); 
		
	    $q = _$q_;
	    $scope = _$rootScope_.$new();

	    // We use the $q service to create a mock instance of defer
	    deferred = _$q_.defer();
	    
	    // Use a Jasmine Spy to return the deferred promise
	    spyOn(PeopleService, 'getAll').and.returnValue(deferred.promise);
	    
	    // Init the controller, passing our spy service instance
	    fixture = $controller('PeopleCtrl', { 
	      $scope: $scope, 
	      PeopleService: PeopleService
	    });
	  }));
  
	  it('PeopleCtrl should be defined', inject(function($controller) {
	      expect(fixture).toBeDefined();
	  }));
	    
	  it('people should be defined as empty array', inject(function($controller) {
	        expect(fixture.people.length).toBe(0);
	  }));

	  it('PeopleCtrl init should call getAll and set people when resolve promise', function () {
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
	  
	  function getPeople() {
		var p1 = {'id': 1, 'firstName': 'ali', 'lastName': 'zaza', 'age':22};
		var p2 = {'id': 2, 'firstName': 'carl', 'lastName': 'bar', 'age':76};
		var p3 = {'id': 3, 'firstName': 'dina', 'lastName': 'tal', 'age':33};
		var p4 = {'id': 4, 'firstName': 'beri', 'lastName': 'zozo', 'age':15};
		var p5 = {'id': 5, 'firstName': 'carl', 'lastName': 'bashy', 'age':86};
		return [p1, p2, p3, p4, p5];
	  }
	 
	  it('PeopleCtrl init should call getAll and set error when reject promise', function () {
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

	});