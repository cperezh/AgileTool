/*Registro el módulo de controladores del catalogo*/
var TasksModule = angular.module('TasksModule', []);

/*
 * CREO UN CONTROLADOR EN EL MODULO. El segundo parametro es la funcion
 * constructora del controlador, donde se definen las variables y metodos que
 * estaran disponibles en el ambito definido para el controlador
 */
TasksModule.controller('GetAllTaskController', function($scope, $http,
		$location) {

	// $scope.tareas =
	// [{"nombre":"carles_pujol","tarea":"SII_","performance":"1"},{"nombre":"carles","tarea":"SII_","performance":"1"}];

	var url = serverURL + '/tareas';
	var mensaje;

	// ON-LOAD
	$http.get(url).then(
			
		function success(response) {
			$scope.tareas = response.data;
		}, 
		function error(response) {
			mensaje = response.data;
			alert(mensaje);
		});

	// FIN ON-LOAD

});
