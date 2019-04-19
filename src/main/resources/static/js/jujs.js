class Carta {
    constructor(x, y, z) {
        this.dato = x;
        this.bloqueado = y;
        this.pos = z;
    }
}

var cartOcupadas = new Array();

var parejasHechas = new Array();

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


function res() {
    var cartOcupadas2 = new Array();
    cartOcupadas2 = cartOcupadas.unique();
    alert("son las oupadas" + cartOcupadas2);
    var t = cartOcupadas2.length;
    var lenhe = parejasHechas.length;
    var g;
    var gg;
    for (g = 0; g < t; g++) {

        alert("Se elimnan menos las parejas");
        cartas[parseInt(cartOcupadas2[g])].seleccion = false;
        colorCambio(parseInt(cartOcupadas2[g]), "black", "?");
    }
    cartOcupadas = new Array();
    cartOcupadas2 = new Array();

}
//Para trabajar al otro dia, mandar las parejas a stomp y que este lo mande
//al mostrar parejas, obviamente adicionar esos variables a la funcion de abajo
//para que entre ellos se abisen sobre las parejas mostradas.
function mostrarParejas() {
    var g;
    var lenc = parejasHechas.length;
    
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
    res();
    var evento = window.event;
    var dato = document.getElementById("idSala").innerHTML;
    jugada2 = evento.target.dataset.valor;
    identificadorJ2 = evento.target.id;
    var tt = prueba(jugada2, identificadorJ2);
    popo.sendCart(dato, tt);
    if (jugada1 !== "") {

        if (jugada1 === jugada2 && identificadorJ1 !== identificadorJ2 && cartas[parseInt(identificadorJ2)].seleccion != true && cartas[parseInt(identificadorJ1)].seleccion != true) {
            parejasHechas.push(identificadorJ1);
            parejasHechas.push(identificadorJ2);
            cartas[parseInt(identificadorJ1)].seleccion = true;
            cartas[parseInt(identificadorJ2)].seleccion = true;
            alert("aqui hicimos pareja");
            colorCambio(identificadorJ2, "blue", jugada2);
            vaciar();
            comprobar();
        } else if (identificadorJ1 !== identificadorJ2) {
            var self = this;
            setTimeout(function () {
                colorCambio(self.identificadorJ1, "black", "?")
                colorCambio(self.identificadorJ2, "black", "?")
                vaciar()
            }, 200);

            colorCambio(identificadorJ2, "blue", jugada2);
        }
    } else if (jugada2 !== "valor") {

        colorCambio(identificadorJ2, "blue", jugada2);

        jugada1 = jugada2;
        identificadorJ1 = identificadorJ2;
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
    for (var i = 0; i < 16; i++) {
        if (cartas[i].seleccion == true) {
            alert("pasamos");
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