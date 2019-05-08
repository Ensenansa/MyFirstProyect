var grouid = 0;
var arrVariables = "";
var jugadores = "";
var juganfi = "";
var verdad = "";
var sala = -1;
var mirar = (function Mirar() {
    
    function fan(){
        cadVariables = location.search.substring(2, location.search.length);        
        arrVariables = cadVariables.split('&');        
        var t = String(arrVariables[0]);
        var u = t.replace("=", "");
        document.getElementById("playerr").innerHTML = u;
        mirar.getIdSalaByPlayer(AllPlayersBySala);
        alert("loco entramos1");
        popo.conec(arrVariables[1]);
        
    }
    function fn(){
        mirar.getIdSalaByPlayer1();
    }
    function fin() {

        cadVariables = location.search.substring(2, location.search.length);
        arrVariables = cadVariables.split('&');
        var t = String(arrVariables[0]);
        var u = t.replace("=", "");
        document.getElementById("playerr").innerHTML = u;
        document.getElementById("idSala").innerHTML = arrVariables[1];
        mirar.getIdSalaByPlayer(getAnfiPlayBySala);
        alert("loco entramos13");
        //mirar.getIdSalaByPlayer();
        popo.conec(arrVariables[1]);
    }
    function tu() {
        var cronometro;
        contador_s = 0;
        cronometro = setInterval(
                function () {
                    popo.can();
                    contador_s++;

                    if (contador_s > 3) {
                        clearInterval(cronometro);
                    }
                }, 3000);
    }
    function gr() {

        var nombreUsuario = document.getElementById("playerr").innerHTML;
        var sal = sala;
        axios.get('/jugadores/playAnfi/' + sala + '/' + nombreUsuario)
                .then(function (response) {
                    verdad = response.data;
                    console.log('saved successfully' + verdad)
                });
    }
    function AllPlayersBySala() {
        axios.get('/jugadores/players/' + grouid)
                .then(function (response) {
                    jugadores = response.data;
                    document.getElementById("pl").innerHTML = jugadores;
                    console.log('saved successfully');
                    //mirar.getAnfiPlayBySala();
                });
    }

    function getIdSalaByPlayer(on) {
        axios.get('jugadores/sala/' + arrVariables[0])
                .then(function (response) {
                    grouid = response.data;
                    console.log('saved successfully'+grouid)
                    sala = grouid;
                    document.getElementById("idSala").innerHTML = grouid;
                    on();
                    
                    mirar.AllPlayersBySala();
                });
     }
    function getIdSalaByPlayer1() {
            var a = parseInt(sala);
            axios.get('/jugadores/nivel/' + a)
                    .then(function (response) {
                        level = response.data;
                        var t=parseInt(level, 10)+1;
                        document.getElementById("levelGame").innerHTML = t;
                        console.log('saved successfully' + t)
                    });

    }
    function getAnfiPlayBySala() {
        var juanfi;
        axios.get('jugadores/playAnfi/' + grouid)
                .then(function (response) {
                    juganfi = response.data;
                    console.log('saved successfully')
                    document.getElementById("playAf").innerHTML = juganfi.nickName;

                });
    }

    function getLevelBy() {
        sala = document.getElementById("idSala").innerHTML;
        axios.get('/jugadores/nivel/' + sala)
                .then(function (response) {
                    level = response.data;
                    document.getElementById("levelGame").innerHTML = level;
                    console.log('saved successfully' + level)
                });
    }

    return {
        getIdSalaByPlayer1:getIdSalaByPlayer1,
        fin: fin,
        getIdSalaByPlayer: getIdSalaByPlayer,
        AllPlayersBySala: AllPlayersBySala,
        getAnfiPlayBySala: getAnfiPlayBySala,
        tu: tu,
        fan:fan,
        fn:fn,
        getLevelBy: getLevelBy

    };
})();