<link href="/css/carousel.css" rel="stylesheet">
<jsp:useBean id="master1" scope="request" class="javacode.substance.Master"/>
<jsp:useBean id="master2" scope="request" class="javacode.substance.Master"/>
<jsp:useBean id="master3" scope="request" class="javacode.substance.Master"/>



<!-- Carousel
================================================== -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
        <div class="item active">
            <img src="/image/baba.jpg" alt="First slide">

            <div class="container">
                <div class="carousel-caption">
                    <p><a class="btn btn-lg btn-primary" href="/market?id=thing" role="button"><fmt:message key="market"/></a></p>
                </div>
            </div>
        </div>
        <div class="item">
            <img src="/image/vyaz.jpg" alt="Second slide">
            <div class="container">
                <div class="carousel-caption">
                    <p><a class="btn btn-lg btn-primary" href="/market?id=thing" role="button"><fmt:message key="market"/></a></p>
                </div>
            </div>
        </div>
        <div class="item">
            <img src="/image/d244.jpg" alt="Third slide">
            <div class="container">
                <div class="carousel-caption">
                     <p><a class="btn btn-lg btn-primary" href="/market?id=toy" role="button"><fmt:message key="market"/></a></p>
                </div>
            </div>
        </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
</div><!-- /.carousel -->

<div class="container marketing">

    <!-- Three columns of text below the carousel -->
    <div class="row">
        <div class="col-lg-4">
            <img  height="200" width="200" class="img-circle" alt="img" src="data:image/jpeg;base64,${master1.stringImage}"/>
            <h2>${master1.firstName} ${master1.secondName}</h2>
            <p><a class="btn btn-default" href="/authorprofile?id=${master1.id_people}" role="button"><fmt:message key="profile"/> &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
            <img  height="200" width="200" class="img-circle" alt="img" src="data:image/jpeg;base64,${master2.stringImage}"/>
            <h2>${master2.firstName} ${master2.secondName}</h2>
            <p><a class="btn btn-default" href="/authorprofile?id=${master2.id_people}" role="button"><fmt:message key="profile"/> &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
            <img  height="200" width="200" class="img-circle" alt="img" src="data:image/jpeg;base64,${master3.stringImage}"/>
            <h2>${master3.firstName} ${master3.secondName}</h2>
            <p><a class="btn btn-default" href="/authorprofile?id=${master3.id_people}" role="button"><fmt:message key="profile"/> &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
    </div><!-- /.row -->


    <!-- START THE FEATURETTES -->

    <hr class="featurette-divider">

    <div class="row featurette">
        <div class="col-md-7">
            <h2 class="featurette-heading"><fmt:message key="homepagetext11"/> <span class="text-muted"><fmt:message key="homepagetext12"/> </span></h2>
            <p class="lead"><fmt:message key="homepagetext13"/></p>
        </div>
        <div class="col-md-5">
            <img class="featurette-image img-responsive" src="/image/soc.jpg" alt="Generic placeholder image">
        </div>
    </div>

    <hr class="featurette-divider">

    <div class="row featurette">
        <div class="col-md-5">
            <img class="featurette-image img-responsive" src="/image/ez.jpg" alt="Generic placeholder image">
        </div>
        <div class="col-md-7">
            <h2 class="featurette-heading"><fmt:message key="homepagetext21"/> <span class="text-muted"><fmt:message key="homepagetext22"/> </span></h2>
            <p class="lead"><fmt:message key="homepagetext23"/></p>
        </div>
    </div>

    <hr class="featurette-divider">
</div>


    <!-- /END THE FEATURETTES -->