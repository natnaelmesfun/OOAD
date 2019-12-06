// Click on a close button to hide the current list item
var close = document.getElementsByClassName("close");
var i;
for (i = 0; i < close.length; i++) {
  close[i].onclick = function() {
    var div = this.parentElement;
    div.style.display = "none";
  }
}

// Add a "checked" symbol when clicking on a list item
var list = document.querySelector('ul');
list.addEventListener('click', function(ev) {
  if (ev.target.tagName === 'LI') {
    ev.target.classList.toggle('checked');
  }
}, false);


motivation_list = []
//adding new items to the list
function motivationFunction() {
  var listItem = document.createElement("li");
  var inputValue = document.getElementById("myInput").value;
  motivation_list.push(inputValue);
  var t = document.createTextNode(inputValue);
  listItem.appendChild(t);
  if (inputValue === '') {
    alert("You must write something!");
  } else {
    document.getElementById("myUL").appendChild(listItem);
  }
  document.getElementById("myInput").value = "";

  var span = document.createElement("SPAN");
  var txt = document.createTextNode("\u00D7");
  span.className = "close";
  span.appendChild(txt);
  listItem.appendChild(span);

  for (i = 0; i < close.length; i++) {
    close[i].onclick = function() {
      var div = this.parentElement;
      div.style.display = "none";
    }
  }
}

var todo_list = []


function todoFunction() {
  var listItem = document.createElement("li");
  var inputValue = document.getElementById("myInput2").value;
  todo_list.push(inputValue);
  var t = document.createTextNode(inputValue);
  listItem.appendChild(t);
  if (inputValue === '') {
    alert("You must write something Nate!");
  } else {
    document.getElementById("toDoList").appendChild(listItem);
  }
  document.getElementById("myInput2").value = "";

  var span = document.createElement("SPAN");
  var txt = document.createTextNode("Complete");
  span.className = "close";
  span.appendChild(txt);
  listItem.appendChild(span);

  for (i = 0; i < close.length; i++) {
    close[i].onclick = function() {
      var div = this.parentElement;
      div.style.display = "none";
    }
  }
}

var goals_list = []


function goalsFunction() {
  var listItem = document.createElement("li");
  var inputValue = document.getElementById("myInput3").value;
  goals_list.push(inputValue);
  var t = document.createTextNode(inputValue);
  listItem.appendChild(t);
  if (inputValue === '') {
    alert("You must write something!");
  } else {
    document.getElementById("goalsList").appendChild(listItem);
  }
  document.getElementById("myInput3").value = "";

  var span = document.createElement("SPAN");
  var txt = document.createTextNode("\u00D7");
  span.className = "close";
  span.appendChild(txt);
  listItem.appendChild(span);

  for (i = 0; i < close.length; i++) {
    close[i].onclick = function() {
      var div = this.parentElement;
      div.style.display = "none";
    }
  }
}

var schedule_list = []

function schedFunction() {
  var listItem = document.createElement("li");
  var inputValue = document.getElementById("myInput4").value;
  schedule_list.push(inputValue);
  var t = document.createTextNode(inputValue);
  listItem.appendChild(t);
  if (inputValue === '') {
    alert("You must write something!");
  } else {
    document.getElementById("schedList").appendChild(listItem);
  }
  document.getElementById("myInput4").value = "";


  var span = document.createElement("SPAN");
  var txt = document.createTextNode("\u00D7");
  span.className = "close";
  span.appendChild(txt);
  listItem.appendChild(span);

  for (i = 0; i < close.length; i++) {
    close[i].onclick = function() {
      var div = this.parentElement;
      div.style.display = "none";
    }
  }
}




// function send_query(){


//   var new_event = {
//         'motivation_list': motivation_list,
//         'todo_list': todo_list,
//         'goals_list': goals_list,
//         'schedule_list': schedule_list
//        };

//   alert(new_event);
//   alert(new_event['motivation_list']);

//   //$SCRIPT_ROOT = {{ request.script_root|tojson|safe }};

//   $.ajax({
//             // type: "POST",
//             type : 'POST',
//             // url: "/Planneddata",
//             url : '/planner_main',
//             // data: JSON.stringify(new_event),
//             data: {x: "Mike", y: 'Jhon'},
//             // data : {'data':new_event},
//             // contentType: "application/json;charset=utf-8",
//             success: function (data){
//               alert("success"+data);
//               $('#successAlert').text(data.name).show();
//               $('#errorAlert').hide();
//             },
//             error: function(data) {
//               alert("error" + data);
//               $('#errorAlert').text(data.error).show();
//               $('#successAlert').hide();
//             }
//   });

// }

$(document).ready(function() {

  $('form').on('submit', function(event) {

    var new_event = {
        'motivation_list': motivation_list,
        'todo_list': todo_list,
        'goals_list': goals_list,
        'schedule_list': schedule_list
    };

    var js_data = JSON.stringify(new_event);

    $.ajax({
      data : js_data,
      type : 'POST',
      url : '/planner_main',
      contentType: 'application/json'
    })
    .done(function(data) {

      if (data.error) {
        // $('#errorAlert').text(data.error).show();
        // $('#successAlert').hide();
        alert("error");
      }
      else {
        // $('#successAlert').text(data.name).show();
        // $('#errorAlert').hide();
        alert(data);
        // $("#data").html(data);
      }

    });

    event.preventDefault();

  });

});