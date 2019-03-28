var grouid=0;
var arrVariables="";
var jugadores="";
var juganfi="";
var mirar = (function () {
    
   async function fin() {
        cadVariables = location.search.substring(1, location.search.length);
        //alert();
        arrVariables = cadVariables.split(",");
        document.getElementById("playerr").innerHTML = arrVariables ;
        mirar.getIdSalaByPlayer();
    }
    
    function AllPlayersBySala(){
        axios.get('/jugadores/players/'+grouid)
                .then(function (response) {
                    jugadores=response.data;
                    document.getElementById("pl").innerHTML = jugadores ;
                    console.log('saved successfully');
                    mirar.getAnfiPlayBySala();
                });
    }
    
    function getIdSalaByPlayer(){        
        axios.get('jugadores/sala/'+arrVariables)
                .then(function (response) {
                    //alert(response);    
                    grouid=response.data;
                    console.log('saved successfully')
                    document.getElementById("idSala").innerHTML = grouid ;                    
                    mirar.AllPlayersBySala();
                });                
    }
    //async
     function getAnfiPlayBySala(){
        
        axios.get('jugadores/playAnfi/'+grouid)
                .then(function (response) {
                    //alert(response);    
                    juganfi=response.data;
                    console.log('saved successfully')
                    document.getElementById("playAf").innerHTML = juganfi.nickName ;                                    
                });                
    }
    
    return {
        fin: fin,
        getIdSalaByPlayer:getIdSalaByPlayer,
        AllPlayersBySala:AllPlayersBySala,
        getAnfiPlayBySala:getAnfiPlayBySala

    };
})();
