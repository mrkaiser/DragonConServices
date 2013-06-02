var myApp = angular.module('myApp',[]);

myApp.factory('Data',function(){
	return {
		vendor: {
			company_name: "",
			product_pod:"",
			product_description:""
		},
		speaker: {
			"bio": "",
		   	"first_name": "",
		   	"last_name": "",
		   	"display_name": "",
		   	"plusone_url": "",
		   	"thumbnail_url": "",
		   	"user_id": "",
		   	"speaker_id": ""
		}
	};
});

function TracksCtrl($scope, $http,Data){

	$http.get('_ah/api/models/v1/tracks/get').success(function(data){
		$scope.tracks = data;
	});
	$scope.data = Data;
}

function VendorCtrl($scope, $http,Data){
	$http.get('_ah/api/models/v1/tracks/get').success(function(data){
		$scope.tracks = data;
	});

	$scope.save = function(){
		$http.post('/someurl',$scope.data.vendor)
	};
	$scope.data = Data;
}

function SpeakerCtrl($scope,$http,Data){
	$scope.save = function(){
		console.log("blah")
		$http.post('/speakerurl',$scope.speaker)
	}
}