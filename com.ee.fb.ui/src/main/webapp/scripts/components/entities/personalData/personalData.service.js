'use strict';

angular.module('fbApp')
    .factory('PersonalData', function ($resource, DateUtils) {
        return $resource('api/personalDatas/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    data.birthDate = DateUtils.convertDateTimeFromServer(data.birthDate);
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    });
