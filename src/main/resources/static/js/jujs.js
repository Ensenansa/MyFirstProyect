var cartOcupadas = new Array();

var parejasHechas = new Array();
var tempo = new Array();
var cartOcupadas2 = new Array();
var cartas = new Array(
        {nombre: '1', seleccion: false}, {nombre: '2', seleccion: false},
        {nombre: '3', seleccion: false}, {nombre: '4', seleccion: false},
        {nombre: '5', seleccion: false}, {nombre: '6', seleccion: false},
        {nombre: '7', seleccion: false}, {nombre: '8', seleccion: false},
        {nombre: '1', seleccion: false}, {nombre: '2', seleccion: false},
        {nombre: '3', seleccion: false}, {nombre: '4', seleccion: false},
        {nombre: '5', seleccion: false}, {nombre: '6', seleccion: false},
        {nombre: '7', seleccion: false}, {nombre: '8', seleccion: false});

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
}
;

function iniciarJuego() {
    popo.conec();

    tener.fin();

    var dato = document.getElementById("juego");
//alert(dato);
    dato.style.opacity = 1;

    //cartas.sort(function() {return Math.random() - 0.5});

    for (var i = 0; i < 16; i++) {
        var carta = cartas[i].nombre;
        var dato = document.getElementById(i.toString());
        dato.dataset.valor = carta;
    }

}
;

function resetearJuego() {
    //cartas.sort(function() {return Math.random() - 0.5});
    for (var i = 0; i < 16; i++) {
        var carta = cartas[i].nombre;
        var dato = document.getElementById(i.toString());
        dato.dataset.valor = carta;
        colorCambio(i, 'black', '?');
    }
}
function mostrar(carta, pos) {
    var lon = cartas.length;
    var x;
    for (x in cartas) {
        console.log(cartas[x]);
        if (cartas[x].nombre === carta) {
            cartas[parseInt(pos)].seleccion = true;
            colorCambio(pos, "blue", carta);
            cartOcupadas.push(pos);
        }
    }
}

function limpiar() {
    //alert("el vie tempo"+tempo);
    tempo=tempo.sort();
    //alert("el nuevo tempo"+tempo);
    var temp = 0;
    var g;
    var cart;

    for (g = 0; g < cartas.length; g++) {
        

//        if(g>(cartas.length/2)-1){
  //          alert("puta");
    //        temp=0;
            
      //  }
        if(temp>(cartas.length/2) | temp>tempo.length-1 ){
                temp=0;
        }
        cart = tempo[temp];
        //alert("Que carta compararon  " + cart+"contra : "+cartas[g].nombre +"como va temp"+temp);
        //alert("que resultado da: "+cartas[parseInt(g)].nombre != cart && cart!=undefined);
        //if (cartas[parseInt(g)].nombre != cart && cart!=undefined) {
        if (cartas[parseInt(g)].nombre != cart ) {
            //alert("se corr");
            
            //alert("error ue carta deberia nergrear"+cartas[parseInt(g)].seleccion);
            cartas[parseInt(g)].seleccion = false;
            colorCambio(parseInt(g), "black", "?");
            //temp=0;
            
        }else{
            cartas[g].seleccion = true;
            colorCambio(parseInt(g), "blue", cartas[g].nombre);
            
            //alert("temp");
            temp+=1;

        }
    }



}



function allPar(parejas) {


    //alert("como viene parejas"+parejas);
    //alert("en q se vuelven " + parejas.unique());
    //alert("tempo antes" + tempo);
    //tempo += parejas.unique();
    tempo = parejas.unique();
    //alert("tempo despues" + tempo);
    var num = 0;
    var g;
    var letem = cartas.length;
    //alert("longitud cargas"+letem);
    for (g = 0; g < cartas.length; g++) {
        //alert("esto es tempo" + tempo[0]);
        var rr = tempo[num];
        //cartOcupadas2 = removeItemFromArr(cartOcupadas2, tempo[0]);
        //alert("xomparamos esto : " + cartas[parseInt(g)].nombre + "con esto :" + tempo[num] + "num ; " + num);
        if (cartas[parseInt(g)].nombre == tempo[num]) {
            cartas[parseInt(g)].seleccion = true;
            //alert("hola");
            //alert("aqui hicimos pareja");
            colorCambio(g, "blue", tempo[num]);
            //tempo = removeItemFromArr(tempo, rr);
            num = num + 1;
        }
    }
}


