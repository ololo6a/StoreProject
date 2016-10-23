<%@ page import="javacode.DAO.Connection" %>
<%@ page import="java.io.OutputStream" %>
<script type="text/javascript" src="/jquery/addimage.min.js"></script>
<link href="/css/profile.css" rel="stylesheet">

<!-- Custom styles for this template -->

<jsp:useBean id="master" scope="request" class="javacode.substance.Master"/>
<jsp:useBean id="user_session" scope="session" class="javacode.substance.People"/>




    <form class="form" enctype="multipart/form-data" action="/profile" method="post" role="form">

        <jsp:useBean id="change" scope="request"
                     class="java.lang.String"/>

        <c:if test="${!change.equals('')}">
            <h3><fmt:message key="${change}"/></h3>
        </c:if>

        <div class="row" >
            <c:if test="${!user_session.type.equals('user')}">
            <div class="col-lg-4" >
                    <div class="line">
                        <!-- image-preview-filename input [CUT FROM HERE]-->
                        <div class="input-group image-preview">
                            <input type="text" class="form-control image-preview-filename" id="link" name="link"   disabled="disabled"> <!-- don't give a name === doesn't send on POST/GET -->
                            <span class="input-group-btn">
                                <!-- image-preview-clear button -->
                                <button type="button" class="btn btn-default image-preview-clear" style="display:none;">
                                    <span class="glyphicon glyphicon-remove"></span> Clear
                                </button>
                                <!-- image-preview-input -->
                                <div class="btn btn-default image-preview-input">
                                    <span class="glyphicon glyphicon-folder-open"></span>
                                    <span class="image-preview-input-title">Browse</span>
                                    <input type="file" accept="image/png, image/jpeg, image/gif" name="photo"/> <!-- rename it -->
                                </div>
                            </span>
                         </div>
                    </div><!-- /input   -group image-preview [TO HERE]-->

                    <div class="profileimage">
                        <br>
                        <img  height="300" width="300" class="img-circle" alt="img" src="data:image/jpeg;base64,${master.stringImage}"/>
                    </div>
                </div>
            </c:if>

                <div class="col-lg-6">

                    <div class="form-group">
                        <label for="firstName" class="col-sm-3 control-label"><fmt:message key="firstname"/></label>
                        <div class="col-sm-9">
                            <input type="text" id="firstName" class="form-control" value=${user_session.firstName}  name="firstName" autofocus>

                        </div>
                    </div>

                    <div class="form-group">
                        <label for="secondName" class="col-sm-3 control-label"><fmt:message key="surname"/></label>
                        <div class="col-sm-9">
                            <input type="text" id="secondName" class="form-control" value=${user_session.secondName}  name="secondName" autofocus>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email" class="col-sm-3 control-label"><fmt:message key="email"/></label>
                        <div class="col-sm-9">
                            <input type="email" id="email" placeholder="Email" name="email" value=${user_session.email}  class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="col-sm-3 control-label"><fmt:message key="password"/></label>
                        <div class="col-sm-9">
                            <input type="password" id="password" placeholder="Password" name="password"  value="" class="form-control">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="addres" class="col-sm-3 control-label"><fmt:message key="address"/></label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control"  id="addres"  name="addres" value="${user_session.addres}"  >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="balance" class="col-sm-3 control-label"><fmt:message key="balance"/></label>
                        <div class="col-sm-9">
                            <input type="text" id="balance" class="form-control"  name="balance" value=${user_session.balance} readonly >
                        </div>
                    </div>

                    <br>
                    <br>
                    <div class="col-sm-9 col-sm-offset-3">
                        <br>
                        <button type="submit" class="btn btn-primary btn-block"><fmt:message key="save"/></button>
                    </div>
                </div>
        </div> <!-- ./container -->
    </form>



