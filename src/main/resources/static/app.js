var prue;

var popo = (function () {

    var stompClient = null;

    var jugador = null;

    var verdad = false;

    var nombreUsuario = null;
    var sala = null;

    var salalis = false;

    //function connect() {
    var connect = function (topic) {
        var socket = new SockJS('/gs-guide-websocket');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            setConnected(true);
            console.log('Connected: ' + frame);

            stompClient.subscribe('/topic/greetings' + topic, function (greeting) {
                //alert(stompClient);
                showGreeting(JSON.parse(greeting.body).content);
            });
            stompClient.subscribe('/topic/avisar' + topic, function (cart) {
                //alert("revise" + cart);
                console.log(cart.body);

            });
        });
    }

    function sendName() {
        stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
        //stompClient.send("/app/avisar." + 1, {}, "");
        pasarVariables();
    }
    function pasarVariables() {
        var temp = $("#name").val();
        //alert();
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
        var t=0;
        var cono = 0;

        while (!verdad & cono < 2) {
            loadd();
            cono += 1;
            //alert("entrmos"+cono);
        }
        //alert("enserio2" + verdad);
        //Verofocar si el jugador es anfritrion
        if(verdad){
            if(t<1){
                t=1;
                alert("Usted es el anfritrion no tiene porque revisar");
        }
            
        }else{
        
        
        //EN esta parte se verifica hasta que la sala este activa
        if (!verdad) {
            //getLisSalaAxios();
            //while (!salalis) {//Aqui es donde esperan 3 segundos
            var cronometro;
            contador_s = 0;
            cronometro = setInterval(
                    function () {
                        contador_s++;
                        //alert(""+contador_s);
                        //if (contador_s > 3) {
                        //contador_s = 0;
                        getLisSalaAxios();
                        //alert("e " + salalis);
                        if (salalis) {
                            alert("Empiece a jugar");
                            clearInterval(cronometro);
                            popo.pr(popo.conec);

                        }
                        //alert("se acabo");
                        //}
                    }, 3000);

            //}


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
    }
    var load = function () {
        var salal = document.getElementById("idSala").innerHTML;



        //alert("sala es: " + salal);
        //alert("llegamos" + verdad);
        if (verdad) {
            //alert("paso");
            //alert(stompClient);
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

        init: function () {

            connect();
        },
        conec: function () {
            connect('');
        },
        pr: function () {
            loadd();
            var salal = document.getElementById("idSala").innerHTML;
            verdad = true;
            if (verdad) {
                stompClient.send("/app/avisar." + salal, {}, "");
                //alert("paso");
                location.href = "/Juego.html";
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
        // popo.sendName();
    });
    $("#disconnect").click(function () {
        disconnect();
    });
    $("#send").click(function () {
        popo.sendName();
        //popo.pasarVariables();
        //
    });
});
