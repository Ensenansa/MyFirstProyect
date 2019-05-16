

var historicos = (function () {

    var datos = new Array();
    var sala = "";


    function iniR() {
        historicos.getDatos(graficTble);

    }

    function getDatos(ona) {
        var t = parseInt(sala);
         axios.get('persistencia/mostrar/')
                .then(function (response) {   
                    grouid = response.data;                    
                    var t=response.data;;
                    console.log('saved successfully'+grouid);
                    datos = grouid;
                    ona();
                });
    }
    
    function graficTble(){
        txt_respuestas="";
        txt_respuestas+="<table > <tr> <th>Nombre Jugadores</th> <th>Puntaje</th></tr>";
        var ten=datos.length;;
        var tt;        
        datos.sort(function (a, b) {
            
            if (a.puntaje < b.puntaje) {
                return 1;
            }
            if (a.puntaje > b.puntaje) {
                return -1;
            }
            // a must be equal to b
            return 0;
        });
        
        for(tt=0;tt<datos.length;tt++){
                var t=parseInt(datos[tt].puntaje, 10);
                var temp = '<tr> <td>' + datos[tt].nickName+ '</td> ' + '<td>"' + t+ '"</td></tr>';
                txt_respuestas+=temp;            
        }
        txt_respuestas+="</table>";
        document.getElementById("jugadores").innerHTML = txt_respuestas;        
                
    }
    
    function recharge(){
        
        location.reload();
        
    }   

    

    return {      
        iniR: iniR,

        getDatos: getDatos,
        graficTble:graficTble,
        recharge:recharge
    };
})();



