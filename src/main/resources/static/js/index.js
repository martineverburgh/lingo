$(function(){

     var playerbox = document.getElementById('username');
     var usernm = sessionStorage.getItem("username");
     if (usernm !== "null"){
     playerbox.innerText = usernm+':';}
     else {playerbox.innerText = "User";}

    $('.button').on('click',function(){
        usernm = document.getElementById('inputfield').value;
        var player = {
        playerName: usernm,
        lingoScore: 0,
        memoryScore: 0,
        };

        $.ajax({
        type: 'POST',
        url: '/players',
        contentType:"application/json",
        dataType:"json",
        data: JSON.stringify(player),
        success: function(newPlayer){
            console.log('success', newPlayer);
            var play = document.getElementById('username');
            play.innerText = usernm+':';
            sessionStorage.setItem("username", usernm);
            },
        });
    });
        var playerscore = document.getElementById('userscore');
        playerscore.innerText = '0 0';
        sessionStorage.setItem("username", usernm);
});