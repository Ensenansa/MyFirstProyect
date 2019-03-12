
var barajas = "";

var nivel = 0;

var cartas = new Array();
var temp = new Array();
var mirar = (function () {


    function getAnfiPlayBySala() {

        axios.get('cartas/bara/' + nivel)
                .then(function (response) {
                    alert(response);
                    barajas = response.data;
                    console.log('saved successfully')
                    //document.getElementById("playAf").innerHTML = barajas ;                                    
                });
    }
    function orCarta() {


        if (nivel == 1) {
            for (var i = 0; i < 8; i++) {
                var a = {nombre: '', seleccion: ''};
                a.nombre = barajas[i].dato;
                a.seleccion = barajas[i].bloqueado;
                cartas.push(a);
                temp.push(a);
            }
            for (var e = 0; e < 8; e++) {
                cartas.push(temp[e]);
            }

        } else if (nivel == 2) {
            var te = true;
            var aleatorio = Math.round(Math.random() * (12 - 0) + parseInt(0));
            var i = 0;
            while (i < 12) {
                if (i == aleatorio && te) {
                    var a = {nombre: '', seleccion: ''};
                    a.nombre = '?';
                    cartas.push(a);
                    te = false;
                } else {
                    var a = {nombre: '', seleccion: ''};
                    a.nombre = barajas[i].dato;
                    a.seleccion = barajas[i].bloqueado;
                    cartas.push(a);
                    temp.push(a);
                    i++;
                }
            }
            for (var e = 0; e < 12; e++) {
                cartas.push(temp[e]);
            }
        } else if (nivel == 3) {

            for (var i = 0; i < 10; i++) {
                var a = {nombre: '', seleccion: ''};
                a.nombre = barajas[i].dato;
                a.seleccion = barajas[i].bloqueado;
                cartas.push(a);
                temp.push(a);
            }

            for (var r = 0; r < 10; r++) {
                cartas.push(temp[r]);
            }
        }
    }


    return {
        getAnfiPlayBySala: getAnfiPlayBySala,
        orCarta: orCarta

    };
})();
