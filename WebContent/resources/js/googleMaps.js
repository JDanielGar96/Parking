/**
 * 
 */

var initialLocation;

var browserSupportFlag =  new Boolean();

function getGeocolocation() {	
	if(navigator.geolocation) {
		browserSupportFlag = true;
		navigator.geolocation.getCurrentPosition(function(position) {
			initialLocation = {    		  
					"latitude": position.coords.latitude,
					"longitude": position.coords.longitude
			};
			googleMap = PF('w_gmap').getMap();
			googleMap.setCenter(
					new google.maps.LatLng(initialLocation.latitude, initialLocation.longitude)
			)
			googleMap.setZoom(16)
			
			document.getElementById("ubicationForm:latitud").value = initialLocation.latitude;
			document.getElementById("ubicationForm:longitud").value = initialLocation.longitude;
			document.getElementById("ubicationForm:zoom").value = 16;
		}, function() {
			handleNoGeolocation(browserSupportFlag);
		});
	}
}


window.onload = getGeocolocation();