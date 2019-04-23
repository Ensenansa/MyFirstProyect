var grouid = 0;
var arrVariables = "";
var jugadores = "";
var juganfi = "";
var verdad = "";
var sala = -1;
var mirar = (function Mirar() {
    
    function fan(){
        cadVariables = location.search.substring(1, location.search.length);
        arrVariables = cadVariables.split(',');
        var t = String(arrVariables);
        var u = t.replace("=", "");
        document.getElementById("playerr").innerHTML = u;
        mirar.getIdSalaByPlayer(getIdSalaByPlayer1);
        //mirar.getIdSalaByPlayer();
        //mirar.getIdSalaByPlayer1();

        popo.conec();
    }
    function fn(){
        alert("la otra");
        mirar.getIdSalaByPlayer1();
        //mirar.getAnfiPlayBySala();

    }



    function fin() {

        cadVariables = location.search.substring(1, location.search.length);
        arrVariables = cadVariables.split(',');
        var t = String(arrVariables);
        var u = t.replace("=", "");
        document.getElementById("playerr").innerHTML = u;
        mirar.getIdSalaByPlayer(getIdSalaByPlayer1);
        //mirar.getIdSalaByPlayer1();
        popo.conec();
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

        //alert(nombreUsuario);
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
                    mirar.getAnfiPlayBySala();
                });
    }

    function getIdSalaByPlayer(on) {
        axios.get('jugadores/sala/' + arrVariables)
                .then(function (response) {
                    //alert(response);    
                    grouid = response.data;
                    console.log('saved successfully')

                    sala = grouid;
                    alert("esta"+sala);
                    document.getElementById("idSala").innerHTML = grouid;
                    on();
                    mirar.AllPlayersBySala();
                });
     }
function getIdSalaByPlayer1() {
        alert("ahora12 : "+sala);                
       
            alert("pasa"+sala);
            var a = parseInt(sala);
            axios.get('/jugadores/nivel/' + a)
                    .then(function (response) {
                        level = response.data;
                        //alert("nivel" + level);
                        document.getElementById("levelGame").innerHTML = level;
                        console.log('saved successfully' + level)
                    });

    }
    function getAnfiPlayBySala() {
        var juanfi;
        axios.get('jugadores/playAnfi/' + grouid)
                .then(function (response) {
                    //alert(response);    
                    juganfi = response.data;
                    console.log('saved successfully')
                    document.getElementById("playAf").innerHTML = juganfi.nickName;

                });
    }

    function getLevelBy() {
        //alert("dsadsa");
        sala = document.getElementById("idSala").innerHTML;
        alert("sala es: " + sala);
        axios.get('/jugadores/nivel/' + sala)
                .then(function (response) {
                    level = response.data;
                    //alert("nivel" + level);
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