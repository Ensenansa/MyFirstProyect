var prue;

var popo = (function () {

    var stompClient = null;
    var m = null;
    var jugador = null;

    var verdad = false;

    var nombreUsuario = null;
    var sala = null;

    var salalis = false;

    var solucion = 1;
    var connect = function (topic) {
        var socket = new SockJS('/gs-guide-websocket');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            setConnected(true);
            console.log('Connected: ' + frame);

            stompClient.subscribe('/topic/greetings' + topic, function (evenbody) {
                showGreeting(JSON.parse(evenbody.body).content);
            });
            stompClient.subscribe('/topic/cart' + topic, function (evenbody) {
                limpiar();
                var t = JSON.parse(evenbody.body);
                m = t.dato;
                mostrar(m, t.pos);
                mostrarParejas();
                limpiar();
                console.log(evenbody.body);
            });
            stompClient.subscribe('/topic/parejas' + topic, function (evenbody) {
                
                limpiar();
                var t = JSON.parse(evenbody.body);
                console.log(evenbody.body);
                allPar(t);
                limpiar();
                sendPuntaje();
                //alert(parAcert);
            });
        });
    }
    function sendPuntaje() {
        
        var jugador= document.getElementById("playerr").innerHTML;
        axios.post('/jugadores/puntaje/'+jugador+'/'+parAcert())
                .then(function (response) {
                    console.log(response.data);
                    //alert(salalis);
                });


    }

    function senf() {
        return m;

    }

    function sendName() {
        stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
        pasarVariables();
    }

    function sendCart(ct, ctp) {
        stompClient.send("/app/cart", {}, JSON.stringify(ctp));
    }

    function pasarVariables() {

        var temp = $("#name").val();
        pagina = "AnteSala.html";
        pagina += "?";
        nomVec = temp.split(",");
        pagina += "=" + temp;
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

    function showGreeting(message) {
        $("#greetings").append("<tr><td>" + message + "</td></tr>");
    }

    function getLisSalaAxios() {
        sala = document.getElementById("idSala").innerHTML;
        axios.get('/jugadores/sala/listo/' + sala)
                .then(function (response) {
                    salalis = response.data;
                    //alert(salalis);
                });
    }

    var reload = function () {
        var t = 0;
        var cono = 0;
        while (!verdad & cono < 2) {
            loadd();
            cono += 1;
        }
        if (verdad) {
            if (t < 1) {
                t = 1;
                alert("Usted es el anfritrion no tiene porque revisar");
            }
        } else {//EN esta parte se verifica hasta que la sala este activa
            if (!verdad) { //while (!salalis) {//Aqui es donde esperan 3 segundos
                var cronometro;
                contador_s = 0;
                cronometro = setInterval(
                        function () {
                            contador_s++;
                            getLisSalaAxios();
                            if (salalis) {
                                alert("Empiece a jugar");
                                clearInterval(cronometro);
                                popo.pr(popo.conec);
                                solucion = 5;
                            }
                        }, 3000);
            }
        }
    }

    var loadd = function () {

        nombreUsuario = document.getElementById("playerr").innerHTML;
        var nom = nombreUsuario.replace("=", "");
        //alert("que dice la player"+nom);
        sala = document.getElementById("idSala").innerHTML;

        axios.get('/jugadores/playAnfi/' + sala + '/' + nom)
                .then(function (response) {
                    verdad = response.data;
                    console.log('saved successfully')
                });

        return verdad;
    }

    var load = function () {
        var salal = document.getElementById("idSala").innerHTML;
        if (verdad) {
            stompClient.send("/app/avisar." + salal, {}, "");
            location.href = "/Juego.html";
        } else {
            alert("Debes ser el anfrition para iniciar la partida");
        }
    }

    return {
        reload: reload,
        loadd: loadd,
        setConnected: setConnected,
        sendName: sendName,
        pasarVariables: pasarVariables,
        showGreeting: showGreeting,
        disconnect: disconnect,
        showGreeting: showGreeting,
        sendCart: sendCart,
        senf: senf,
        init: function () {

            connect();
        },
        conec: function () {
            connect('');
        },
        conecSpecifi(dat) {
            //Proximamene, para conectar a una sala especifica
        },
        pr: function () {
            var qw = loadd();
            var salal = document.getElementById("idSala").innerHTML;
            if (qw) {
                stompClient.send("/app/avisar." + salal, {}, "");
                temp = document.getElementById("playerr").innerHTML;
                pagina = "/Juego.html";
                pagina += "?";
                nomVec = temp.split(",");
                pagina += "=" + temp;
                location.href = pagina;
            } else if (solucion > 2) {
                temp = document.getElementById("playerr").innerHTML;
                pagina = "/Juego.html";
                pagina += "?";
                nomVec = temp.split(",");
                pagina += "=" + temp;
                location.href = pagina;
            } else {
                alert("Debes ser el anfrition para iniciar la partida");
            }
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
    $("#send").click(function () {
        popo.sendName();
    });
});