$(function(){

    var username = document.getElementById('username');
    var lingoScore = document.getElementById('lingoscore');
    var memoryScore = document.getElementById('memoryscore');
    var $lingohighscores = $('#lingoHighScores');

    $.ajax({
            type: 'GET',
            url: '/players/lingohighscores',
            success: function(data){
                $.each(data, function(i, item){
                    $lingohighscores.append('<li class="highScores">' + item.playerName + ': ' + item.lingoScore + '</li>');
                });
            }
    });

    $('.button').on('click',function(){
        var usernm = document.getElementById('inputfield').value;
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
        success: function(){
            sessionStorage.setItem("playername", player.playerName);
            sessionStorage.setItem("lscore", player.lingoScore);
            sessionStorage.setItem("mscore", player.memoryScore);
            username.innerText = "Welkom " + sessionStorage.getItem("playername") + "!  ";
            lingoScore.innerText = "Lingo: " + sessionStorage.getItem("lscore");
            memoryScore.innerText = "Memory: " + sessionStorage.getItem("mscore");
            },
        });
    });
    if( sessionStorage.getItem("playername") !== null){
         username.innerText = "Welkom " + sessionStorage.getItem("playername") + "!  ";
         lingoScore.innerText = "Lingo: " + sessionStorage.getItem("lscore");
         memoryScore.innerText = "Memory: " + sessionStorage.getItem("mscore");
         }
});