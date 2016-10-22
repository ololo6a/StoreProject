<%@ page import="javacode.DAO.Connection" %>
<%@ page import="java.io.OutputStream" %>
<script type="text/javascript" src="/jquery/addimage.min.js"></script>
<link href="/css/profile.css" rel="stylesheet">

<!-- Custom styles for this template -->

<jsp:useBean id="allmy" scope="request"
             type="java.util.List<javacode.substance.Product>"/>
<c:forEach var="item" items="${allmy}">

<form class="form"  >


    <div class="row" >

            <div class="col-lg-4">
              <div class="profileimage">
                        <img  class="img" height="300" width="300" alt="img" src="data:image/jpeg;base64,${item.stringImage}"/>
              </div>
            </div>


        <div class="col-lg-6">

            <div class="form-group">

                <label for="id" class="col-sm-3 control-label">ID</label>
                <div class="col-sm-9">
                    <input value="${item.id_product}"  class="form-control" id="id" readonly>
                </div>
            </div>

            <div class="form-group">

                <label for="name" class="col-sm-3 control-label"><fmt:message key="name"/></label>
                <div class="col-sm-9">
                    <input value="${item.name}"  class="form-control" id="name" readonly>
                </div>
            </div>

            <div class="form-group">

                <label for="type" class="col-sm-3 control-label"><fmt:message key="type"/></label>
                <div class="col-sm-9">
                    <input value="${item.type}"  class="form-control"  id="type" readonly>
                </div>
            </div>

            <div class="form-group">

                <label for="count" class="col-sm-3 control-label"><fmt:message key="count"/></label>
                <div class="col-sm-9">
                    <input value="${item.count}" class="form-control"  id="count" readonly>
                </div>
            </div>

            <div class="form-group">

                <label for="price" class="col-sm-3 control-label"><fmt:message key="price"/></label>
                <div class="col-sm-9">
                    <input value="${item.price}"  class="form-control" id="price" readonly>
                </div>
            </div>

            <form></form>


                <div class="col-sm-9 col-sm-offset-3">
                    <br>
                    <button type="button" class="btn btn-link btn-block" >
                        <a href="/change?id=${item.id_product}&type=change"><fmt:message key="edit"/></a>
                    </button>
                </div>


            <form  action="/mythings?id=${item.id_product}" method="post"  >
                <div class="col-sm-9 col-sm-offset-3">
                    <br>
                    <button type="submit" class="btn btn-danger btn-block"><fmt:message key="delete"/></button>
                </div>
            </form>

        </div>


    </div>
</form>



</c:forEach>


