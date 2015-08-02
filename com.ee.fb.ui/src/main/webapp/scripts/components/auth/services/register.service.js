'use strict';

angular.module('fbApp')
    .factory('Register', function ($resource) {
        return $resource('api/register', {}, {
        });
    });


