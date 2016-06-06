/* App Module */

//-------------------------------------------------------------------------------------
// Configure main application
var llApp = angular.module('llApp', [
  'ngRoute',
  'llAppControllers', 
  'llAppServices'
]);

//-------------------------------------------------------------------------------------
// Routes to various areas of the application
llApp.config(['$routeProvider', '$httpProvider',
  function($routeProvider, $httpProvider) {
    'use strict';
    $routeProvider.
      when('/', {
        templateUrl: 'partials/personList.html',
        controller: 'personListCtrl' 
      }).
      when('/person', {
        templateUrl: 'partials/inputPerson.html',
        controller: 'personListCtrl'
      }).
      otherwise({
        templateUrl: 'partials/does-not-exist.html',
        controller: 'DoesNotExistCtrl'
      });
      
      $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
  }]);
