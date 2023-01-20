<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%
  List<String> colors = new ArrayList<>();
  colors.add("Default");
  colors.add("Red");
  colors.add("Green");

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

        <% for (String color : colors) { %>
          <a class="dropdown-item" href="#<%=color%>"><%=color%></a>
      <%  } %>
      </div>
    </li>
    <li class="nav-item">
      <a href="#tab5Id" class="nav-link">Another link</a>
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