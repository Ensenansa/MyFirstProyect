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
var tener = (function Tener() {
    var level = -1;
    function fin() {
        cadVariables = location.search.substring(1, location.search.length);
        //alert();
        arrVariables = cadVariables.split(',');
        var t = String(arrVariables);
        //alert(t);
        var u = t.replace("=", "");
        //alert(u);
        document.getElementById("playerr").innerHTML = u;
        //alert("se");
        mirar.getIdSalaByPlayer();
        //alert("noo");
        mirar.AllPlayersBySala();
        //mirar.getLevelBy();
    }
    function getLevelBy() {
        sala = document.getElementById("idSala").innerHTML;
        //alert("sala es: "+sala);
        axios.get('/jugadores/nivel/' + sala)
                .then(function (response) {
                    level = response.data;
                    //alert("nivel" + level);
                    document.getElementById("levelGame").innerHTML = level;
                    console.log('saved successfully' + level)
                });
    }

    function mandarCarta(car) {
        //alert(car);
        valor = car;

        socket = new SockJS('/gs-guide-websocket');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            //setConnected(true);
            console.log('Connectedby    : ' + frame);
            stompClient.subscribe('/topic/carta', function (CambioCarta) {

            });
            //sendName();
        });
    }

    return {
        fin: fin,
        mandarCarta: mandarCarta,
        getLevelBy: getLevelBy
    };
})();








/*
 function sendName() {
 alert("si PU");
 alert(valor);
 stompClient.send("/app/cart/", {}, JSON.stringify({'name': valor}));
 }
 
 */

