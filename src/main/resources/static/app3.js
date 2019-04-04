
function mandarCarta(car) {
    alert(car);
    valor = car;

    socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connectedby    : ' + frame);
        stompClient.subscribe('/topic/carta', function (CambioCarta) {
            
        });
        sendName();
    });
    

}


function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function load() {

    var nombreUsuario = document.getElementById("playerr").innerHTML;
    var sala = document.getElementById("idSala").innerHTML;
    //alert("nombre usuario : "+nombreUsuario);
    //alert("nombre sala"+sala);
    axios.get('/jugadores/playAnfi/' + sala + '/' + nombreUsuario)
            .then(function (response) {
                //alert("haber "+response);
                verdad = response.data;
//                alert("que retorna "+verdad);
                console.log('saved successfully')
                //document.getElementById("playAf").innerHTML = barajas ;                                    
            });
    if (verdad) {
        location.href = "/Juego.html";
    } else {
        alert("Debes ser el anfrition para iniciar la partida");
    }
}

async function sendName() {
    alert("si PU");
    alert(valor);
    stompClient.send("/app/cart/", {}, JSON.stringify({'name': valor}));
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}



