
function load_locations() {
    // Get all the reviewed locations for the user using the server
    var xmlHttp = new XMLHttpRequest();
        xmlHttp.onreadystatechange = function() { 
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200)
            notado.locations = JSON.parse(xmlHttp.responseText);
        }
    xmlHttp.open("GET", theUrl, true); // true for asynchronous 
    xmlHttp.send(null);
}
