$( document ).ready(function() {
     var player = document.getElementById('username');
     var usernm = sessionStorage.getItem("username");
     player.innerText = usernm+':';
})