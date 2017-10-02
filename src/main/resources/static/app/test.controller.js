(function () {
    'use strict'

    angular
        .module('myApp')
        .controller('masterCtrl', masterCtrl);


    masterCtrl.$inject = ['$http', '$scope'];

    function masterCtrl($http, $scope) {
        var cu = this;

        $http({
            method: 'GET',
            url: '/customers/all',
        }).then(function successCallback(getCustomers) {
            $scope.customers = getCustomers.data;
            console.log($scope.customers);
        }, function errorCallback(getCustomers) {

        });


        $scope.customeredit = function ($id) {
            $scope.customeridjs = $id;

            $http({
                method: 'GET',
                url: '/customers/edit/' + $id,
            }).then(function successCallback(getCustomers) {
                $scope.editcustomer = getCustomers.data;
            }, function errorCallback(getCustomers) {
            });

            $http({
                method: 'GET',
                url: '/note/findall/' + $id,
            }).then(function successCallback(getNote) {
                $scope.allnote = getNote.data;
                console.log($scope.allnote);
            }, function errorCallback(getNote) {

            });

            $scope.IsVisible = $scope.IsVisible ? false : true;
            jQuery('#allCustomers').replaceWith(jQuery('oneCustomerView'));
        };

        $scope.noteedit = function ($id) {
            $http({
                method: 'GET',
                url: '/note/edit/' + $id,
            }).then(function successCallback(getNote) {
                $scope.editnote = getNote.data;
                console.log($scope.editnote);
            }, function errorCallback(getNote) {
            });
            $scope.IsVisible = false;
            jQuery('oneCustomerView').replaceWith(jQuery('noteeditview'));
            $scope.IsVisibleNote = $scope.IsVisibleNote ? false : true;


        };

        $scope.notedel = function ($id) {
            console.log("jestem w notedel", $id)
            $http({
                method: 'GET',
                url: '/note/remove/' + $id,
            }).then(function successCallback() {
                alert("notatkę usunięto ");
                location.reload();
            }, function errorCallback() {
                alert("coś poszło nie tak");
            });
        };

        $scope.textnote = function () {
            var id = $scope.customeridjs
            var rightNow = new Date();
            var datenow = rightNow.toISOString().slice(0, 10)

            var notes = document.getElementsByName('textarea');
            if (notes[0].value == '') {
                alert("proszę wypełnic notatkę");
                return;
            } else {
                var obj = {
                    note: notes[0].value,
                    customerid: id,
                    date: datenow
                }
            }
            $http.post('/note/create', obj).then(function successCallback() {
                alert("notatkę dodano ");
                location.reload();
            }, function errorCallback() {
                alert("notatka zbyt długa");
            });
        };

        $scope.textedit = function () {
            var id = $scope.editnote[0].id;
            var customerid = $scope.editnote[0].customerid;
            var rightNow = new Date();
            var datenow = rightNow.toISOString().slice(0, 10)
            var notes = document.getElementsByName('texteditnote');
            if (notes[0].value == '') {
                alert("proszę wypełnic notatkę");
                return;
            } else {
                var obj = {
                    note: notes[0].value,
                    id: id,
                    customerid: customerid,
                    date: datenow
                }
            }
            $http.post('/note/note/edit', obj).then(function successCallback() {
                alert("notatkę zmieniono ");
                location.reload();
            }, function errorCallback() {
                alert("notatka zbyt długa");
            });
        };


        $scope.back = function () {
            location.reload();
        };

        $scope.search = function (row) {
            return (
                angular.lowercase(row.region).indexOf(angular.lowercase($scope.query) || '') !== -1 ||
                angular.lowercase(row.brand).indexOf(angular.lowercase($scope.query) || '') !== -1

            );
        };
    }
})();