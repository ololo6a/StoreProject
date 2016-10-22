<link href="/css/userbyemail.css" rel="stylesheet">



<!-- Custom styles for this template -->


<form class="form" action="/userbyemail" method="post" role="form" >

    <div class="form-group">
        <label for="newemail" class="col-sm-3 control-label"><fmt:message key="email"/></label>
        <div class="col-sm-9">
            <input type="email" id="newemail" maxlength="199" class="form-control"  name="newemail" autofocus>
        </div>

        <div class="col-sm-9 col-sm-offset-3">
            <button type="submit" class="btn btn-primary btn-block">OK</button>
        </div>
    </div>
</form> <!-- /form -->
<br><br><br><br><br><br><br><br>
<c:if test="${people.type!=null}">
<form >
    <div class="row" >


        <c:if test="${!people.type.equals('user')}">
            <div class="col-lg-4">
            <form>
                <div class="profileimage">
                    <br>
                    <img  class="img-circle" alt="img" src="data:image/jpeg;base64,${master.stringImage}"/>
                </div>
            </form>
                </div>
        </c:if>

        <div class="col-lg-6">

            <div class="form-group">
                <label for="id" class="col-sm-3 control-label">ID</label>
                <div class="col-sm-9">
                    <input type="text" id="id" class="form-control" value=${people.id_people}  name="id" readonly>

                </div>
            </div>

            <div class="form-group">
                <label for="firstName" class="col-sm-3 control-label"><fmt:message key="firstname"/></label>
                <div class="col-sm-9">
                    <input type="text" id="firstName" class="form-control" value=${people.firstName}  name="firstName" readonly>

                </div>
            </div>

            <div class="form-group">
                <label for="secondName" class="col-sm-3 control-label"><fmt:message key="surname"/></label>
                <div class="col-sm-9">
                    <input type="text" id="secondName" class="form-control" value=${people.secondName}  name="secondName" readonly>
                </div>
            </div>

            <div class="form-group">
                <label for="email" class="col-sm-3 control-label"><fmt:message key="email"/></label>
                <div class="col-sm-9">
                    <input type="email" id="email" placeholder="Email" name="email" value=${people.email}  class="form-control" readonly>
                </div>
            </div>

            <div class="form-group">
                <label for="addres" class="col-sm-3 control-label"><fmt:message key="address"/></label>
                <div class="col-sm-9">
                    <input type="text" id="addres" class="form-control"  name="addres" value=${people.addres}  readonly>
                </div>
            </div>

            <div class="form-group">
                <label for="balance" class="col-sm-3 control-label"><fmt:message key="balance"/></label>
                <div class="col-sm-9">
                    <input type="text" id="balance" class="form-control"  name="balance" value=${people.balance} readonly >
                </div>
            </div>

        </div>
    </div> <!-- ./row -->
</form>

    <br><br><br><br>
<table class="table" align="center">
    <thead>
    <th><fmt:message key="orderid"/></th>
    <th><fmt:message key="productid"/></th>
    <th><fmt:message key="masterid"/></th>
    <th><fmt:message key="peopleid"/></th>
    <th><fmt:message key="productcount"/></th>
    <th><fmt:message key="price"/></th>
    <th><fmt:message key="date"/></th>

    </thead>
    <tbody>
    <c:forEach var="item" items="${myOrders}">

        <c:if test="${people.id_people == item.id_people }">


            <tr class="success">
                <td>${item.id_order}</td>
                <td>${item.id_product}</td>
                <td>${item.id_master}</td>
                <td>${item.id_people}</td>
                <td>${item.count}</td>
                <td>${item.price}</td>
                <td>${item.date}</td>

            </tr>

        </c:if>

        <c:if test="${people.id_people == item.id_master }">


            <tr class="danger">
                <td>${item.id_order}</td>
                <td>${item.id_product}</td>
                <td>${item.id_master}</td>
                <td>${item.id_people}</td>
                <td>${item.count}</td>
                <td>${item.price}</td>
                <td>${item.date}</td>

            </tr>

        </c:if>

    </c:forEach>
    </tbody>

</table>
</c:if>