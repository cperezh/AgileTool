var serverURL = '/AgileTool/resources';

/*Registro la aplicación y los módulos de los que depende*/
var AgileTool = angular.module('AgileTool', [
    'TasksModule',
    'ngRoute',
    'ngMessages'
]);

AgileTool.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.
                when('/tareas', {
                    templateUrl: 'tasks/listaTareas.html',
                    controller: 'GetAllTaskController'
                }).
                when('/detalle/:matricula', {
                    templateUrl: 'detalle.html',
                    controller: 'GetAllTaskController'
                }).
                otherwise({
                    redirectTo: '/tareas'
                });
    }])