/* Services */

var llAppServices = angular.module('llAppServices', ['ngResource']);

//----------------------------------------------------------------------------------------------------------------
// Simple service to get get an array of the various persons in the database.  Can just move to service?
llAppServices.factory('Person', ['$resource',
  function($resource) {
    'use strict';
    return {
      list: $resource('http://localhost:8080/people_rest/person', {}, {
        query: {method:'GET', params:{}, isArray:true}
      })
    }
  }]);

//----------------------------------------------------------------------------------------------------------------
// Person service to conduct various posts to the REST app
llAppServices.factory('personService', ['$q', '$http', function($q, $http) {
  'use strict';
  
  // Create person mapping used to propagate between views
  var person = {
    "id": '',
    "firstName": '',
    "lastName": ''
  };
  
  // Sevice container to hold all the functions for the service 
  var svc = {};
  
  // Gets the latest, propagated person
  svc.getLatestPerson = function () {
    return person;
  }
  
  // Clears the person mapping
  svc.clearPerson = function () {
    person.id = '';
    person.firstName = '';
    person.lastName = '';
  }
  
  // Sets the latest propagated person
  svc.setLatestPerson = function(id,firstName,lastName) {
    person.id = id;
    person.firstName = firstName;
    person.lastName = lastName;
  }
  
  // Submits a request to the REST API
  svc.submitPersonRestCall = function (callType, personData) {
      var data= true;
      var d = $q.defer();
      var callString = '';
      if(callType == 'save') {
        callString = "http://localhost:8080/people_rest/person/save/" + personData.id + "/" + personData.firstName + "/" + personData.lastName;
      } else if(callType == 'delete') {
        callString = "http://localhost:8080/people_rest/person/delete/" + personData.id;
      }

      // Make REST call      
      $http.post(callString)             
       .then(function (res) {
         if(res.statusText == 'OK') {
           d.resolve("SUCCESS");
         } else {
           d.resolve("Error calling REST server!")
         }
        });
       
       return d.promise;
  };
  
  // Returns the service container, housing all the service functions
  return svc;
}]);
