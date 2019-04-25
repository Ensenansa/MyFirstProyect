var cartOcupadas = new Array();

var parejasHechas = new Array();
var tempo = new Array();
var cartOcupadas2 = new Array();
var cartas2 = new Array();
var cartas = new Array();

var idSala ;
var intentos = 0;
var jugada1 = "";
var jugada2 = "";
var identificadorJ1 = "";
var identificadorJ2 = "";

Array.prototype.unique = function (a) {
    return function () {
        return this.filter(a)
    }
}(function (a, b, c) {
    return c.indexOf(a, b + 1) < 0
});

Array.prototype.includes(searchElement[ fromIndex ]);


var arr = new Array();

function removeItemFromArr(arr, item) {
    return arr.filter(function (e) {
        return e !== item;
    });
};

var f=-1;


function getIdSala(onTime,nombre){

    //var idsala;
        axios.get('/jugadores/sala/=' + nombre)
                .then(function (response) {
                    idSala = response.data;
                    //alert(idSala);
                    onTime(necart,idSala);
                    document.getElementById("idSala").innerHTML = idSala;
                    console.log('saved successfully' + idSala);
                });
    }
   //    getIdSala(getLevelId,nombre);
function getLevelId(on,sala){

    axios.get('/jugadores/nivel/' + sala)
                .then(function (response) {
                    f = response.data;
                    //alert(f);
                    document.getElementById("levelGame").innerHTML =f;
                    console.log('saved successfully' + f)
                    on(pu,f);    
                });
}


function necart(pp,level){

    
    if(level==0){
        level++;
    }
    //alert("que es nivel"+level);
    axios.get('/cartas/bara/' + level)
                .then(function (response) {
                    cartas2 = response.data;
                    //alert("nivel"+level);
                    //alert("ahora cartas2"+cartas2);
                    //pp(pintar,temporal);
                    pp(ko,pl);
                    console.log('saved successfully' + cartas2);
                    
                });
}
function pu(pl){
    //alert("logituf"+cartas2.length);
    for (var i = 0; i < cartas2.length; i++) {
        //alert("que carta es: "+cartas2[i].dato);
        var carta = cartas2[i].dato;
        //alert("que es dato , otro dato"+i.toString()+"y carta"+carta);
        var dato = document.getElementById(i.toString());
        dato.dataset.valor = carta;
    }
    alert("vamos");
    pl();
    
}

function ko(){
    var n = document.getElementById("idSala").innerHTML;
    //alert("carga n: "+n);
    popo.conecS("."+n);    

}


function temporal(){
    //alert("logituf"+cartas2.length);
    for (var i = 0; i < cartas2.length; i++) {
        
        alert("que  es: "+i.toString());
        var carta = cartas2[i].dato;
        //alert("que es dato , otro dato"+i.toString()+"y carta"+carta);
        var dato = document.getElementById(i.toString());
        console.log(dato) ;
        console.log(dato.dataset.valor) ;
        //alert("miremosq nos va mostr : "+dato.dataset.valor);
        //dato.dataset.valor = carta;
    }
    

}




function pintar(){
    alert("Dichosas cartas"+cartas2);
    
}


function c1(OnTime){
    //alert("conectandome");
    //popo.conec();    
    OnTime(c3);
}

function c2(on){
    //alert("fin");  
    //tener.fin();
    mirar.fan();
    on(c4);

}

function c3(on){
    //alert("hora");
    tiempo.hora();
    on(c5);
}

function c4(on){
    //alert("preguntas");
    preguntas.getPreguntas();

    on();
}

function c5(){
    //alert("Sala : "+idSala);
    var nombre = document.getElementById("playerr").innerHTML;
    //alert("cual es el nombre"+nombre);
    getIdSala(getLevelId,nombre);
    

}

function libertad(){
    //alert("hola");
    var nombre = document.getElementById("playerr").innerHTML;
    var jugador = document.getElementById("levelGame").innerHTML;
    //alert("cual es el id"+jugador);
    //alert("cual es el nombre"+nombre);
    getIdSala(getLevelId,nombre);

}



function iniciarJuego() {
    c1(c2);
    //popo.conec();

    //tener.fin();

    //tiempo.hora();

    //preguntas.getPreguntas();

    var dato = document.getElementById("juego");

    var nombre = document.getElementById("playerr").innerHTML;

    dato.style.opacity = 1;

    //alert(cartas2);

    ///-------------//
    //alert("cual es el nombre"+nombre);
    //getIdSala(getLevelId,nombre);
    
    ///-------------//
    //cartas.sort(function() {return Math.random() - 0.5});
    
//    for (var i = 0; i < 16; i++) {
//        var carta = cartas[i].nombre;
//        var dato = document.getElementById(i.toString());
//        dato.dataset.valor = carta;

//    }
};

function res(){
    alert("borrando");
    tempo = new Array();
    parejasHechas = new Array();
    
}

