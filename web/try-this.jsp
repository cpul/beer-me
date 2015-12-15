
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

</head>
<body style="padding-top: 70px;">
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="navbar-collapse1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">Beer Me!</a>
            </div>
            <div class="collapse navbar-collapse" id="navbar-collapse1">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#">${user.username}</a></li>
                    <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-10 col-md-offset-2">
                        <h2>You Should Try This</h2>
                    </div>
                </div>
                <div class="col-md-3 col-md-offset-2">
                    <c:choose>
                        <c:when test="${not empty beer.imageUrl}">
                            <img class="img-responsive" src="${beer.imageUrl}" style="width:100%;" />
                        </c:when>
                        <c:otherwise>
                            <img src="${pageContext.request.contextPath}/images/placeholder.png" style="width: 100%;">
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="col-md-7">
                    <h3>Product Details</h3>
                    <dl class="dl-horizontal">
                        <dt>Product name</dt>
                        <dd>${beer.name}</dd>
                        <dt>Product size</dt>
                        <c:choose>
                            <c:when test="${beer.totalPackageUnits > 1}">
                                <dd>${beer.totalPackageUnits} x ${beer.packageUnitVolumeInMilliliters} mL ${beer.packageUnitType}</dd>
                            </c:when>
                            <c:otherwise>
                                <dd>${beer.packageUnitVolumeInMilliliters} mL ${beer.packageUnitType}</dd>
                            </c:otherwise>
                        </c:choose>
                        <dt>Alcohol/Vol</dt>
                        <c:set var="alcoholPercentage" value="${beer.alcoholContent / 100}"/>
                        <dd>${alcoholPercentage}%</dd>
                        <dt>Made in</dt>
                        <dd>${beer.origin}</dd>
                        <dt>By</dt>
                        <dd>${beer.producerName}</dd>
                    </dl>
                    <h3>Store Details</h3>
                    <dl class="dl-horizontal">
                        <dt>Price</dt>
                        <c:set var="price" value="${beer.priceInCents/100}"/>
                        <dd><fmt:formatNumber type="currency" value="${price}" /></dd>
                        <c:if test="${beer.hasLimitedTimeOffer}">
                            <dt>Save</dt>
                            <c:set var="savings" value="${beer.limitedTimeOfferSavingsInCents/100}"/>
                            <dd><fmt:formatNumber type="currency" value="${savings}"/></dd>
                            <%--
                            <dt>Until</dt>
                            <dd><fmt:formatDate value="${beer.getLimitedTimeOfferEndsOnAsDate}" type="date" dateStyle="long" /></dd>
                            --%>
                        </c:if>
                        <dt>Quantity</dt>
                        <dd>${quantity}</dd>
                    </dl>
                    <div class="row">
                        <div class="col-md-6">
                            <form action="${pageContext.request.contextPath}/select" method="post">
                                <input type="hidden" name="bid" value="${beer.id}">
                                <input type="submit" class="btn btn-success btn-lg btn-block" value="Sign me up! I'll try it">
                            </form>
                            <p class="text-right"><a role="button" href="${pageContext.request.contextPath}/try-me" class="btn btn-link">What else you got?</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

</body>
</html>
