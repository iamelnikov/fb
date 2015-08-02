'use strict';

angular.module('fbApp')
    .controller('PersonalDataDetailController', function ($scope, $stateParams, PersonalData) {
        $scope.personalData = {};
        $scope.load = function (id) {
            PersonalData.get({id: id}, function(result) {
              $scope.personalData = result;
            });
        };
        $scope.load($stateParams.id);
    });
