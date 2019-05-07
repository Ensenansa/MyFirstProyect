

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
                    //alert(response);    
                    grouid = response.data;                    
                    var t=response.data;
                    //alert("que es t : "+t[0]);
                    //alert("que es : "+t[0].nickName);
                    console.log('saved successfully'+grouid);
                    datos = grouid;
                    //alert(datos);
                    ona();
                    //alert("esta"+sala);
                });
    }
    
    function graficTble(){
        txt_respuestas="";
        txt_respuestas+="<table > <tr> <th>Nombre Jugadores</th> <th>Puntaje</th></tr>";
        
        
        //alert("si muestra datos : "+datos );
        var ten=datos.length;
        var tt;
        for(tt=0;tt<datos.length;tt++){
                var temp = '<tr> <td>' + datos[tt].nickName+ '</td> '+'<br>' + '<td>"' + datos[tt].puntaje+ '"</td></tr>';
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



