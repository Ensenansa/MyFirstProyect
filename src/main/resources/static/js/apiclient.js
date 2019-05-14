/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var apiclient = (function () {
    var userr;
    var information;
    return {
        getAllUser: function () {
            return $.get("/jugadores/all");
        }
    };
}());

