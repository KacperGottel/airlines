<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%--HEADER--%>
<%@ include file="/fragment/header.jsp" %>

<%-- MAIN  --%>
<div id="layoutSidenav_content">
    <main>
        <div class="container-xxl">
            <h2>Submitted File</h2>
            <table>
                <tr class="border-1">
                    <td>File Name:</td>
                    <td>${file.originalFilename}</td>
                </tr>
                <tr>
                    <td>Type:</td>
                    <td>${file.contentType}</td>
                </tr>
                <tr>
                    <td>Size:</td>
                    <td>${file.size}bytes</td>
                </tr>
                <tr>
                    <td><a href="/user/${currentuser.user.id}/show" class="btn btn-outline-dark block border-5">Show file</a>
                        <a href="/user/${currentuser.user.id}/download"
                           class="btn btn-outline-warning block border-5">Download</a>
                        <a href="/" class="btn btn-outline-info block border-5">Go back!</a>
                    </td>
                </tr>
            </table>
        </div>
    </main>

    <%--  FOOTER  --%>
    <%@ include file="/fragment/footer.jsp" %>


