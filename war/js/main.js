function TracksCtrl($scope, $http){

	$http.get('_ah/api/models/v1/tracks/get').success(function(data){
		$scope.tracks = data;
	});
}