/* Controllers */

var llAppControllers = angular.module('llAppControllers', []);

//--------------------------------------------------------------------------------------------------------------
// Controller responsible for getting all persons from the REST app
llAppControllers.controller('personListCtrl', ['$scope', '$route', '$location', 'Person', 'personService',
  function($scope, $route, $location, Person, personService) {
    'use strict';
    
    //------------------------------------------------------------------------------------
    // Get person list
    $scope.personList = Person.list.query();

    //------------------------------------------------------------------------------------
    // Navigate to the "add person" screen 
    $scope.addPerson = function () {
      $location.path('/person');
    }
    
    //------------------------------------------------------------------------------------
    // Delete person
    $scope.deletePerson = function(id) {
      var personData = { 
        "id":id 
      }
      
      personService.submitPersonRestCall('delete', personData).then(function (data) {
        if(data == 'SUCCESS'){
            $scope.transationMsg='Successfully deleted person';
        } else {
            $scope.transationMsg='Error deleting person!';
        }
        
        $scope.personList = Person.list.query();
      });
    }
    
    //------------------------------------------------------------------------------------
    // Edit selected user
    $scope.editPerson = function(id, firstName, lastName) {
      personService.setLatestPerson(id,firstName,lastName);
      $location.path('/person');
      
    }
     
    //------------------------------------------------------------------------------------
  }
]);

//--------------------------------------------------------------------------------------------------------------
// Controller responsible for editing a person and posting those changes to the REST app
llAppControllers.controller('personEditCtrl', ['$scope', '$location', 'personService',
  function($scope, $location, personService) {
    
    // Generate new scope object for this controller
    $scope.personForm = {};
    
    var person = personService.getLatestPerson();
    $scope.personForm.id = person.id;
    $scope.personForm.firstName = person.firstName;
    $scope.personForm.lastName = person.lastName;

    //------------------------------------------------------------------------------------
    // Navigate to main page
    $scope.personList = function () {
      $location.path('/');
    }
    
    //------------------------------------------------------------------------------------
    $scope.submitPerson = function() {
      var personData = { 
        "id":$scope.personForm.id,
         "firstName":$scope.personForm.firstName,
         "lastName":$scope.personForm.lastName
      }
      
      // Some REST services cannot handle "undefined" or null
      if(personData.id == undefined || personData.id == null) {
        personData.id = '';
      }
      
      personService.submitPersonRestCall('save', personData).then(function (data) {
        if(data == 'SUCCESS'){
            $scope.transationMsg = "Save was successful!";
            $scope.personForm.firstName = '';
            $scope.personForm.lastName = '';
            $scope.personForm.id = '';
        } else {
            $scope.msgText='Error saving person!';
        }
        
        personService.clearPerson();
      });
    }
  }
  
]);
