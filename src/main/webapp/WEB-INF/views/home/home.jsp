<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800">News</h1>
                </div>

                <c:forEach items="${feed.messages}" var="m" varStatus="theCount">
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h4 class="m-0 font-weight-bold text-primary">${theCount.count}.${m.title}</h4>
                        </div>
                        <div class="card-body">
                                ${m.description}
                                ${feed.pubDate}
                        </div>
                        <button class="btn"><a href="${m.link}" target="_blank" rel="noopener noreferrer"><span class="text-gray-500">Read more</span></a></button>
                    </div>
                </c:forEach>
                <br>
                <div>
                    Copyright © &nbsp;${feed.copyright}
                </div>
            </div>
        </main>




<%--  FOOTER  --%>
<%@ include file="/fragment/footer.jsp" %>

