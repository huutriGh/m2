<%@ page import="com.aptech.blog.ApplicationSettings" %>
<%@ page import="com.aptech.blog.Topic" %>
<%@ page import="java.util.List" %>
<div>
    <h3>Topics</h3>
    <ul>
        <li><a href="/topic/all.do">All</a></li>
        <%
            ApplicationSettings app = (ApplicationSettings) request.getServletContext().getAttribute("app");
            List<Topic> topics = app.getTopicList().getTopics();
            for (Topic topic : topics) { %>
        <li><a href="/topic/<%=topic.url()%>"><%=topic.title()%>
        </a></li>
        <% } %>
    </ul>
</div>