function resetearJuego() {
    //cartas.sort(function() {return Math.random() - 0.5});
    for (var i = 0; i < 16; i++) {
        var carta = cartas[i].dato;
        var dato = document.getElementById(i.toString());
        dato.dataset.valor = carta;
        colorCambio(i, 'black', '?');
    }
}
function mostrar(carta, pos) {
    var lon = cartas.length;
    var x;
    for (x in cartas2) {
        console.log(cartas2[x]);
        if (cartas2[x].dato === carta) {
            cartas2[parseInt(pos)].seleccion = true;
            colorCambio(pos, "blue", carta);
            cartOcupadas.push(pos);
        }
    }
}

function limpiar() {
    tempo=tempo.sort();
    var temp = 0;
    var g;
    var cart;

    for (g = 0; g < cartas2.length; g++) {
        if(temp>(cartas2.length/2) | temp>tempo.length-1 ){
                temp=0;
        }
        cart = tempo[temp];
        if (cartas2[parseInt(g)].dato != cart ) {
            cartas2[parseInt(g)].seleccion = false;
            colorCambio(parseInt(g), "black", "?");            
        }else{
            cartas2[g].seleccion = true;
            colorCambio(parseInt(g), "blue", cartas2[g].dato);
            temp+=1;
        }
    }
}

function allPar(parejas) {
    tempo = parejas.unique();
    var num = 0;
    var g;
    var letem = cartas.length;
    for (g = 0; g < cartas.length; g++) {
        var rr = tempo[num];
        if (cartas2[parseInt(g)].dato == tempo[num]) {
            cartas2[parseInt(g)].seleccion = true;
            colorCambio(g, "blue", tempo[num]);
            num = num + 1;
        }
    }
}
function parAcert(){
    return parejasHechas;
}


function sendPuntaje() {
        
        var jugador= document.getElementById("playerr").innerHTML;
        axios.post('/jugadores/puntaje/'+jugador+'/'+100)
                .then(function (response) {
                    console.log(responde.data);
                    //alert(salalis);
                });


    }
//Para trabajar al otro dia, mandar las parejas a stomp y que este lo mande
//al mostrar parejas, obviamente adicionar esos variables a la funcion de abajo
//para que entre ellos se abisen sobre las parejas mostradas.
function mostrarParejas() {
    var g;
    var lenc = parejasHechas.length;
    parejasHechas=parejasHechas.sort();
    for (g = 0; g < lenc; g++) {
        cartas2[parseInt(parejasHechas[g])].seleccion = true;
        colorCambio(parejasHechas[g], "blue", cartas2[parseInt(parejasHechas[g])].dato);
    }
}

function prueba(dato, pos, nombre) {
    return{
        dato: dato,
        pos: pos,
        nombre:nombre
    }
}

function girarCarta() {
    //alert("vive");
    var evento = window.event;
    var dato = document.getElementById("idSala").innerHTML;
    var nombre= document.getElementById("playerr").innerHTML;
    jugada2 = evento.target.dataset.valor;
    identificadorJ2 = evento.target.id;
    var tt = prueba(jugada2, identificadorJ2,nombre);    
    if (cartas2[parseInt(identificadorJ2)].seleccion != true) {
        popo.sendCart(dato, tt);
        if (jugada1 !== "") {
            cartas2[parseInt(identificadorJ1)].seleccion = false;
            if (jugada1 === jugada2 && identificadorJ1 !== identificadorJ2 && cartas2[parseInt(identificadorJ2)].seleccion != true && cartas2[parseInt(identificadorJ1)].seleccion != true) {
                parejasHechas.push(identificadorJ1);
                parejasHechas.push(identificadorJ2);
                cartas2[parseInt(identificadorJ1)].seleccion = true;
                cartas2[parseInt(identificadorJ2)].seleccion = true;
                colorCambio(identificadorJ2, "blue", jugada2);
                vaciar();
                comprobar();
            } else if (identificadorJ1 !== identificadorJ2) {
                var self = this;
                setTimeout(function () {
                    colorCambio(self.identificadorJ1, "black", "?")
                    colorCambio(self.identificadorJ2, "black", "?")
                    vaciar();
                    
                }, 200);

                colorCambio(identificadorJ2, "blue", jugada2);
            }
        } else if (jugada2 !== "valor") {

            colorCambio(identificadorJ2, "blue", jugada2);

            jugada1 = jugada2;
            identificadorJ1 = identificadorJ2;
        }
    } else {
        alert("La carta ya fue escogida");

    }
};

function vaciar() {
    jugada1 = "";
    jugada2 = "";
    identificadorJ1 = "";
    identificadorJ2 = "";
}

function colorCambio(posicion, color, contenido) {
    document.getElementById(posicion.toString()).style.backgroundColor = color;
    document.getElementById(posicion.toString()).innerHTML = contenido;
}

function comprobar() {
    var aciertos = 0;
    mostrarParejas();
    for (var i = 0; i < 16; i++) {
        if (cartas2[i].seleccion == true) {
            //alert("pasamos");
            aciertos++;
        }
    }

    if (aciertos == 16) {
        //document.getElementById("juego").innerHTML = "GANASTE";
    }
}

function resetearJuego() {
    cartas.sort(function () {
        return Math.random() - 0.5
    });
    for (var i = 0; i < 16; i++) {
        var carta = cartas[i].dato;
        var dato = document.getElementById(i.toString());
        dato.dataset.valor = carta;
        colorCambio(i, 'black', '?');
    }
};