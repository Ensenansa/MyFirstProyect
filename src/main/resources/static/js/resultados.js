//<tr>
//    <td>Alfreds Futterkiste</td>
//    <td>Germany</td>
//</tr>


var resultados = (function () {

    var datos = new Array("Saab", "Volvo", "BMW");
    var sala = "";


    function iniR() {
        cadVariables = location.search.substring(1, location.search.length);
        arrVariables = cadVariables.split(',');
        var t = String(arrVariables);
        var u = t.replace("=", "");
        document.getElementById("playAf").innerHTML = u;
        resultados.getIdSalaByPlayer(getDatos);


    }

    function getIdSalaByPlayer(on) {
        axios.get('jugadores/sala/' + arrVariables)
                .then(function (response) {
                    //alert(response);    
                    grouid = response.data;
                    console.log('saved successfully'+grouid)

                    sala = grouid;
                    //alert("esta"+sala);
                    document.getElementById("idSala").innerHTML = grouid;
                    on(grouid,graficTble );
                    
                });
    }

    function getDatos(numero,ona) {
        var t = parseInt(sala);
        axios.get('jugadores/datos/idsala/' + t)
                .then(function (response) {
                    //alert(response);    
                    grouid = response.data;
                    var t=response.data;
                    //alert("que es : "+t[0].nickName);
                    console.log('saved successfully'+grouid);
                    datos = grouid;
                    //alert(datos);
                    ona();
                    //alert("esta"+sala);
                });
    }
    
    function graficTble(){
        txt_respuestas+="<table > <tr> <th>Nombre Jugadores</th> <th>Puntaje</th></tr>";
        nombre = document.getElementById("playAf").innerHTML;
        //alert("si muestra datos : "+datos );
        var ten=datos.length;
        var tt;
        for(tt=0;tt<datos.length;tt++){
            if(datos[tt].nickName==nombre){
                //alert("hola");
                document.getElementById("puntPlayer").innerHTML = datos[tt].puntaje;
            }else{
            //if(datos[tt].nickName!=nombre){
                //alert("pegando");
                var temp = '<tr> <td>' + datos[tt].nickName+ '</td> '+'<br>' + '<td>"' + datos[tt].puntaje+ '"</td></tr>';
                txt_respuestas+=temp;
            }
        }
        txt_respuestas+="</table>";
        document.getElementById("jugadores").innerHTML = txt_respuestas;        
        
        
        
        
        
        
        
        
        
        
        
    }

    return {
        iniR: iniR,
        getIdSalaByPlayer: getIdSalaByPlayer,
        getDatos: getDatos,
        graficTble:graficTble

    };
})();



