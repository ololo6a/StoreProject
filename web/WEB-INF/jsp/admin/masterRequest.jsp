<link href="/css/allmasters.css" rel="stylesheet">
<!-- Custom styles for this template -->
<jsp:useBean id="allreq" scope="request"
             type="java.util.List<javacode.substance.People>"/>





<table class="table" align="center">
    <thead>
    <th><fmt:message key="firstname"/></th>
    <th><fmt:message key="surname"/></th>
    <th><fmt:message key="email"/></th>
    <th><fmt:message key="accept"/></th>
    <th><fmt:message key="delete"/></th>

    </thead>
    <tbody>
    <c:forEach var="item" items="${allreq}">
        <tr >
            <td>${item.firstName}</td>
            <td>${item.secondName}</td>
            <td>${item.email}</td>


            <form action ="/masterRequest?id=${item.email}&is=accept" method="post">
                <td><button type="submit"><fmt:message key="accept"/></button></td>
            </form>
            <form action ="/masterRequest?id=${item.email}&is=accept" method="post">
                <td><button type="submit"><fmt:message key="delete"/></button></td>
            </form>

        </tr>

    </c:forEach>
    </tbody>

</table>