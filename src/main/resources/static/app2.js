

var mirar = (function () {

    function fin() {
        alert("FIn del suplicio?");
        cadVariables = location.search.substring(1, location.search.length);
        alert("miremos " + cadVariables);
        arrVariables = cadVariables.split("&");
        alert("miremos 2" + arrVariables);

        alert("esto es lalalla : " + arrVariables);
        document.getElementById("playerr").innerHTML = arrVariables + "";

    }
    return {
        fin: fin

    };
})();
