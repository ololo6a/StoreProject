<%@ page import="javacode.DAO.Connection" %>
<%@ page import="java.io.OutputStream" %>
<script type="text/javascript" src="/jquery/addimage.min.js"></script>
<link href="/css/profile.css" rel="stylesheet">

<!-- Custom styles for this template -->

<jsp:useBean id="product" scope="request"
             type="javacode.substance.Product"/>


<form class="form" enctype="multipart/form-data"  action="/change?id=${product.id_product}&type=save" method="post" >


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

    <div class="row" >
        <br><br><br> <br>
        <div class="col-lg-4">
            <div class="profileimage">
                <img  class="img" height="300" width="300" alt="img" src="data:image/jpeg;base64,${product.stringImage}"/>
            </div>
        </div>


        <div class="col-lg-6">

            <div class="form-group">

                <label for="id" class="col-sm-3 control-label">ID</label>
                <div class="col-sm-9">
                    <input value="${product.id_product}"  class="form-control" id="id" readonly>
                </div>
            </div>

            <div class="form-group">

                <label for="name" class="col-sm-3 control-label"><fmt:message key="name"/></label>
                <div class="col-sm-9">
                    <input value="${product.name}"  class="form-control" id="name" name ="name">
                </div>
            </div>

            <div class="form-group">

                <label for="ptype" class="col-sm-3 control-label"><fmt:message key="type"/></label>
                <div class="col-sm-9">
                    <input value="${product.type}"  class="form-control"  id="ptype" name="ptype">
                </div>
            </div>

            <div class="form-group">

                <label for="count" class="col-sm-3 control-label"><fmt:message key="count"/></label>
                <div class="col-sm-9">
                    <input value="${product.count}" class="form-control"  id="count" name="count">
                </div>
            </div>

            <div class="form-group">

                <label for="price" class="col-sm-3 control-label"><fmt:message key="price"/></label>
                <div class="col-sm-9">
                    <input value="${product.price}"  class="form-control" id="price" name="price">
                </div>
            </div>



                <div class="col-sm-9 col-sm-offset-3">
                    <br>
                    <button type="submit" class="btn btn-primary btn-block"><fmt:message key="save"/></button>
                </div>


        </div>


    </div>
</form>