var stompClient = null;
var jugadores=[];
function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
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

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    var numm=jugadores.length;
    x = true;
    var temp=$("#name").val();
    alert(temp);
    class Jugador {
        constructor(nombre) {
            this.nombre = nombre;
        }
    };
    for ( var i = 0 ; i < numm ; i++ ) {
        if(temp==jugadores[i]){
            x=false;
        }
     } 

    if(x){
        stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
    }else{
        alert("Nombre de jugador ya en uso");
    }

    
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
    
});

