<%@ page import="javacode.DAO.Connection" %>
<%@ page import="java.io.OutputStream" %>
<script type="text/javascript" src="/jquery/addimage.min.js"></script>
<link href="/css/profile.css" rel="stylesheet">

<!-- Custom styles for this template -->

<jsp:useBean id="master" scope="request" class="javacode.substance.Master"/>


<form class="form" >

  <div class="row" >

            <div class="col-lg-4" >
                <div class="profileimage">
                    <br>
                    <img  height="300" width="300" class="img-circle" alt="img" src="data:image/jpeg;base64,${master.stringImage}"/>
                </div>
            </div>

        <div class="col-lg-6">

            <div class="form-group">
                <label for="firstName" class="col-sm-3 control-label"><fmt:message key="firstname"/></label>
                <div class="col-sm-9">
                    <input type="text" id="firstName" class="form-control" value=${master.firstName}  name="firstName" readonly>

                </div>
            </div>

            <div class="form-group">
                <label for="secondName" class="col-sm-3 control-label"><fmt:message key="surname"/></label>
                <div class="col-sm-9">
                    <input type="text" id="secondName" class="form-control" value=${master.secondName}  name="secondName" readonly>
                </div>
            </div>

            <div class="form-group">
                <label for="email" class="col-sm-3 control-label"><fmt:message key="email"/></label>
                <div class="col-sm-9">
                    <input type="email" id="email" placeholder="Email" name="email" value=${master.email}  class="form-control" readonly>
                </div>
            </div>

        </div>
    </div> <!-- ./container -->
</form>



