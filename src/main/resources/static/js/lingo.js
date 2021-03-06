$( document ).ready(function() {

    showFirstLetter();

    $(':input').keypress(function(e) {
      if (e.which !== 0) {
            $(this).next(':input').focus();
       }
    });
    for (var i=1; i <= 5; i++)
    {
        $("#rij" + i).children('input:last-child').keyup(function (event ) {
            if (event.keyCode == 13) {
                var currentRowNumber = $(this).parent().attr('id').substring(3, 4);
                validate(currentRowNumber);
            }
        });
    }
});

var score = 0;

function checkForWin(result, currentRowNumber){
    var lingoScore = document.getElementById('lingoscore');
    var rightAnswer = new Array("right", "right", "right", "right", "right");
    if(JSON.stringify(result) === JSON.stringify(rightAnswer)){
        score += 10;
        alert("Hoera, je hebt het goed geraden! \r\n+10 punten!");
        sessionStorage.setItem("lscore", score);
        lingoScore.innerText = "Lingo: "+sessionStorage.getItem("lscore");
    }
    if((currentRowNumber == 5) && (JSON.stringify(result) !== JSON.stringify(rightAnswer))){
        score += -2;
        $.get( "/lingo/answer", function( answer ) {
        alert("Helaas, je hebt het niet geraden...\r\nHet juiste antwoord was " + answer + "\r\n-2 punten");
        sessionStorage.setItem("lscore", score);
        lingoScore.innerText = "Lingo: "+sessionStorage.getItem("lscore");
        });
    }
    var s = document.getElementById("userscore");
        s.innerText = score;
}

function getRowInput(rowNumber){
    var rowInput = "";
    $("#rij" + rowNumber).children('input').each(function () {
        rowInput += this.value;
    });
    return rowInput;
}

function showFirstLetter() {
    $.get( "/lingo/start", function( letter ) {
      var cell = getCell(1,1);
      $(cell).val(letter);
      addRightLocationToCell(cell);
      $(cell).next(':input').focus();
    });
}

function validate(currentRowNumber) {
    var rowInput = getRowInput(currentRowNumber);
    $.get( "/lingo/validate?input=" + rowInput, function(result) {
        if (result === true)
        {
            processCheckInput(currentRowNumber);
        }
        else
        {
            alert("Dit is geen geldig 5-letterwoord, probeer opnieuw");
            $("#rij" + (parseInt(currentRowNumber))).find('input:text').val('');
            var cell = getCell(currentRowNumber,1);
            $(cell).focus();
        }
    })
}

function processCheckInput(currentRowNumber)
{
    var rowInput = getRowInput(currentRowNumber);
    $.get( "/lingo/checkInput?input=" + rowInput, function(result) {
        for (var i = 0; i < result.length; i++) {
            var cell = getCell(currentRowNumber,i + 1);
            if (result[i] === "right")
                addRightLocationToCell(cell);
            else if (result[i] === "wrong")
                addWrongLocationToCell(cell);
        }
        if (currentRowNumber < 5) {
            $("#rij" + (parseInt(currentRowNumber) + 1)).children("input:first-child").focus();
        }
        var timeOut;
            clearTimeout(timeOut);
            timeOut = setTimeout(function() {
                checkForWin(result, currentRowNumber);
                }, 500);
    })
}



function getCell(row, column) {
    return $("#rij" + row + " input:nth-child(" + column + ")")[0];
}

function addRightLocationToCell(cell) {
    $(cell).addClass("rightLocation");
}

function addWrongLocationToCell(cell) {
    $(cell).addClass("wrongLocation");
}

function newGame(){
    for (var i=1; i <= 5; i++)
        {
           for (var j=1; j <= 5; j++)
           {
                var cell = getCell(i,j);
                $(cell).removeClass("wrongLocation rightLocation");
                $(cell).val('');
           }
        }
    showFirstLetter();
}