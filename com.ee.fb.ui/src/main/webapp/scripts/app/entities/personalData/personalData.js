'use strict';

angular.module('fbApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('personalData', {
                parent: 'entity',
                url: '/personalData',
                data: {
                    roles: ['ROLE_USER'],
                    pageTitle: 'fbApp.personalData.home.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/personalData/personalDatas.html',
                        controller: 'PersonalDataController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('personalData');
                        $translatePartialLoader.addPart('global');
                        return $translate.refresh();
                    }]
                }
            })
            .state('personalDataDetail', {
                parent: 'entity',
                url: '/personalData/:id',
                data: {
                    roles: ['ROLE_USER'],
                    pageTitle: 'fbApp.personalData.detail.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/personalData/personalData-detail.html',
                        controller: 'PersonalDataDetailController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('personalData');
                        return $translate.refresh();
                    }]
                }
            });
    });
