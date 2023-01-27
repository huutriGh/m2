<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
  <div class="container">
    <form action="login.do" method="POST">
      <div class="form-group row bg-light login-form">

        <div class="col-12">
          <input type="text" class="form-control" name="username" id="user" placeholder="User">
        </div>
        <div class="col-12">
          <input type="text" class="form-control" name="password" id="password" placeholder="Password">
        </div>
        <div class="col-12">
          <div class="form-check">
            <input class="form-check-input" type="checkbox" id="rememberMe">
            <label class="form-check-label" for="rememberMe">Remember me</label>
          </div>
        </div>
      </div>

      <div class="form-group row">
        <div class="offset-sm-2 col-sm-10">
          <button type="submit" class="btn btn-primary">Login</button>
        </div>
      </div>
    </form>
  </div>
</div>