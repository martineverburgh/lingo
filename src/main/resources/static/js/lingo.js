$( document ).ready(function() {
    showFirstLetter();

    $(':input').keypress(function(e) {
       if (e.which !== 0) {
            $(this).next(':input').focus();
            $(this).next(':input').select();
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
      $(cell).focus();
      $(cell).select();
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
            var cell = getCell(currentRowNumber,1);
            $(cell).focus();
            $(cell).select();
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