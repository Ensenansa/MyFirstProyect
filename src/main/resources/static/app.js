var stompClient = null;
var stompClient2 = null;
var jugador = null;
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

function connect() {


    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (greeting) {
            showGreeting(JSON.parse(greeting.body).content);
        });
    });
}
            function pasarVariables() {

                var temp = $("#name").val();

                alert("poootos name "+temp);
                pagina="AnteSala.html";
                pagina += "?";
                nomVec = temp.split(",");
                pagina+="="+temp;


                location.href = pagina;
            }

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    var temp = $("#name").val();
    jugador = temp;
    alert("eso es?  " + jugador);

    alert("Se activo nombre ");
    stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
    
    alert("lola");

    document.getElementsByName("playerr").innerHTML = jugador;
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $("#connect").click(function () {
        connect();
    });
    $("#disconnect").click(function () {
        disconnect();
    });
    $("#send").click(function () {
        sendName();
    });

});

