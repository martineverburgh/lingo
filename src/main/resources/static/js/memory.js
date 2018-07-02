$(function() {
var ids = '';
var tIds = '';
var idx = 0;
var tcont = '';
var nwimg = '';
var openpict = 0;
var attempts = 0;
var imageArr = ['../images/stonehenge.png',
                '../images/einstein.png',
                '../images/opera_house.png',
                '../images/aristoteles.png',

                '../images/stonehenge.png',
                '../images/pyramid.png',
                '../images/newton.png',
                '../images/einstein.png',

                '../images/aristoteles.png',
                '../images/newton.png',
                '../images/pyramid.png',
                '../images/opera_house.png'
                ];
var thisAttempt = ['',''];
var items = [];
var orgPict = '../images/vraagteken.png';
var timeout;

    $('.mcol').on('click', function(){
        ids = this.id;
        tIds = ids.substr(3);
        tcont = $(this).children('img').attr('src');
        if (tcont === orgPict) {
            // geklikt op een ?-teken
            items.push(this);
            idx = tIds.valueOf()-1;
            nwimg = imageArr[idx];
            $(this).children('img').attr('src', nwimg);
            sleep(200);
            // sla het omgedraaide plaatje op
            thisAttempt[openpict] = nwimg;
            if (openpict == 1) {
                // geklikt op het tweede plaatje
                if (thisAttempt[0] != thisAttempt[1]) {
                    // plaatjes zijn ongelijk
                    // wacht 2 seconden en verberg de plaatjes weer.
//                    sleep(2000);
                    clearTimeout(timeout);
                    timeout = setTimeout(function(){
//                         alert ("end of delay")
                        $(items[0]).children('img').attr('src', orgPict);
                        $(items[1]).children('img').attr('src', orgPict);
                        items.pop();
                        items.pop();
                        }, 2000);
                }
                else {
                     items.pop();
                     items.pop();
                   // zijn alle plaatjes omgedraaid?
                    if (hasAll()) {
                        var s = document.getElementById("userscore");
                        s.innerText = attempts;
                    }
                }
                thisAttempt = ['',''];
                openpict = 0;
            }
            else {
                // geklikt op het eerste plaatje
                openpict++;
                attempts++;
                var t = document.getElementById("memscore");
                t.innerText = attempts;
            }
        }
    });

    function hasAll(){
        var retval = true;
        var img;
        var imgCont;
        var i = 1;
        while (retval && (i <= 6)) {
            var idName = 'img'+i;
            img = document.getElementById(idName);
            imgCont = img.getAttribute("src");
            if (imgCont === orgPict) {
                retval = false;
                }
            i++;
        }
       return retval;
    }

function sleep(milliseconds) {
  var start = new Date().getTime();
  for (var i = 0; i < 1e7; i++) {
    if ((new Date().getTime() - start) > milliseconds){
      break;
    }
  }
}

})

function getData(){
    var query = window.location.search;
    if (query.substr(0,1)=='?') {
        var data = query.split(',');
        var player = document.getElementById('username');
        player.innerText = data[0];
        var playerscore = document.getElementById('userscore');
        playerscore.innerText = data[1];
    }
}
