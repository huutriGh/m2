<%@ page import="com.aptech.blog.NewsItem" %>
<%@ page import="java.util.List" %>
<%@ page import="com.aptech.blog.NewsItems" %><%--
  Created by IntelliJ IDEA.
  User: ntngutr
  Date: 21/01/2023
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach items="${items}" var ="item" >
    <div>
        <h2><a href="<c:url value="/news/${item.title()}.do"/>">${item.title()}
        </a></h2>
        <div>
                ${item.entry()}
        </div>
    </div>
</c:forEach>

