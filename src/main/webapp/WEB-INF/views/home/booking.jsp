<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%--HEADER--%>
<%@ include file="/fragment/header.jsp" %>

<%-- MAIN  --%>
<div id="layoutSidenav_content">
    <main>
        <div class="h3" style="color: #6c757d">Booking process</div>
        <div class="card-header">${currentuser.username}'s personals</div>
        <div class="card-body">
            ${userDto.firstName}<br>
            ${userDto.lastName}<br>
            ${userDto.email}<br>
            ${userDto.age}<br>
            <a class="nav-link" href="/user/${currentuser.user.id}">Change</a>
        </div>
        <div class="card-footer">
            <form:form method="POST" action="/user/${currentuser.user.id}/uploadFile" enctype="multipart/form-data">
                Select a file to upload:<br>
                <input type="file" name="file"/>
                <input type="submit" value="Submit"/>
            </form:form>
        </div>
        <br>
        <div class="border-bottom" style="border: #2c3034"><br></div>
        <br>
        <div class="container-fluid px-4">
            <div class="h6">Datails</div>
            <div><strong>Flight:</strong><br> Nr:${empty value? datum.flight.number : '---'},
                ICAO:${empty value?datum.flight.icao : '--'}, IATA:${empty value?datum.flight.iata : '---'}</div>
            <br>

            <div><strong>Arrival:</strong><br> IATA:${empty value? datum.arrival.iata : '---'},
                ICAO:${empty value?datum.arrival.icao : '---'},
                AIRPORT:${empty value?datum.arrival.airport : '---'},
                TERMINAL:${empty value?datum.arrival.terminal : '---'},
                TIMEZONE:${empty value?datum.arrival.timezone : '---'},
                BAGGAGE:${empty value?datum.arrival.baggage:'---'}, DELAY:${empty value?datum.arrival.delay : '---'},
                SCHEDULED:${empty value?datum.arrival.scheduled : '---'}</div>
            <br>

            <div><strong>Departure:</strong><br> IATA:${empty value?datum.departure.iata : '---'},
                ICAO:${empty value?datum.departure.icao: '---'},
                AIRPORT:${empty value?datum.departure.airport: '---'},
                TERMINAL:${empty value?datum.departure.terminal: '---'},
                TIMEZONE:${empty value?datum.departure.timezone: '---'},
                DELAY:${empty value?datum.departure.delay: '---'},
                SCHEDULED:${empty value?datum.departure.scheduled: '---'}</div>
            <br>

            <div><strong>FlightDate:</strong><br> DATE:${empty value?datum.flightDate : '---'}</div>
            <br>

            <div><strong>Aircraft:</strong><br> ICAO24:${empty value?datum.aircraft.icao24 : '---'},
                REGISTRATION:${empty value?datum.aircraft.registration : '---'},
                IATA:${empty value?datum.aircraft.iata : '---'} </div>
            <br>

            <div><strong>FlightStatus:</strong><br> ${empty value?datum.flightStatus : '---'}</div>
            <br>

            <div><strong>Live:</strong><br> UPDATED:${empty value?datum.live.updated : '---'}, SPEED
                VERT:${empty value?datum.live.speedVertical : '---'}, SPEED HORIZ:${empty value?datum.live.speedHorizontal : '---'},
                LAT:${empty value?datum.live.latitude : '---'}, LONG:${empty value?datum.live.longitude : '---'}</div>
            <br>

            <div><strong>Airline:</strong><br> ${empty value?datum.airline.name : ""}</div>
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
                // The location of Java -7.61443474820821, 110.7122374115418
                const airplane = {
                    lat: ${empty value?"-7.61443474820821" : datum.live.latitude},
                    lng: ${empty value?"110.7122374115418" : datum.live.longitude}
                };
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


