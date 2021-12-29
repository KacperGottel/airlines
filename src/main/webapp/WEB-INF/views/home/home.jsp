<%--
  Created by IntelliJ IDEA.
  User: kacper
  Date: 28.12.2021
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%--HEADER--%>
<%@ include file="/fragment/header.jsp" %>


<%-- MAIN  --%>
<div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <div class="card-body">
                    <table id="datatablesSimple">
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Position</th>
                            <th>Office</th>
                            <th>Age</th>
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
            </div>
        </main>




<%--  FOOTER  --%>
<%@ include file="/fragment/footer.jsp" %>

