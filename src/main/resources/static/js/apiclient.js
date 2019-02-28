/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var apiclient = (function () {
    var userr;
    var information;
    return {
        gtUser: function(){
            
            return userr;
        },
        postUser: function (user) {
            userr=user;
            
            return $.ajax({
                url: "/question/",
                type: "POST",
                data: JSON.stringify(user),
                contentType: "application/json"});
        },
        deleteUser: function (user) {
            return $.ajax({
                url: "/Usuarios/" + user,
                type: "DELETE"});
        },
        putUser: function (user) {
            return $.ajax({
                url: "/Usuarios/",
                type: "PUT",
                data: JSON.stringify(user),
                contentType: "application/json"});
        },
        getUser: function (user) {
            return $.get("/Usuarios/" + user);
        },
        getAllUser: function () {
            return $.get("/jugadores", callback);
        }

    };

}());

