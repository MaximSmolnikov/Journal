$(document).ready(function () {


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
  $('#' + id).append(
      "<div class='panel-body'><div class='row'><div class='col-sm-2'>"
      + newState.date + "</div><div class='col-sm-10'>" + newState.description
      + "</div></div></div>")
  $('#form' + id).trigger('reset')

}

function sendOrder(id){
  // var status= $('#toggle'+id).prop("checked");
  // var name = $('a[href="#'+id+'"]').text();
  // console.log(name);
  // var response ={
  //   id:id,
  //   name:name,
  //   status:status
  // };
  $.ajax({
    type: "GET",
    url: "changestatus/"+id
  });
}

function cahangeState(id) {
  $.ajax({
    type: "GET",
    url: "changestate/"+id
  });
}
