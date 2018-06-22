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