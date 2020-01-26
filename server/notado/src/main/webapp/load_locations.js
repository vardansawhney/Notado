
function load_locations() {
    // Get all the reviewed locations for the user using the server
    if (notado.locationpins !== []) {
        for (const pin_ref of notado.locationpins) {
            notado.map.entities.remove(pin_ref);
        }
    }
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
                        for (const pin_ref of notado.locationpins) {pin_ref.setOptions({ color: 'purple' });}
                        pin.setOptions({color: 'red'});
                        showratings(loc);
                        notado.selectedloc = loc.id;
                    }
                );
                notado.map.entities.push(pin);
                notado.locationpins.push(pin);
            }
        }
    }
    xmlHttp.open("GET", "/notado/get-locations?latitude="
        + notado.currentloc.coords.latitude
        + "&longitude="
        + notado.currentloc.coords.longitude, true); // true for asynchronous 
    xmlHttp.send(null);
}
