/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function onLoad() {

    var txt = "";
    $.get("events/getAllEvents", function (data, status) {
        console.log(data);
        txt += "<table border='1'>"
        for (x in data) {
            txt += "<tr><td>" + data[x].nombre + "</td></tr>";
        }
        txt += "</table>"
        document.getElementById("demo").innerHTML = txt;
        //document.getElementById('name').textContent=data[0].name;
        //$("#input").val(data[0].email);
    });

}
window.onload = onLoad;
