/* global Stomp */
var prue;
var popo = (function () {
    var g= new Array();
    var jugcarta=new Array();
    var jugadoresActuales = new Array();
    var stompClient = null;
    var m = null;
    var jugador = null;
    var verdad = null;
    var nombreUsuario = null;
    var sala = null;
    var salalis = false;
    var solucion = 1;
    var especial = -1;
    var connect = function (topic) {
        var socket = new SockJS('/gs-guide-websocket');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            setConnected(true);
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/usu' + topic, function (evenbody) {
                especial = evenbody.body;
                pasarVariables(evenbody.body);

            });
            stompClient.subscribe('/topic/cart' + topic, function (evenbody) {
                limpiar();
                var t = JSON.parse(evenbody.body);
                m = t.dato;
                mostrar(m, t.pos);
                mostrarParejas();
                console.log(evenbody.body);
                allPar(tempo);
                var level = document.getElementById("levelGame").innerHTML;
                parJug(popo.getjugcarta());
            });
            stompClient.subscribe('/topic/parejas' + topic, function (evenbody) {
                limpiar();
                var t = JSON.parse(evenbody.body);
                console.log(evenbody.body);
                allPar(t);
                limpiar();
                sendPuntaje();
                allPar(tempo);
                parJug(popo.getjugcarta());
                comprobarParejas();                
            });
            stompClient.subscribe('/topic/uplevel' + topic, function (evenbody) {
                preguntas.mudanza();
                var sal = document.getElementById("levelGame").innerHTML;
                var tro = parseInt(sal, 10);
                preguntas.get2Nivel(preguntas.getPreguntas);
                necart(pu, tro + 1);
                res();

            });
            stompClient.subscribe('/topic/cxj' + topic, function (evenbody) {
                console.log(evenbody.body);
                jugcarta = JSON.parse(evenbody.body);                               
            });
            stompClient.subscribe('/topic/otro' , function (evenbody) {                
                console.log(evenbody.body);
                var jugadores= JSON.parse(evenbody.body);
                //document.getElementById("pl").innerHTML = jugadores;               
                //location.reload();
            });
            stompClient.subscribe('/topic/result' + topic, function (evenbody) {
                var temp = document.getElementById("playerr").innerHTML;
                var pagina = "/resultados.html";
                pagina += "?";
                nomVec = temp.split(",");
                pagina += "=" + temp;
                location.href = pagina;
            });
            stompClient.subscribe('/topic/cartt' + topic, function (evenbody) {
                getStarted();
            });
        }, function (error) {
            console.log(error);
        });
    }

    function comprobarParejas() {
        var level = document.getElementById("levelGame").innerHTML;
        var playe = document.getElementById("playerr").innerHTML;
        var t = parseInt(level, 10);
        if (t == 1 && tempo.length == 8) {
            popo.sendUpLevel(level, playe);

        } else if (t == 2 && tempo.length == 12) {
            popo.sendUpLevel(level, playe);

        } else if (t == 3 && tempo.length == 10) {
            popo.sendUpLevel(level, playe);
        }
    }

    function sendPuntaje() {
        var jugador = document.getElementById("playerr").innerHTML;
        axios.post('/jugadores/puntaje/' + jugador + '/' + parAcert())
                .then(function (response) {
                    console.log(response.data);
                });
    }

    function senf() {
        return m;
    }

    function goSendResult() {
        sala = document.getElementById("idSala").innerHTML;
        var t = parseInt(sala, 10);
        stompClient.send("/app/result." + t, {}, JSON.stringify(""));
    }

    function goToResult() {
        var temp = document.getElementById("playerr").innerHTML;
        pagina = "/resultados.html";
        pagina += "?";
        nomVec = temp.split(",");
        pagina += "=" + temp;
        location.href = pagina;
    }

    function getjugcarta(){
        return jugcarta;
        
    }

    function sendName() {//
        var temp = $("#name").val();
        var temp3 = temp.split(" ");
        var temp2 = "";
        var i;
        for (i = 0; i < temp3.length; i++) {
            temp2 += temp3[i];
        }
        axios.get('jugadores/add/' + temp2)
                .then(function (response) {
                    grouid = response.data;
                    console.log('saved successfully' + grouid)
                    sala = grouid;  //stompClient.send("/app/otro", {}, );
                    pasarVariables(grouid.sala, grouid.nickName);
                });
    }

    function dt(nickName, sala) {
        return{
            nickName: nickName,
            sala: sala
        }
    }

    function sendUpLevel(op, ppl) {
        document.getElementById('levelGame').innerHTML = op;
        sala = document.getElementById("idSala").innerHTML;
        var playe = ppl;
        var t = parseInt(sala, 10);
        var f = dt(ppl, t);
        stompClient.send("/app/level." + t, {}, JSON.stringify(f));
    }

    function sendCart(ct, ctp) {
        var n = document.getElementById("idSala").innerHTML;
        stompClient.send("/app/cart." + n, {}, JSON.stringify(ctp));
        
        
    }
    function getParejas(){
        //alert("llegamos aqui");
        var n = document.getElementById("idSala").innerHTML;
        stompClient.send("/app/cxj." + n, {}, );
        
    }

    function sendPareja(ct, ctp) {
        var n = document.getElementById("idSala").innerHTML;
        stompClient.send("/app/pareja." + n, {}, JSON.stringify(ctp));
    }

    function pasarVariables(op, nombre) {        
        var temp = nombre;
        pagina = "AnteSala.html";
        pagina += "?";
        nomVec = temp.split(",");
        pagina += "=" + temp + "&" + op;
        location.href = pagina;
    }

    function showGreeting(message) {
        $("#greetings").append("<tr><td>" + message + "</td></tr>");
    }

    function disconnect() {
        if (stompClient !== null) {
            stompClient.disconnect();
        }
        setConnected(false);
        console.log("Disconnected");
    }

    function setConnected(connected) {
        $("#connect").prop("disabled", connected);
        $("#disconnect").prop("disabled", !connected);
        if (connected) {
            $("#conversation").show();
        } else {
            $("#conversation").hide();
        }
        $("#greetings").html("");
    }

    function getLisSalaAxios() {
        sala = document.getElementById("idSala").innerHTML;
        axios.get('/jugadores/sala/listo/' + sala)
                .then(function (response) {
                    salalis = response.data;
                });
    }

    var loadd = function () {
        nombreUsuario = document.getElementById("playerr").innerHTML;
        sala = document.getElementById("idSala").innerHTML;
        axios.get('/jugadores/playAnfi/' + sala + '/' + nombreUsuario)
                .then(function (response) {
                    verdad = response.data;
                    console.log('saved successfully');
                });
        return verdad;
    };

    var getStarted = function () {
        var n = document.getElementById("idSala").innerHTML;
        var jugador = document.getElementById("playerr").innerHTML;
        pagina = "/Juego.html";
        pagina += "?";
        nomVec = jugador.split(",");
        pagina += "=" + jugador + "&" + n;
        location.href = pagina;
    };

    function isAnfitrion3(contador) {
        //alert("ques es cont: "+contador);
        if (contador > 1) {
            var n = document.getElementById("idSala").innerHTML;
            stompClient.send("/app/cartt." + n, {}, );
        } else {
            alert("Anfritrion, espere a que halla minimo 3  jugadores conectados.");
        }
    }

    function isAnfitrion2(tor, dato) {
        if (dato) {
            var n = document.getElementById("idSala").innerHTML;
            var t = parseInt(n, 10);
            var contador;
            axios.get('/jugadores/sala/cantidad/' + t)
                    .then(function (response) {
                        contador = response.data;
                        console.log('saved successfully' + contador);
                        tor(contador);
                    });
        } else {
            alert("Debes ser anfitrion para poder iniciar la partida");
        }
    }

    function prueba() {
        isAnfitrion(isAnfitrion2);
    }

    function isAnfitrion(on) {
        var dato = null;
        var jugador = document.getElementById("playerr").innerHTML;
        var sala = document.getElementById("idSala").innerHTML;
        axios.get('/jugadores/playAnfi/' + sala + '/' + jugador)
                .then(function (response) {
                    dato = response.data;
                    console.log('saved successfully' + dato);
                    on(isAnfitrion3, dato);
                });
    }
    return {
        getjugcarta:getjugcarta,
        getParejas:getParejas,
        sendPareja: sendPareja,
        getStarted: getStarted,
        prueba: prueba,
        isAnfitrion2: isAnfitrion2,
        isAnfitrion: isAnfitrion,
        goToResult: goToResult,
        dt: dt,
        goSendResult: goSendResult,
        loadd: loadd,
        setConnected: setConnected,
        sendName: sendName,
        pasarVariables: pasarVariables,
        disconnect: disconnect,
        showGreeting: showGreeting,
        sendCart: sendCart,
        senf: senf,
        sendUpLevel: sendUpLevel,
        init: function () {
            //connect('');
        },
        cone: function () {
            connect('');
        },
        conec: function (mil) {
            connect('.' + mil);
        },
        conecS(dat) { //Proximamene, para conectar a una sala especifica
            connect(dat);
        },
        can: function () {
            reload();
        }
    };
})();
$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $("#connect").click(function () {
        popo.conec();
    });
    $("#disconnect").click(function () {
        disconnect();
    });
});