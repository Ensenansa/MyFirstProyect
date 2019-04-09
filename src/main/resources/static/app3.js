/*
 * 
 * @type 
 var popu = (function () {

   
    //function connect() {


    var revisar =function () {



    }
    var load=function() {


    }

    function sendAvis() {

    }
    return {
        
        sendAvis: sendAvis,
        //setConnected: setConnected,
        sendName: sendName,
        pasarVariables: pasarVariables,
        showGreeting: showGreeting,
        disconnect: disconnect,
        showGreeting: showGreeting,

        init: function () {

            
        },
        conec: function () {
            
        },
        pr: function () {           


        }
    };
})();


var verdad = false;
*/
function mandarCarta(car) {
    alert(car);
    valor = car;

    socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        //setConnected(true);
        console.log('Connectedby    : ' + frame);
        stompClient.subscribe('/topic/carta', function (CambioCarta) {

        });
        sendName();
    });
}

/*
 function sendName() {
    alert("si PU");
    alert(valor);
    stompClient.send("/app/cart/", {}, JSON.stringify({'name': valor}));
}

*/

