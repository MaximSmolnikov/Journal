$(document).ready(function () {
    $("#addstate").keypress(function (e) {
        if (e.keyCode == 13) {
            //нажата клавиша enter - здесь ваш код
        }
    });


});


function send(id) {
    var data = $('#form' + id).serializeArray();
    newState = {
        date: data[0].value,
        description: data[1].value
    };
    $.ajax({
        type: "POST",
        url: "/add/" + id,
        data: JSON.stringify(newState),
        contentType: "application/json; charset=utf-8",
        dataType: "json"
    });
    $('#' + id).append("<div class='panel-body'><div class='row'><div class='col-sm-2'>" + newState.date + "</div><div class='col-sm-10'>" + newState.description + "</div></div></div>")
}
