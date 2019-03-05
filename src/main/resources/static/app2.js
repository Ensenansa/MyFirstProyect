var mirar = (function () {
    function fin() {
        cadVariables = location.search.substring(1, location.search.length);
        arrVariables = cadVariables.split("&");
        document.getElementById("playerr").innerHTML = arrVariables ;
    }
    return {
        fin: fin
    };
})();
