<link href="/css/reg.css" rel="stylesheet">
<!-- Custom styles for this template -->


<div class="container">
    <form class="form-horizontal" action="/registration" method="post" role="form" >
        <jsp:useBean id="emailSUP" scope="request"
                     class="java.lang.String"/>

        <c:if test="${!emailSUP.equals('')}">
            <h3><fmt:message key="${emailSUP}"/></h3>
        </c:if>

        <h2><fmt:message key="registration"/></h2>
        <div class="form-group">
            <label for="firstName" class="col-sm-3 control-label"><fmt:message key="firstname"/></label>
            <div class="col-sm-9">
                <input type="text" id="firstName" class="form-control"  name="firstName" autofocus>

            </div>
        </div>

        <div class="form-group">
            <label for="secondName" class="col-sm-3 control-label"><fmt:message key="surname"/></label>
            <div class="col-sm-9">
                <input type="text" id="secondName" class="form-control" name="secondName" autofocus>
            </div>
        </div>

        <div class="form-group">
            <label for="email" class="col-sm-3 control-label"><fmt:message key="email"/></label>
            <div class="col-sm-9">
                <input type="email" id="email" placeholder="Email" name="email" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-3 control-label"><fmt:message key="password"/></label>
            <div class="col-sm-9">
                <input type="password" id="password" placeholder="Password" name="password" class="form-control">
            </div>
        </div>

        <div class="form-group">
            <label for="addres" class="col-sm-3 control-label"><fmt:message key="address"/></label>
            <div class="col-sm-9">
                <input type="text" id="addres" class="form-control"  name="addres" autofocus>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-9 col-sm-offset-3">
                <button type="submit" class="btn btn-primary btn-block"><fmt:message key="zareg"/></button>
            </div>
        </div>
    </form> <!-- /form -->
</div> <!-- ./container -->