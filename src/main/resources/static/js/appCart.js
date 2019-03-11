var grouid=0;
var arrVariables="";
var jugadores="";
var juganfi="";
var mirar = (function () {

    
    function getAnfiPlayBySala(){
        
        axios.get('jugadores/playAnfi/'+grouid)
                .then(function (response) {
                    alert(response);    
                    juganfi=response.data;
                    console.log('saved successfully')
                    document.getElementById("playAf").innerHTML = juganfi.nickName ;                                    
                });                
    }
    
    return {
        getAnfiPlayBySala:getAnfiPlayBySala

    };
})();
