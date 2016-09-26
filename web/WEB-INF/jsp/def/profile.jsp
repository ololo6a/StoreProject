
<script type="text/javascript" src="/jquery/addimage.min.js"></script>
<link href="/css/profile.css" rel="stylesheet">
<!-- Custom styles for this template -->
<div class="container">
    <form class="form-group" action="/profile" method="post" enctype="multipart/form-data" >

        <div class="line">
            <!-- image-preview-filename input [CUT FROM HERE]-->
            <div class="input-group image-preview">
                <input type="text" class="form-control image-preview-filename" disabled="disabled"> <!-- don't give a name === doesn't send on POST/GET -->
                <span class="input-group-btn">
                    <!-- image-preview-clear button -->
                    <button type="button" class="btn btn-default image-preview-clear" style="display:none;">
                        <span class="glyphicon glyphicon-remove"></span> Clear
                    </button>
                    <!-- image-preview-input -->
                    <div class="btn btn-default image-preview-input">
                        <span class="glyphicon glyphicon-folder-open"></span>
                        <span class="image-preview-input-title">Browse</span>
                        <input type="file" accept="image/png, image/jpeg, image/gif" name="input-file-preview"/> <!-- rename it -->
                    </div>
                </span>
                <div class="col-sm-9 col-sm-offset-3">
                    <button type="submit" class="btn btn-primary btn-block"><fmt:message key="zareg"/></button>
                </div>
            </div><!-- /input   -group image-preview [TO HERE]-->

        </div>
        </form>
    </div>


<div class="profileimage">
        <jsp:useBean id="imgData" scope="request"
        class="java.lang.Byte"/>

    <c:if test="${imgData != null}">
        <img class="featurette-image img-responsive" src="${imgData}" alt="Generic placeholder image">
    </c:if>
    </div>

</div>