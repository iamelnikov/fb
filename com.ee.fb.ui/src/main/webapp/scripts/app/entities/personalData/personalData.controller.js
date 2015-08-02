'use strict';

angular.module('fbApp')
    .controller('PersonalDataController', function ($scope, PersonalData, ParseLinks) {
        $scope.personalDatas = [];
        $scope.page = 1;
        $scope.loadAll = function() {
            PersonalData.query({page: $scope.page, per_page: 20}, function(result, headers) {
                $scope.links = ParseLinks.parse(headers('link'));
                $scope.personalDatas = result;
            });
        };
        $scope.loadPage = function(page) {
            $scope.page = page;
            $scope.loadAll();
        };
        $scope.loadAll();

        $scope.showUpdate = function (id) {
            PersonalData.get({id: id}, function(result) {
                $scope.personalData = result;
                $('#savePersonalDataModal').modal('show');
            });
        };

        $scope.save = function () {
            if ($scope.personalData.id != null) {
                PersonalData.update($scope.personalData,
                    function () {
                        $scope.refresh();
                    });
            } else {
                PersonalData.save($scope.personalData,
                    function () {
                        $scope.refresh();
                    });
            }
        };

        $scope.delete = function (id) {
            PersonalData.get({id: id}, function(result) {
                $scope.personalData = result;
                $('#deletePersonalDataConfirmation').modal('show');
            });
        };

        $scope.confirmDelete = function (id) {
            PersonalData.delete({id: id},
                function () {
                    $scope.loadAll();
                    $('#deletePersonalDataConfirmation').modal('hide');
                    $scope.clear();
                });
        };

        $scope.refresh = function () {
            $scope.loadAll();
            $('#savePersonalDataModal').modal('hide');
            $scope.clear();
        };

        $scope.clear = function () {
            $scope.personalData = {lastName: null, firstName: null, middleName: null, birthDate: null, birthPlace: null, id: null};
            $scope.editForm.$setPristine();
            $scope.editForm.$setUntouched();
        };
    });
