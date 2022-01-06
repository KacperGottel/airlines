<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<%--HEADER--%>
<%@ include file="/fragment/header.jsp" %>

<%-- MAIN  --%>
<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4"><br>
            <%--    TBL--%>
            <div class="card-body">
                <table id="datatablesSimple" class="display" style="width:100%">
                    <thead>
                    <tr>
                        <th>Flight number</th>
                        <th>Details</th>
                        <th>Cancel</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>Flight number</th>
                        <th>Details</th>
                        <th>Cancel</th>
                    </tr>
                    </tfoot>
                    <tbody>
                    <c:forEach items="${tickets}" var="t">
                        <tr>
                            <td>${t.flightNumber}</td>
                            <td><a href="/ticket/${t.id}" class="btn btn-outline-info btn-sm active">details</a></td>
                            <td><a type="button" class="btn btn-danger active" href="/ticket/${t.id}/delete">cancel</a>

<!-- Button trigger modal -->
<%--                                <button type="button" class="btn btn-danger btn-sm active"--%>
<%--                                        href="/ticket/${t.id}/delete"--%>
<%--                                        data-toggle="modal"--%>
<%--                                        data-target="#exampleModalCenter${t.id}" aria-pressed="true">--%>
<%--                                    cancel--%>
<%--                                </button>--%>

<%--                                <!-- Modal -->--%>
<%--                                <div class="modal fade" id="exampleModalCenter${t.id}" tabindex="-1"--%>
<%--                                     role="dialog" aria-labelledby="exampleModalCenterTitle${t.id}"--%>
<%--                                     aria-hidden="true">--%>
<%--                                    <div class="modal-dialog modal-dialog-centered" role="document">--%>
<%--                                        <div class="modal-content">--%>
<%--                                            <div class="modal-header">--%>
<%--                                                <h5 class="modal-title"--%>
<%--                                                    id="exampleModalCenterTitle${t.id}">Cancel ticket</h5>--%>
<%--                                                <button type="button" class="close" data-dismiss="modal"--%>
<%--                                                        aria-label="Close">--%>
<%--                                                    <span aria-hidden="true">&times;</span>--%>
<%--                                                </button>--%>
<%--                                            </div>--%>
<%--                                            <div class="modal-body">--%>
<%--                                                Are you sure you want to cancel ticket with flight--%>
<%--                                                No.: ${t.flightNumber}?--%>
<%--                                            </div>--%>
<%--                                            <div class="modal-footer">--%>
<%--                                                <a type="button" class="btn btn-danger active"--%>
<%--                                                   aria-pressed="true"--%>
<%--                                                   href="/ticket/${t.id}/delete">Cancel</a>--%>
<%--                                                <a type="button" class="btn btn-dark active"--%>
<%--                                                   aria-pressed="true"--%>
<%--                                                   data-dismiss="modal">No</a>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                        MODAL ends--%>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </main>
    <script>   $(document).ready(function () {
        $('#datatablesSimple').DataTable();
    });
    </script>
    <%--    TBL--%>
    <%--  FOOTER  --%>
    <%@ include file="/fragment/footer.jsp" %>

