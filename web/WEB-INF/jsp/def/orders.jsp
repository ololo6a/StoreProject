<link href="/css/allmasters.css" rel="stylesheet">
<!-- Custom styles for this template -->
<jsp:useBean id="myOrders" scope="request"
             type="java.util.List<javacode.substance.Order>"/>





<table class="table" align="center">
    <thead>
    <th><fmt:message key="orderid"/></th>
    <th><fmt:message key="productid"/></th>
    <th><fmt:message key="masterid"/></th>
    <th><fmt:message key="peopleid"/></th>
    <th><fmt:message key="productcount"/></th>
    <th><fmt:message key="price"/></th>
    <th><fmt:message key="date"/></th>
    <th><fmt:message key="address"/></th>
    <th><fmt:message key="name"/></th>
    <th><fmt:message key="surname"/></th


    </thead>
    <tbody>
    <c:forEach var="item" items="${myOrders}">

        <c:if test="${user_session.id_people == item.id_people }">


        <tr class="success">
            <td>${item.id_order}</td>
            <td>${item.id_product}</td>
            <td>${item.id_master}</td>
            <td>${item.id_people}</td>
            <td>${item.count}</td>
            <td>${item.price}</td>
            <td>${item.date}</td>
            <td>${item.addres}</td>
            <td>${item.name}</td>
            <td>${item.surname}</td>

        </tr>

        </c:if>

        <c:if test="${user_session.id_people == item.id_master }">


            <tr class="danger">
                <td>${item.id_order}</td>
                <td>${item.id_product}</td>
                <td>${item.id_master}</td>
                <td>${item.id_people}</td>
                <td>${item.count}</td>
                <td>${item.price}</td>
                <td>${item.date}</td>
                <td>${item.addres}</td>
                <td>${item.name}</td>
                <td>${item.surname}</td>

            </tr>

        </c:if>

    </c:forEach>
    </tbody>

</table>