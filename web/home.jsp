
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/lcbo.css">
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
                <a class="navbar-brand" href="index.jsp">Beer Me!</a>
            </div>
            <div class="collapse navbar-collapse" id="navbar-collapse1">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#">${user.username}</a></li>
                    <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container">
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <h2>Beer Me!</h2>
                <p class="lead">Welcome to the site which suggests great beers for you to try.
                    <br>Feeling thirsty? Feeling adventurous? Click the button below!</p>

                <c:if test="${empty triedBeers}">
                    <h4>You have yet to try any beers! May we suggest one for you?</h4>
                </c:if>
                <c:if test="${not empty triedBeers}">
                    <h4>Looks like you're ready for another! You know what to click...</h4>
                </c:if>

                <c:choose>
                    <c:when test="${not empty homeStore}">
                        <p>Your current store is %STORE%. Would you like to <a role="button" href="#" data-toggle="modal" data-target="#store-select-dialog">change your store?</a></p>
                    </c:when>
                    <c:otherwise>
                        <p>Your currently don't have a store set. Please <a role="button" href="#" data-toggle="modal" data-target="#store-select-dialog">select your store.</a></p>
                    </c:otherwise>
                </c:choose>

            </div>
        </div>
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <p class="text-center">
                    <a class="btn btn-primary btn-lg btn-block" href="${pageContext.request.contextPath}/try-me" role="button">Beer Me!</a>
                </p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <h3>Your Latest Beers That You Tried</h3>
                <div class="row">
                    <c:choose>
                        <c:when test="${not empty latestTriedBeers}">
                            <c:set var="latestBeersCounter" value="0" scope="page"/>
                            <ol>
                                <c:forEach var="b" items="${latestTriedBeers}">
                                    <c:if test="${latestBeersCounter < 10}">
                                        <li>${b.beerName} - ${b.triedOn}</li>
                                    </c:if>
                                    <c:set var="latestBeersCounter" value="${latestBeersCounter + 1}" scope="page"/>
                                </c:forEach>
                            </ol>
                        </c:when>
                        <c:otherwise>
                            <p>Looks like you haven't tried any yet. What are you waiting for?</p>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <hr>
            </div>
        </div>
        <div class="row">
            <div class="col-md-8 col-md-offset-2 beers-listing">
                <h3>Your Wall of Beers</h3>
                <div class="row">
                    <c:choose>
                        <c:when test="${empty triedBeers}">
                            <div class="col-sm-12 col-md-12">
                                <h4>When you try a beer, it will show up here.</h4>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <c:forEach var="beer" items="${triedBeers}">
                                <div class="col-sm-6 col-md-4">
                                    <div class="thumbnail">
                                        <c:choose>
                                            <c:when test="${empty beer.imageUrl}">
                                                <img src="images/placeholder.png" alt="${beer.name}" style="width:100%;">
                                            </c:when>
                                            <c:otherwise>
                                                <img src="${beer.imageUrl}" alt="${beer.name}">
                                            </c:otherwise>
                                        </c:choose>
                                        <div class="caption">
                                            <h4><c:out value="${beer.name}"/></h4>
                                            <p><c:out value="${beer.packageDescription}"/></p>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>

    <div id="store-select-dialog" class="modal fade" tabindex="-1" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">Select Your LCBO Retail Store</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-sm-12">
                            <h5>Search for Nearby Stores</h5>
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Yonge & Queen">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button">Find stores</button>
                                </span>
                            </div>
                        </div>
                    </div>
                    <!-- Store results -->
                    <hr>
                    <div class="row">
                        <div class="col-sm-12 col-md-12">
                            <h5>Store Results</h5>
                            <div class="list-group">
                                <a class="list-group-item" href="#" id="STORE_ID">
                                    <h4 class="list-group-item-heading">LCBO Yonge & Queen</h4>
                                    <p class="list-group-item-text">Yonge St. and Queen St.</p>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>

    <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>


</body>
</html>
