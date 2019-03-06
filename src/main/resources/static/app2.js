var mirar = (function () {
    function fin() {
        cadVariables = location.search.substring(1, location.search.length);
        arrVariables = cadVariables.split("&");
        document.getElementById("playerr").innerHTML = arrVariables ;
    }
    function AllPlayersBySala(){
        axios.get('/res/concretas/'+respuesta+'/'+idp)
                .then(function (response) {
                    console.log('saved successfully')
                });

    }


    return {
        fin: fin
    };
})();
