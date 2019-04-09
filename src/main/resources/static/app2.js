var grouid = 0;
var arrVariables = "";
var jugadores = "";
var juganfi = "";
var verdad = "";
var sala = -1;
var mirar = (function Mirar() {

    function fin() {

        cadVariables = location.search.substring(1, location.search.length);
        //alert();
        arrVariables = cadVariables.split(',');
        var t=String(arrVariables);
        alert(t);
        var u=t.replace("=", "");
        alert(u);
        //var tmp=arrVariables.replace("=", "");;
        
        document.getElementById("playerr").innerHTML = u;
        mirar.getIdSalaByPlayer();
        popo.conec();
    }
    function tu() {
        var cronometro;
        contador_s = 0;
        cronometro = setInterval(
                function () {
                    popo.can();
                    contador_s++;
                    //alert(""+contador_s);
                    if (contador_s > 3) {
                        clearInterval(cronometro);
                        //alert("se acabo");
                    } 
                }, 3000);
    }


    function gr() {
        alert("entramos");
        var nombreUsuario = document.getElementById("playerr").innerHTML;
        var sal = sala;
        alert("que putas" + sala);
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

    function getIdSalaByPlayer() {
        axios.get('jugadores/sala/' + arrVariables)
                .then(function (response) {
                    //alert(response);    
                    grouid = response.data;
                    console.log('saved successfully')
                    sala = grouid;
                    document.getElementById("idSala").innerHTML = grouid;
                    mirar.AllPlayersBySala();
                });
    }
    //async
    function getAnfiPlayBySala() {

        axios.get('jugadores/playAnfi/' + grouid)
                .then(function (response) {
                    //alert(response);    
                    juganfi = response.data;
                    console.log('saved successfully')
                    document.getElementById("playAf").innerHTML = juganfi.nickName;
                    
                });
    }

    return {
        fin: fin,
        getIdSalaByPlayer: getIdSalaByPlayer,
        AllPlayersBySala: AllPlayersBySala,
        getAnfiPlayBySala: getAnfiPlayBySala,
        tu: tu

    };
})();
