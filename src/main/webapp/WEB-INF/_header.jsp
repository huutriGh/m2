<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    List<String> colors = new ArrayList<>();
    colors.add("Default");
    colors.add("Red");
    colors.add("Green");
    pageContext.setAttribute("colors", colors);

%>
<header>
    <!-- Nav tabs -->
    <ul class="nav nav-tabs" id="navId">
        <li class="nav-item">
            <a href="#tab1Id" class="nav-link active">Active</a>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
               aria-expanded="false">Dropdown</a>
            <div class="dropdown-menu">

                <%--        <% for (String color : colors) { %>--%>
                <%--          <a class="dropdown-item" href="#<%=color%>"><%=color%></a>--%>
                <%--      <%  } %>--%>
                <%--                <c:choose>--%>
                <%--                    <c:when test="${!empty sessionScope.user}">--%>
                <%--                        <c:forEach items="${colors}" var="color">--%>
                <%--                            <a class="dropdown-item" href="${color}">${color}</a>--%>
                <%--                        </c:forEach>--%>
                <%--                    </c:when>--%>
                <%--                    <c:otherwise>--%>
                <%--                        <a href="#">No user login</a>--%>
                <%--                    </c:otherwise>--%>
                <%--                </c:choose>--%>
                <a class="dropdown-item" href="<c:url value ="/color.do?color=white"/>" >Default</a>
                <a class="dropdown-item" href="<c:url value ="/color.do?color=red"/>">Red</a>
                <a class="dropdown-item" href="<c:url value ="/color.do?color=blue"/>">Blue</a>

            </div>
        </li>
        <li class="nav-item">
            <c:if test="${empty sessionScope.user}">
            <a href="<c:url value="/showlogin.do"/>" class="nav-link">Login</a>
            </c:if>
            <c:if test="${!empty sessionScope.user}">
            <a href="<c:url value="/logout.do"/>" class="nav-link">Logout ${user.name}</a>
            </c:if>

        <li class="nav-item">
            <c:if test="${empty sessionScope.user ==false}">
                <a href="<c:url value="/add.do"/>" class="nav-link">Create new Item</a>
            </c:if>
        </li>


        </li>

        <li class="nav-item">
            <a href="#" class="nav-link disabled">Disabled</a>
        </li>
    </ul>

    <!-- Tab panes -->
    <div class="tab-content">
        <div class="tab-pane fade show active" id="tab1Id" role="tabpanel"></div>
        <div class="tab-pane fade" id="tab2Id" role="tabpanel"></div>
        <div class="tab-pane fade" id="tab3Id" role="tabpanel"></div>
        <div class="tab-pane fade" id="tab4Id" role="tabpanel"></div>
        <div class="tab-pane fade" id="tab5Id" role="tabpanel"></div>
    </div>

    <script>
        $('#navId a').click(e => {
            e.preventDefault();
            $(this).tab('show');
        });
    </script>
</header>