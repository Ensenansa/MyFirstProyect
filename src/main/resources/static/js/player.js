var jugadores=[];
var players =( function player(){

    function getUsers(){
        axios.get('/jugadores').then(function(data){
            a=response.data;
            document.getElementById("jugador").innerHTML="jugadores :" +a;
            console.log(response.data);
            }  
            ).catch(function (error) {            
                console.log(error);
            }); 
        }
    return {
        getUsers:getUsers
    }
})();