$(function(){

    var newusernm = document.getElementById('newUsername').value;

    $('#change-playername').on('click',function(){
        var player = {
        playerName: sessionStorage.getItem("playername"),
        lingoScore: sessionStorage.getItem("lscore"),
        memoryScore: sessionStorage.getItem("mscore"),
        };
        var playerwithnewusername = player;
        playerwithnewusername.playerName = newusernm;

        $.ajax({
        type: 'PUT',
        url: '/players',
        contentType:"application/json",
        dataType:"json",
        data: JSON.stringify(player),
        success: function(player, playerwithnewusername){
            alert("Username gewijzigd naar: " + playerwithnewusername.playerName);
            },
        });
    });
});