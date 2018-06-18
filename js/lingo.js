$( document ).ready(function() {
    $(':input').keypress(function() {
        $(this).next(':input').focus();
    });
    for (var i=1; i <= 5; i++)
    {
        $("#rij" + i).children('input:last-child').keyup(function (event ) {
            if (event.keyCode == 13) {
                var currentRowNumber = $(this).parent().attr('id').substring(3, 4);
                var rowInput = getRowInput(currentRowNumber);
                wordList = getWordList("5-letterwoorden.json", loadWordList);
                checkIfInputIsValidWord(wordList, rowInput);
                //do jquery call en verwerk resultaat, jquery call in losse functie!
                if (currentRowNumber < 5) {
                    $("#rij" + (parseInt(currentRowNumber) + 1)).children("input:first-child").focus();
                }
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

function getWordList(surl,callback) {
    $.ajax({
        url: surl,
        method: 'GET',
        dataType: 'json',
        success: callback,
        error: function(requestObject, error, errorThrown) {
            console.log("error thrown, add handler to exit gracefully");
        },
        timeout: 3000 //to do: research and develop further in combination with error handling (bcontinue).
    });
}

function loadWordList(wordList){
    return wordList;
}

function checkIfInputIsValidWord(wordList, input){
    for(var i=0; i<wordList.value.length; i++){
        if(wordList.value[i] === input){
        alert("geldige input");
        }
    }
}