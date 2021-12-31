<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%--HEADER--%>
<%@ include file="/fragment/header.jsp" %>

<%-- MAIN  --%>
<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4">
            <div><strong>flight:</strong><br> Nr:${empty value? datum.flight.number : '---'},
                ICAO:${empty value?datum.flight.icao : '--'}, IATA:${empty value?datum.flight.iata : '---'}</div>
            <br>

            <div><strong>arrival:</strong><br> IATA:${empty value? datum.arrival.iata : '---'},
                ICAO:${empty value? datum.arrival.icao : '---'},
                AIRPORT:${empty value?datum.arrival.airport : '---'},
                TERMINAL:${empty value? datum.arrival.terminal : '---'},
                TIMEZONE:${empty value? datum.arrival.timezone : '---'},
                BAGGAGE:${empty value? datum.arrival.baggage:'---'}, DELAY:${empty value? datum.arrival.delay : '---'},
                SCHEDULED:${empty value?datum.arrival.scheduled : '---'}</div>
            <br>

            <div><strong>departure:</strong><br> IATA:${empty value? datum.departure.iata : '---'},
                ICAO:${empty value? datum.departure.icao: '---'},
                AIRPORT:${empty value? datum.departure.airport: '---'},
                TERMINAL:${empty value? datum.departure.terminal: '---'},
                TIMEZONE:${empty value? datum.departure.timezone: '---'},
                DELAY:${empty value? datum.departure.delay: '---'},
                SCHEDULED:${empty value?datum.departure.scheduled: '---'}</div>
            <br>

            <div><strong>flightDate:</strong><br> DATE:${empty value? datum.flightDate : '---'}</div>
            <br>

            <div><strong>aircraft:</strong><br> ICAO24:${empty value?datum.aircraft.icao24 : '---'},
                REGISTRATION:${empty value?datum.aircraft.registration : '---'},
                IATA:${empty value?datum.aircraft.iata : '---'} </div>
            <br>

            <div><strong>flightStatus:</strong><br> ${empty value? datum.flightStatus : '---'}</div>
            <br>

            <div><strong>live:</strong><br> UPDATED:${empty value? datum.live.updated : '---'}, SPEED
                VERT:${empty value?datum.live.speedVertical : '---'}, SPEED
                HORIZ:${empty value? datum.live.speedHorizontal : '---'},
                ${empty value? datum.live.latitude : '---'}, ${empty value? datum.live.longitude : '---'}</div>
            <br>

            <div><strong>airline:</strong><br> ${empty value? datum.airline.name : '---'}</div>
            <br>
        </div>


<%--        MAP--%>
        <div id="map">
        </div>

        <style>
        /* Set the size of the div element that contains the map */
        #map {
        height: 400px;
        /* The height is 400 pixels */
        width: 100%;
        /* The width is the width of the web page */
        }
        </style>

        <script>
        // Initialize and add the map
        function initMap() {
        // The location of Uluru -7.61443474820821, 110.7122374115418
        const airplane = { lat: ${datum.live.latitude + -7.61443474820821}, lng: ${datum.live.longitude + 110.7122374115418} };
        // The map, centered at Uluru
        const map = new google.maps.Map(document.getElementById("map"), {
        zoom: 4,
        center: airplane,
        });
        // The marker, positioned at Uluru
        const marker = new google.maps.Marker({
        position: airplane,
        map: map,
        });
        }
        </script>

        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB41DRUbKWJHPxaFjMAwdrzWzbVKartNGg&callback=initMap&libraries=&v=weekly&channel=2"
                async></script>
<%--        --%>

    </main>

    <%--  FOOTER  --%>
    <%@ include file="/fragment/footer.jsp" %>


