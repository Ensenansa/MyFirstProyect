var tener = (function Tener() {
    var level = -1;
    function fin() {
        cadVariables = location.search.substring(1, location.search.length);
        arrVariables = cadVariables.split(',');
        var t = String(arrVariables);
        var u = t.replace("=", "");
        document.getElementById("playerr").innerHTML = u;
        mirar.getIdSalaByPlayer();
        mirar.AllPlayersBySala();
        mirar.getLevelBy();
    }
    
    function getLevelBy() {
        sala = document.getElementById("idSala").innerHTML;
        alert("sala es: "+sala);
        //alert("ahora2");                
        axios.get('/jugadores/nivel/' + sala)
                .then(function (response) {
                    level = response.data;
                    //alert("nivel" + level);
                    document.getElementById("levelGame").innerHTML = level;
                    console.log('saved successfully' + level)
                });
    }

    return {
        fin: fin,
        getLevelBy: getLevelBy
    };
})();

var seg=10;
var minutos =0;
//PRIMER NIVEL 2, SEGUNDO 3 Y TERCERO 2 
var numero = null;
var tiempo = (function Tiempo() {
    var numero = null;
    var playe =null;
    function detener(){
        
        clearInterval(int);
    }

    function hora() {
        int = setInterval(function () {
            seg--;
            document.getElementById('i').innerHTML = seg;
            document.getElementById('j').innerHTML = minutos;
            
            s = document.getElementById("levelGame").innerHTML;
           playe = document.getElementById("playerr").innerHTML;

            var t=parseInt(s, 10);
            //alert("q nivel es : "+t);
            if(t>3){
                alert("Se termino");
                detener();
                popo.goSendResult();
                
            }
            if(seg ==1 && minutos ==0){
                //alert("Nos fuimos");
                //alert("EL JUGADOR ESS: "+playe);
                //var t=dt(playe,t);
                popo.sendUpLevel(t,playe);
                seg=30;
                minutos=0;
            }else if (seg == 0) {
                seg = 59;
                //alert("Se acabo el tiempo");
                minutos--;
            }
        }, 1000);
        seg++;
    }
    function dt(jugador, sala) {
        return{
            jugador: jugador,
            sala: sala
        }
    }
    return {

        hora: hora       
    };
})();
var total = 0;
var respuestas="";
var txt_respuestas = "";
var pregunta="";
var respuestaCorrecta="";
var respuestaSeleccionada="";
var preguntas = (function Preguntas() {
    
    var level = -1;

    function getPreguntas() {

        txt_respuestas.length = 0;
        txt_respuestas = "";

        document.getElementById("respuesta").innerHTML = "";
        axios.get('/preguntas/one').then(function (respuesta) {
            
            console.log(respuesta.data);
            pregunta=respuesta.data;
            //alert(pregunta);
            //alert(pregunta.enunciado);            
            document.getElementById("enun").innerHTML = pregunta.enunciado;                
            respuestas=pregunta.opcionesDeRespuesta;
            var a = 0;
            var t;
            for (t=0; t<respuestas.length;t++) {
                    a++;
                    var temp = '<td> <input type="radio" class="form-check-input" name="rell" id=materialUnchecked' + a + ' ' + 'value="' + respuestas[t] + '"><label class="form-check-label" for=materialUnchecked' + a + '> </td>';
                    txt_respuestas += temp + respuestas[t] + '</label><br>';
                    
                }
                total=a;
            var temp = '';
            document.getElementById("respuesta").innerHTML = txt_respuestas;
            txt_respuestas="";
                    })
                .catch(function (errorr) {
                    console.log(errorr);
                })
    }
    
    //function mudanza(colchones) {
    function mudanza() {
        var f=-1;
        respuestaCorrecta=pregunta.respuestaCorrecta;
        respuestaSeleccionada = $("input[type=radio]:checked").val();
        //alert(respuestaSeleccionada);
        if(respuestaCorrecta==respuestaSeleccionada){
            f=1;
            
        }else{
            f=0;
            
        }
        var jugador= document.getElementById("playerr").innerHTML;
        var le= document.getElementById("levelGame").innerHTML;
        var sal=document.getElementById("idSala").innerHTML;
        
        //alert("le :"+le);
        //alert("sala es: "+sal);
        axios.post('/jugadores/puntajePregunta/'+jugador+'/'+f)
                .then(function (response) {
                    console.log(response.data);
                    //alert(salalis);
                });
        axios.get('/jugadores/nivel/'+sal)
                .then(function (response) {
                    console.log(response.data);
                    le=response.data;
                    le+=1;
                    //alert("haber"+le);
                    document.getElementById("levelGame").innerHTML =le;
                  
                });                
                
        //alert("urra");
        var tro=parseInt(le,10);
        //document.getElementById("levelGame").innerHTML =le;
        //document.getElementById("juego").innerHTML ="";
    }
    function colchones(nivel){
        necart(up,nivel);
        
    }
    function get2Nivel(on){
        seg=10;
        minutos=0;
        document.getElementById('i').innerHTML = seg;
        document.getElementById('j').innerHTML = minutos;     
        
        
        
        var lelt= document.getElementById("levelGame").innerHTML;
        var levt=parseInt(lelt,10);
        //alert("modificando tabña");
        txt_respuestas.length = 0;
        txt_respuestas = "";
        document.getElementById("juego").innerHTML ="";     
        var fn=5;
        if(levt==2){
            fn--;
        }
        var a ;
        var b ;
        var c=0;
        txt_respuestas+="<table width=100% align=center onload=apiclient.getAllUser()>";
        //alert("Que es fn : "+fn);
        for(a=0;a<fn;a++){
            //alert("Que es fn : "+fn);
            txt_respuestas+="<tr>";
            
//'<input type="radio" class=+ a + ' ' + 'value="' + respuestas[i] + '"><label class="form-check-label" for=materialUnchecked' + a + '>';
            for(b=0;b<5;b++){
                var temp='<td id="'+c+'" class=letra onclick=girarCarta() data-valor=valor>?</td>"';
                txt_respuestas+=temp;
                c++;
            }
            txt_respuestas+="</tr>";
        }
        
        txt_respuestas+="</table>";
        
        document.getElementById("juego").innerHTML =txt_respuestas;        
        on();
    }
    return {
        get2Nivel:get2Nivel,
        getPreguntas:getPreguntas,
        mudanza:mudanza,
        colchones:colchones

    };
})();
