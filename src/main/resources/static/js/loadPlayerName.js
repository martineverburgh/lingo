$( document ).ready(function() {
     var username = document.getElementById('username');
     var lingoScore = document.getElementById('lingoscore');
     var memoryScore = document.getElementById('memoryscore');
     if( sessionStorage.getItem("playername") !== null){
         username.innerText = "Welkom " + sessionStorage.getItem("playername") + "!  ";
         lingoScore.innerText = "Lingo: "+sessionStorage.getItem("lscore");
         memoryScore.innerText = "Memory: "+sessionStorage.getItem("mscore");
     }
});