'use strict';

angular.module('fbApp')
    .controller('LogoutController', function (Auth) {
        Auth.logout();
    });
