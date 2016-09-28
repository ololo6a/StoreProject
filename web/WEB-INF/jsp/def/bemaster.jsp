<link href="/css/bemaster.css" rel="stylesheet">
<!-- Custom styles for this template -->


<div class="container">
    <form class="form-horizontal" action="/bemaster" method="post" role="form" >

        <jsp:useBean id="isit" scope="request"
                     class="java.lang.String"/>

        <c:if test="${isit.equals('done')}">
            <h3><fmt:message key="done"/></h3>
        </c:if>

        <c:if test="${isit.equals('error')}">
            <h3>Error!</h3>
        </c:if>


        <h2><fmt:message key="bemaster"/></h2>
        <div class="form-group">
            <label for="text" class="col-sm-3 control-label"><fmt:message key="insertsometext"/></label>
            <div class="col-sm-9">
                <input type="text" id="text" maxlength="199" class="form-control"  name="text" autofocus>
            </div>


            <div class="col-sm-9 col-sm-offset-3">
                <button type="submit" class="btn btn-primary btn-block"><fmt:message key="sendarequest"/></button>
            </div>
        </div>
    </form> <!-- /form -->
</div> <!-- ./container -->