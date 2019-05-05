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
        var jugador = document.getElementById("playAf").innerHTML;
        var puntJugador = document.getElementById("puntPlayer").innerHTML;
        /*
         var img= new Image();
         
         img.addEventListener('load', function() {
         alert("hola");
         var doc = new jsPDF();
         doc.addImage(img, 'png', 10, 50);
         });             */
        //img.src="img/RESULTADOS.png";

        //var imgData='';

        var doc = new jsPDF('landscape');

        doc.setTextColor(100);
        doc.text(20, 20, 'GRACIAS POR JUGAR CARTMODE .');

        doc.setTextColor(150);
        doc.text(20, 30, 'Estos son sus resultados: .'+jugador);

        doc.setTextColor(255, 0, 0);
        doc.text(20, 40, 'El resultado individual del juego es : .'+puntJugador);

        doc.setTextColor(0, 255, 0);
        doc.text(20, 50, 'El resultado grupal del  juego es: .');

        doc.setTextColor(0, 0, 255);
        doc.text(20, 60, 'Vuelve a intentarlo.');

        /*
         doc.setTextColor(255,0,0);
         doc.text(20, 20, 'GRACIAS POR JUGAR CARTMODE ');
         
         doc.text(20, 20, 'Estos son sus resultados: '+jugador);
         //doc.addImage(img, 'png', 10, 60);
         doc.text(30, 25, 'El resultado individual del juego es : '+puntJugador);
         doc.text(30, 35, 'El resultado grupal del  juego es: ');
         */
        doc.save('Results.pdf');
    }
    return {
        pd: pd,
        pdd: pdd

    };
})();
