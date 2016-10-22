<%@ page import="javacode.DAO.Connection" %>
<%@ page import="java.io.OutputStream" %>
<script type="text/javascript" src="/jquery/addimage.min.js"></script>
<link href="/css/profile.css" rel="stylesheet">

<!-- Custom styles for this template -->

<jsp:useBean id="isadded" scope="request" class="java.lang.String"/>
<jsp:useBean id="user_session" scope="session" class="javacode.substance.People"/>




<form class="form" enctype="multipart/form-data" action="/newthing" method="post" role="form">

    <jsp:useBean id="isit" scope="request"
                 class="java.lang.String"/>

    <c:if test="${!isit.equals('')}">
        <h3><fmt:message key="${isit}"/></h3>
    </c:if>

    <div class="row" >

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
            </div>

        <div class="col-lg-6">

            <div class="form-group">
                <label for="name" class="col-sm-3 control-label"><fmt:message key="name"/></label>
                <div class="col-sm-9">
                    <input type="text" id="name" class="form-control" name="name" autofocus required >

                </div>
            </div>

            <div class="form-group">
                <datalist id="typelist">
                    <option value="toy">
                    <option value="thing">
                </datalist>
                <label for="type" class="col-sm-3 control-label"><fmt:message key="type"/></label>
                <div class="col-sm-9">
                    <input list="typelist" id="type" class="form-control"  name="type" autofocus required >
                </div>
            </div>

            <div class="form-group">
                <label for="price" class="col-sm-3 control-label"><fmt:message key="price"/></label>
                <div class="col-sm-9">
                    <input type="number" step="0.01" id="price" name="price" class="form-control" min="0" required >
                </div>
            </div>

            <div class="form-group">
                <label for="count" class="col-sm-3 control-label"><fmt:message key="count"/></label>
                <div class="col-sm-9">
                    <input type="number" step="1" id="count" class="form-control"  name="count"   min="0"  required>
                </div>
            </div>

            <br>
            <br>
            <div class="col-sm-9 col-sm-offset-3">
                <br>
                <button type="submit" class="btn btn-primary btn-block"><fmt:message key="add"/></button>
            </div>
        </div>
    </div> <!-- ./container -->
</form>



