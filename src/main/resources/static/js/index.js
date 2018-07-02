$(function(){
var usernm;

    $('.button').on('click',function(){
        usernm = document.getElementById('inputfield').value;
        var player = document.getElementById('username');
        player.innerText = usernm+':';
        var playerscore = document.getElementById('userscore');
        playerscore.innerText = '0 0';
    })

})

function sendData(nwpage, pgname) {
    var player = document.getElementById('username').innerText;
    var playerscore = document.getElementById('userscore').innerText;
    var retVal = '<a href="'+nwpage+'?'+player+','+playerscore+'">'+pgname+'<\a>';
    document.write(retVal);
}