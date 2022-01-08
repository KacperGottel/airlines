<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.js"></script>
<%--HEADER--%>
<%@ include file="/fragment/header.jsp" %>
<%-- MAIN  --%>
<div id="layoutSidenav_content">
    <main>
        <div class="card-body">
            <div class="container-fluid px-4">
                <table id="datatablesSimple" class="display" style="width:100%">
                    <thead>
                    <tr>
                        <th>Date</th>
                        <th>Departure</th>
                        <th>Arrival</th>
                        <th>Number</th>
                        <th>Airlines</th>
                        <th>Details</th>
                        <th>Ticket</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>Date</th>
                        <th>Departure</th>
                        <th>Arrival</th>
                        <th>Number</th>
                        <th>Airline</th>
                        <th>Details</th>
                        <th>Ticket</th>
                    </tr>
                    </tfoot>
                    <tbody>
                    <c:forEach items="${flights}" var="data">
                        <tr>
                            <td>${data.flightDate}</td>
                            <td>${data.departure.airport}</td>
                            <td>${data.arrival.airport}</td>
                            <td>${data.flight.number}</td>
                            <td>${data.airline.name}</td>
                            <td><a href="flight/${data.flight.number}">view 📃</a></td>
                            <td><a href="/user/${currentuser.user.id}/book/${data.flight.number}">Book a ticket  ✈</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <script>   $(document).ready(function () {
                $('#datatablesSimple').DataTable();
            });
            </script>
        </div>
    </main>
<%--MAIN END--%>

<%--  FOOTER  --%>
<%@ include file="/fragment/footer.jsp" %>