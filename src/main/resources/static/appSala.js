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


function connectSala() {
    var socket = new SockJS('/gs-sala');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/sala', function (greeting) {
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
    alert("Se activo sala");
    
    stompClient.send("/app/sal", {}, JSON.stringify({'idsala': $("#ids").val()}));
    

    
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}  

                $("form").on('submit', function (e) {
        e.preventDefault();
     $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
    
});

