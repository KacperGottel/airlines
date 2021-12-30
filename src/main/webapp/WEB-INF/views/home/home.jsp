<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.css">

<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.js"></script>

<%--HEADER--%>
<%@ include file="/fragment/header.jsp" %>

<%-- MAIN  --%>
<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4">
            <div class="d-sm-flex align-items-center justify-content-between mb-4">
                <h1 class="h5 mb-0 text-gray-800">News</h1><small>"${feed.title}"</small><small>${feedPubDate}</small>
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
<%--        TABLE--%>

        <div class="card-body">
            <table id="datatablesSimple">
                <thead>
                <tr>
                    <th>Date</th>
                    <th>Departure</th>
                    <th>Arrival</th>
                    <th>Number</th>
                    <th>Start date</th>
                    <th>Salary</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>Name</th>
                    <th>Position</th>
                    <th>Office</th>
                    <th>Age</th>
                    <th>Start date</th>
                    <th>Salary</th>
                </tr>
                </tfoot>
                <tbody>
                <tr>
                    <td>Tiger Nixon</td>
                    <td>System Architect</td>
                    <td>Edinburgh</td>
                    <td>61</td>
                    <td>2011/04/25</td>
                    <td>$320,800</td>
                </tr>
                </tbody>
            </table>
        </div>

<%--        END--%>
    </main>

    <%--  FOOTER  --%>
    <%@ include file="/fragment/footer.jsp" %>

