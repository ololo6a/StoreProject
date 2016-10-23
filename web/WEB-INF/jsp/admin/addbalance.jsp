<link href="/css/reg.css" rel="stylesheet">
<!-- Custom styles for this template -->


<div class="container">
    <form class="form-horizontal" action="/addbalance" method="post" role="form" >
        <jsp:useBean id="isadded" scope="request"
                     class="java.lang.String"/>

        <c:if test="${isadded.equals('true')}">
            <h3><fmt:message key="done"/></h3>
        </c:if>

        <c:if test="${isadded.equals('false')}">
            <h3><fmt:message key="error"/></h3>
        </c:if>

        <div class="form-group">
            <label for="email" class="col-sm-3 control-label"><fmt:message key="email"/></label>
            <div class="col-sm-9">
                <input type="text" id="email" placeholder="Email" class="form-control"  name="email" autofocus>

            </div>
        </div>


        <div class="form-group">
            <label for="balance" class="col-sm-3 control-label"><fmt:message key="sum"/></label>
            <div class="col-sm-9">
                <input type="number" step="0.01" id="balance"   name="balance" class="form-control">
            </div>
        </div>



        <div class="form-group">
            <div class="col-sm-9 col-sm-offset-3">
                <button type="submit" class="btn btn-primary btn-block"><fmt:message key="addbalance"/></button>
            </div>
        </div>
    </form> <!-- /form -->
</div> <!-- ./container -->