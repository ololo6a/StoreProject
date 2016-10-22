<!-- Custom styles for this template -->
<link href="/css/signin.css" rel="stylesheet">

<div class="container">
    <form class="form-signin" action="/signin" method="post" >
        <h2 class="form-signin-heading"><fmt:message key="pleasein"/></h2>
        <label for="inputEmail" class="sr-only"><fmt:message key="email"/></label>
        <input type="text" id="inputEmail" size="25" class="form-control" placeholder="email"  name="email" required autofocus>
        <label for="inputPassword" class="sr-only"><fmt:message key="password"/></label>
        <input type="password" id="inputPassword" class="form-control" placeholder="password" name="password" required>

        <br>
        <button class="btn btn-lg btn-block btn-info" size="25" type="submit"><fmt:message key="singin"/></button>
    </form>
</div> <!-- /container -->