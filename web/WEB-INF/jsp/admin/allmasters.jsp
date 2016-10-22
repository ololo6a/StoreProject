<link href="/css/allmasters.css" rel="stylesheet">
<!-- Custom styles for this template -->
<jsp:useBean id="all" scope="request"
             type="java.util.List<javacode.substance.Master>"/>





<table class="table" align="center">
    <thead>
    <th><fmt:message key="firstname"/></th>
    <th><fmt:message key="surname"/></th>
    <th><fmt:message key="email"/></th>
    <th><fmt:message key="balance"/></th>
    <th><fmt:message key="buyorders"/></th>
    <th><fmt:message key="sellorders"/></th>
    <th><fmt:message key="deletefrommaster"/></th>

    </thead>
    <tbody>
    <c:forEach var="item" items="${all}">
        <tr >
            <td>${item.firstName}</td>
            <td>${item.secondName}</td>
            <td>${item.email}</td>
            <td>${item.balance}</td>
            <td>${item.buyOrders}</td>
            <td>${item.sellOrders}</td>

            <c:if test="${!item.type.equals('admin')}">
             <form action ="/allmasters?id=${item.email}" method="post">
                    <td><button type="submit"><fmt:message key="deletefrommaster"/></button></td>
             </form>
            </c:if>
        </tr>

    </c:forEach>
    </tbody>

</table>