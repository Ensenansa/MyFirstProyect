


var respuestasIndividual;
var respuestaGrupal;

var t;
var getPDF = (function pdf() {

    function pdd() {
        alert("llegamos");
        t = gset.getUser();
        document.getElementById("usuario").innerHTML = "este usuario" + t;
        alert(t);
    }
    
    function pd() {       
        var animals = [];
        var datoss = new Array();
        datoss = resultados.getData();
        var contador=0;
        var u;
        datoss.forEach(function (elemento, indice, array) {
            contador+=parseInt(elemento.puntaje);
            animals.push([elemento.nickName,elemento.puntaje]);
            console.log(elemento, indice);
        });
        var idSala = document.getElementById("idSala").innerHTML;
        var columns = ["Nombre", "Puntaje"];
        var jugador = document.getElementById("playAf").innerHTML;
        var puntJugador = document.getElementById("puntPlayer").innerHTML;
        var doc = new jsPDF('landscape');
        doc.setFontSize(30);
        doc.setTextColor(255, 0, 0);
        doc.text(20, 20, 'GRACIAS POR JUGAR CARTMODE ');

        doc.setTextColor(239, 127, 26);
        doc.text(20, 50, 'Estos son sus resultados jugador: ' + jugador);

        doc.setTextColor(0, 0, 255);
        doc.text(20, 70, 'Su puntaje obtenido: ' + puntJugador);
        
        doc.setTextColor(239, 127, 26);
        doc.text(20, 90, 'Su sala de juego fue : ' + idSala);

         doc.setTextColor(0, 0, 255);
        doc.text(20, 110, 'El resultado grupal del  juego es: '+contador);

        doc.setTextColor(239, 127, 26);
        doc.text(20, 190, 'Vuelve a intentarlo.');

        doc.autoTable(columns, animals,
                {margin: {top: 140}}
        );

        doc.save('Results.pdf');
    }
    return {
        pd: pd,
        pdd: pdd

    };
})();

