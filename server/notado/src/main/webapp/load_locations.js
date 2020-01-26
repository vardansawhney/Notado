
function load_locations() {
    // Get all the reviewed locations for the user using the server
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function() { 
        if (xmlHttp.readyState == 4) {
            console.log(xmlHttp.responseText);
            notado.locations = JSON.parse(xmlHttp.responseText);
            for (const loc of notado.locations) {
                let ms_loc = new Microsoft.Maps.Location(
                    loc.latitude,
                    loc.longitude
                );
                let pin = new Microsoft.Maps.Pushpin(
                    ms_loc,
                    {
                        title: loc.name
                    }
                );
                Microsoft.Maps.Events.addHandler(
                    pin,
                    'click',
                    function() {
                        pin.setOptions({color: 'red'});
                        showratings(loc);
                        notado.selectedloc = loc.id;
                    }
                );
                notado.map.entities.push(pin);
            }
        }
    }
    xmlHttp.open("GET", "/notado/get-locations?latitude="
        + notado.currentloc.coords.latitude
        + "&longitude="
        + notado.currentloc.coords.longitude, true); // true for asynchronous 
    xmlHttp.send(null);
}
