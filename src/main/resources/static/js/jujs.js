class Carta{
    constructor(x,y,z){
        this.dato=x;
        this.bloqueado=y;
        this.pos=z;
    }
}


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
function mostrar(carta, pos){
    var lon=cartas.length;
    var x;
    for (x in cartas){
        console.log(cartas[x]);
        //alert("que es : "+cartas[x].nombre+"contra que : "+yy   );
        
        if(cartas[x].nombre===carta){
            alert("miremos que es pos"+pos);
            cartas[parseInt(pos)].seleccion = true;
            colorCambio(pos, "blue", carta);
        }
        
    }
    
    
}


function girar2Carta(identificador) {
    var evento = window.event;
    
    identificadorJ2 = evento.target.id;
    alert(identificadorJ2);
    cartas[parseInt(identificadorJ1)].seleccion = true;
    cartas[parseInt(identificadorJ2)].seleccion = true;

    colorCambio(identificadorJ2, "blue", identificador);
    vaciar();
}
function res(){
    
    
    
}


function prueba(dato,pos){
    return{
     dato:dato,
     pos:pos   
    }
}


function girarCarta() {
    var evento = window.event;
    var dato = document.getElementById("idSala").innerHTML;
    //alert(evento);
    jugada2 = evento.target.dataset.valor;
    //alert("en la primer que manda :"+jugada2);

    identificadorJ2 = evento.target.id;
    var tt=prueba(jugada2,identificadorJ2);
    alert("miremos este : "+tt);
    //alert("esta es la carta x"+yt.x);
    //alert("esta es la carta y"+yt.y);
    //alert("esta es la carta z"+yt.z);
    popo.sendCart(dato, tt);
    //alert("si es?"+tr);

    if (jugada1 !== "") {

        if (jugada1 === jugada2 && identificadorJ1 !== identificadorJ2 && cartas[parseInt(identificadorJ2)].seleccion != true && cartas[parseInt(identificadorJ1)].seleccion != true) {

            cartas[parseInt(identificadorJ1)].seleccion = true;
            cartas[parseInt(identificadorJ2)].seleccion = true;

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