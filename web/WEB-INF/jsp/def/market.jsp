<%@ page import="javacode.DAO.Connection" %>
<%@ page import="java.io.OutputStream" %>
<script type="text/javascript" src="/jquery/addimage.min.js"></script>
<link href="/css/market.css" rel="stylesheet">

<!-- Custom styles for this template -->

<jsp:useBean id="allmy" scope="request"
             type="java.util.List<javacode.substance.Product>"/>

<c:forEach var="item" items="${allmy}" varStatus="status" step="3">

        <div class="row" >

            <div class="col-md-4">

               <div class="profileimage">
                        <img  class="img" height="300" width="300" alt="img" src="data:image/jpeg;base64,${item.stringImage}"/>
               </div>

                <br>
                <span  class="label label-primary" ><fmt:message key="price"/> : ${item.price} $ </span>
                <br><br>
                <label>  ${item.name}  </label>


                <table>
                    <br>
                    <tbody>

                    <form action="/market?prod=${item.id_product}&id=${item.type}" method="post">
                        <td>
                        <button class="btn btn-md btn-block btn-success"  type="submit"><fmt:message key="buy"/></button>
                      </td>
                        <td>
                        <input type="number"  value="1" step="1"  min="1" max="${item.count}" id="count${item.id_product}" name="count${item.id_product}">
                        </td>
                    </form>


                    <td>
                        <button class="btn btn-md btn-block btn-link"  >
                            <a href="/authorprofile?id=${item.id_master}">
                                <fmt:message key="authorprofile"/>
                            </a>
                        </button>
                    </td>

                    </tbody>
                </table>


                <c:if test="${item.count<=0}">
                        <label><fmt:message key="empty"/></label>
                </c:if>
            </div>


            <c:if test="${allmy.size()-1>=(status.index+1)}">

                <div class="col-md-4">

                    <div class="profileimage">
                        <img  class="img" height="300" width="300" alt="img" src="data:image/jpeg;base64,${allmy[status.index+1].stringImage}"/>
                    </div>
                    <br>
                    <span  class="label label-primary" ><fmt:message key="price"/> : ${allmy[status.index+1].price} $ </span>
                    <br><br>
                    <label>  ${allmy[status.index+1].name}  </label>

                    <table>
                        <br>
                        <tbody>
                        <form action="/market?prod=${allmy[status.index+1].id_product}&id=${item.type}" method="post">
                            <td>
                                <button class="btn btn-md btn-block btn-success"  type="submit"><fmt:message key="buy"/></button>
                            </td>
                            <td>
                                <input type="number"  value="1" step="1" max="${allmy[status.index+1].count}" min="1" id="count${allmy[status.index+1].id_product}" name="count${allmy[status.index+1].id_product}">
                            </td>
                        </form>


                            <td>
                                <button class="btn btn-md btn-block btn-link"  >
                                    <a href="/authorprofile?id=${allmy[status.index+1].id_master}">
                                        <fmt:message key="authorprofile"/>
                                    </a>
                                   </button>
                            </td>

                        </tbody>
                    </table>
                    <c:if test="${allmy[status.index+1].count<=0}">
                        <label><fmt:message key="empty"/></label>
                    </c:if>
                </div>
            </c:if>

            <c:if test="${allmy.size()-1>=(status.index+2)}">


                <div class="col-md-4">

                    <div class="profileimage">
                        <img  class="img" height="300" width="300" alt="img" src="data:image/jpeg;base64,${allmy[status.index+2].stringImage}"/>
                    </div>
                    <br>
                    <span  class="label label-primary" ><fmt:message key="price"/> : ${allmy[status.index+2].price} $ </span>
                    <br><br>
                    <label>  ${allmy[status.index+2].name}  </label>
                    <table>
                        <br>
                        <tbody>
                        <form action="/market?prod=${allmy[status.index+2].id_product}&id=${item.type}" method="post">
                            <td>
                                <button class="btn btn-md btn-block btn-success"  type="submit"><fmt:message key="buy"/></button>
                            </td>
                            <td>
                                <input type="number"  value="1" step="1" min="1"  max="${allmy[status.index+2].count}" id="count${allmy[status.index+2].id_product}" name="count${allmy[status.index+2].id_product}">
                            </td>
                        </form>


                        <td>
                            <button class="btn btn-md btn-block btn-link"  >
                                <a href="/authorprofile?id=${allmy[status.index+2].id_master}">
                                    <fmt:message key="authorprofile"/>
                                </a>
                            </button>
                        </td>

                        </tbody>
                    </table>
                    <c:if test="${allmy[status.index+2].count<=0}">
                        <label><fmt:message key="empty"/></label>
                    </c:if>
                </div>
            </c:if>
        </div>


</c:forEach>


