<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%--HEADER--%>
<%@ include file="/fragment/header.jsp" %>

<%-- MAIN  --%>
<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4">
            <div class="d-sm-flex align-items-center justify-content-between mb-4 news shadow m-3">
                <h1 class="h5 ">News</h1><small>"${feed.title}"</small><small>${feedPubDate}</small>
            </div>
            <%--                WIDGET--%>
            <a class="weatherwidget-io" href="https://forecast7.com/en/51d9219d15/poland/" data-label_1="POLAND"
               data-theme="original">POLAND</a>
            <script>
                !function (d, s, id) {
                    let js, fjs = d.getElementsByTagName(s)[0];
                    if (!d.getElementById(id)) {
                        js = d.createElement(s);
                        js.id = id;
                        js.src = 'https://weatherwidget.io/js/widget.min.js';
                        fjs.parentNode.insertBefore(js, fjs);
                    }
                }(document, 'script', 'weatherwidget-io-js');
            </script>
            <%--                WIDGET--%>
            <div class="border-bottom" style="border-bottom: #6c757d">&nbsp;</div>
            <c:forEach items="${feedList}" var="m">
                <div class="card shadow mb-4" style="display: table-cell">
                    <div class="card-header py-3">
                        <h4 class="m-0 font-weight-bold text-primary">${m.title}</h4>
                    </div>
                    <div class="card-body">
                            ${m.description}
                    </div>
                    <button class="btn"><a href="${m.link}" target="_blank" rel="noopener noreferrer"><span
                            class="text-gray-500">Read more</span></a></button>
                </div>
            </c:forEach>
            <br>
            <div>
                ${feed.copyright} ©
            </div>
        </div>

        <%--    FORM    --%>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-7">
                    <div class="card shadow-lg border-0 rounded-lg mt-5">
                        <div class="card-header"><h3 class="text-center font-weight-light my-4">Find a flight</h3></div>
                        <div class="card-body">
                            <form method="post" action="">
                                <div class="row mb-3">
                                    <div class="col-md-6">
                                        <div class="form-floating mb-3 mb-md-0">
                                            <select name="departureIcao" class="form-control">
                                                <option value="">Departure</option>
                                                <c:forEach items="${departuresList}" var="dep">
                                                    <option value="${dep.icao}">${dep.airport}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-floating mb-3 mb-md-0">
                                            <select name="arrivalIcao" class="form-control">
                                                <option value="">Arrival</option>
                                                <c:forEach items="${arrivalsList}" var="arr">
                                                    <option value="${arr.icao}">${arr.airport}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-floating mb-3">
                                    <input class="form-control" id="date" type="date" name="date"/>
                                    <label for="date">Date</label>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-md-6">
                                        <div class="form-floating mb-3 mb-md-0">
                                            <select name="number" class="form-control">
                                                <option value="">Flight Number</option>
                                                <c:forEach items="${numbers}" var="n">
                                                    <option value="${n}">${n}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-floating mb-3 mb-md-0">
                                            <select name="airline" class="form-control">
                                                <option value="">Airline</option>
                                                <c:forEach items="${airlinesList}" var="airline">
                                                    <option value="${airline.name}">${airline.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="mt-4 mb-0">
                                    <div class="d-grid">
                                        <div class="form-floating mb-3 mb-md-0">
                                            <input class="form-control btn btn-primary btn-block" type="submit"
                                                   value="Search"/>
                                        </div>
                                    </div>
                                </div>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%--    FORM END    --%>

        <%--        TABLE--%>
        <div class="card-body">
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
                    <th>Airlines</th>
                    <th>Details</th>
                    <th>Ticket</th>
                </tr>
                </tfoot>
                <tbody>
                <c:forEach items="${flights.data}" var="data">
                    <tr>
                        <td>${data.flightDate}</td>
                        <td>${data.departure.airport}</td>
                        <td>${data.arrival.airport}</td>
                        <td>${data.flight.number}</td>
                        <td>${data.airline.name}</td>

                        <td><a href="flight/${data.flight.number}">view 📃</a></td>
                        <td><a href="/user/${currentuser.user.id}/book/${data.flight.number}">Book a ticket ✈</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <script>   $(document).ready(function () {
            $('#datatablesSimple').DataTable();
        });
        </script>
    </main>
    <%--        END--%>


    <%--  FOOTER  --%>
    <%@ include file="/fragment/footer.jsp" %>

