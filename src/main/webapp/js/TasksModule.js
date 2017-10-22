/*Registro el módulo de controladores del catalogo*/
var TasksModule = angular.module('TasksModule', []);

/*
 * CREO UN CONTROLADOR EN EL MODULO. El segundo parametro es la funcion
 * constructora del controlador, donde se definen las variables y metodos que
 * estaran disponibles en el ambito definido para el controlador
 */
TasksModule.controller('GetAllTaskController', function($scope, $http,
		$location, $filter) {

	var url = serverURL + '/tareas';
	var mensaje;

	// ON-LOAD
	$http.get(url).then(

	function success(response) {

		$scope.tareas = formatDate(response.data);

	}, function error(response) {
		mensaje = response.data;
		alert(mensaje);
	});

	// FIN ON-LOAD

	//MODIFICAR TAREA
	$scope.modificarTareas = function() {

		parametros = $scope.tareas;

		var urlInsertar = serverURL + '/tareas';

		$http.put(urlInsertar, parametros).then(

		function success(response) {

			$scope.tareas = formatDate(response.data);

		}, function error(response) {
			$scope.mensaje = response.data;
		});
	}
	
	//INSERTAR TAREA
	$scope.insertarTarea = function() {
		
		var tarea = {};

		$scope.tareas.push(tarea);

	}

	function formatDate(tareas) {

		for (i = 0; i < tareas.length; i++) {
			tarea = tareas[i];

			tarea.fec_inicio = new Date(tarea.fec_inicio);
			tarea.fec_fin_planificada = new Date(tarea.fec_fin_planificada);
			tarea.fec_fin_actual = new Date(tarea.fec_fin_actual);

		}

		return tareas;

	}

});
