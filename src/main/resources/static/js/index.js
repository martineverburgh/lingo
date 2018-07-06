$(function(){

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
            var username = document.getElementById('username');
            var lingoScore = document.getElementById('lingoscore');
            var memoryScore = document.getElementById('memoryscore');
//            sessionStorage.setItem("username", usernm);
            sessionStorage.setItem("currentPlayer", player);
            username.innerText = player.playerName+':';
            lingoScore.innerText = player.lingoScore;
            memoryScore.innerText = player.memoryScore;
            },
        });

         var playerbox = document.getElementById('username');
         var currentPlayer = sessionStorage.getItem("currentPlayer");
         if (usernm !== "null"){
         playerbox.innerText = usernm+':';}
         else {playerbox.innerText = "User";}


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
    });
});