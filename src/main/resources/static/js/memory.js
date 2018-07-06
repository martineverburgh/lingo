$(function() {
var ids = '';
var tIds = '';
var idx = 0;
var tcont = '';
var nwimg = '';
var openpict = 0;
var attempts = 0;
var allImages = ['../images/appel.png',
                '../images/aristoteles.png',
                '../images/einstein.png',
                '../images/newton.png',
                '../images/opera_house.png',
                '../images/peer.png',
                '../images/pyramid.png',
                '../images/sinaasappel.png',
                '../images/stonehenge.png'
                ];

var imageArr = ['',
                '',
                '',
                '',

                '',
                '',
                '',
                '',

                '',
                '',
                '',
                ''
                ];
var thisAttempt = ['',''];
var items = [];
var orgPict = '../images/vraagteken.png';
var timeout;

fillSquares();

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
                        }, 1000);
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

    function fillSquares(){
        var randIdx;
        var unusedImages;

        unusedImages = allImages;
        for (var i = 1; i <= 6; i++){
            randIdx = Math.floor(Math.random() * unusedImages.length);
            var j = 0;
            var k = 0;
            var currImage ;
            while (j <= randIdx){
                k++;
                if (k >= unusedImages.length){k = 0;}
                if (unusedImages[k] != '') {j++;}
            }
            currImage = unusedImages[k];
            unusedImages[k] = '';
            for (var n = 1; n <= 2; n++) {
                randIdx = Math.floor(Math.random() * imageArr.length);
                j = 0;
                k = 0;
                while (j <= randIdx) {
                    k++;
                    if (k >= imageArr.length){k = 0;}
                    if (imageArr[k] == '') {j++;}
                }
                imageArr[k] = currImage;
            }
        }
}

})