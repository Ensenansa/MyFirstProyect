
/* global apiclient, postUser */
var username;
var susers;
var appIndex = (function () {

    $.getScript("/apiclient.js", function(){
       alert("Archivo cargado!");
    });


     var api = apiclient;
    class Jugador {
        constructor(nombre) {
            this.nombre = nombre;
        }
       
    };
    var postUser = function () {
        
        sessionStorage.setItem("player", document.getElementById("username").value);
        
        var newPlayer = new Jugador(sessionStorage.getItem("player"));
        alert(document.getElementById("username").value);
        var postPromise = api.postUser(newPlayer);
        postPromise.then(
                function () {
                    var newURL = window.location.protocol + "//" + window.location.host + "/" + "/AnteSala.html";
                    
                    window.location.replace(newURL);
                    document.getElementsByName("pl").innerHTML=username;
                },
                function () {
                    alert("You can't play with this username, it's playing");
                }
        );

    };

    var n;
    return {
        addUser: function () {
            susers = document.getElementById("username").value;
            n=document.getElementsByName("pl").innerHTML=username;
            if (username === "") {
                alert("Escriba un usuario valido");
            }
            else{
                
                postUser();
                
            }   
        },
    };

}());