function res() {
    var cartOcupadas2 = new Array();
    cartOcupadas2 = cartOcupadas.unique();
    //alert("son las oupadas" + cartOcupadas2);
    var t = cartOcupadas2.length;
    var lenhe = parejasHechas.length;
    var g;
    var gg;
    for (g = 0; g < t; g++) {

        //alert("Que carta elimina : " + cartas[parseInt(cartOcupadas2[g])].nombre);
        cartas[parseInt(cartOcupadas2[g])].seleccion = false;
        colorCambio(parseInt(cartOcupadas2[g]), "black", "?");
    }
    cartOcupadas = new Array();
    cartOcupadas2 = new Array();
    var pox = new Array();

    //allPar(pox);
}
//Para trabajar al otro dia, mandar las parejas a stomp y que este lo mande
//al mostrar parejas, obviamente adicionar esos variables a la funcion de abajo
//para que entre ellos se abisen sobre las parejas mostradas.
function mostrarParejas() {
    var g;
    var lenc = parejasHechas.length;
    parejasHechas=parejasHechas.sort();
    for (g = 0; g < lenc; g++) {
        cartas[parseInt(parejasHechas[g])].seleccion = true;
        colorCambio(parejasHechas[g], "blue", cartas[parseInt(parejasHechas[g])].nombre);
    }

}


function prueba(dato, pos) {
    return{
        dato: dato,
        pos: pos
    }
}


function girarCarta() {
    //res();
    var evento = window.event;
    var dato = document.getElementById("idSala").innerHTML;
    jugada2 = evento.target.dataset.valor;
    identificadorJ2 = evento.target.id;
    var tt = prueba(jugada2, identificadorJ2);
    //alert("identif j1"+identificadorJ1);
    //alert("identif j2" + identificadorJ2);
    //alert("que muestra la carta seleecionada " + cartas[parseInt(identificadorJ2)].seleccion);
    
    if (cartas[parseInt(identificadorJ2)].seleccion != true) {
        popo.sendCart(dato, tt);
        if (jugada1 !== "") {
            //alert("que es jugada 1 : "+jugada1+"que es jugada2 :"+jugada2);
            //alert("que es cartas en j2 : " + cartas[parseInt(identificadorJ2)].seleccion + "ques es cartas en j1" + cartas[parseInt(identificadorJ1)].seleccion);
            cartas[parseInt(identificadorJ1)].seleccion = false;
            if (jugada1 === jugada2 && identificadorJ1 !== identificadorJ2 && cartas[parseInt(identificadorJ2)].seleccion != true && cartas[parseInt(identificadorJ1)].seleccion != true) {
                // if (jugada1 === jugada2 && identificadorJ1 !== identificadorJ2 && cartas[parseInt(identificadorJ2)].seleccion != true) {

                parejasHechas.push(identificadorJ1);
                parejasHechas.push(identificadorJ2);
                cartas[parseInt(identificadorJ1)].seleccion = true;
                cartas[parseInt(identificadorJ2)].seleccion = true;
                //alert("aqui hicimos pareja");
                colorCambio(identificadorJ2, "blue", jugada2);
                vaciar();
                comprobar();
            } else if (identificadorJ1 !== identificadorJ2) {
                var self = this;
                setTimeout(function () {
                    //alert("Aqui es la falla");
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
}
;

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
        if (cartas[i].seleccion == true) {
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
        var carta = cartas[i].nombre;
        var dato = document.getElementById(i.toString());
        dato.dataset.valor = carta;
        colorCambio(i, 'black', '?');
    }
}
;