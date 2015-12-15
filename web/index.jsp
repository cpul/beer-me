
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <li><a href="${pageContext.request.contextPath}/login.jsp">Login</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container">
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <h2>Beer Me!</h2>
                <p class="lead">Welcome to the site which suggests great beers for you to try.
                    <br>Feeling thirsty? Feeling adventurous? Log in or register below!</p>
                <p><a role="button" href="${pageContext.request.contextPath}/login.jsp" class="btn btn-primary btn-large">I'm back! Log me in</a>
                    <a role="button" href="${pageContext.request.contextPath}/register.jsp" class="btn btn-link btn-large">I'm new! Sign me up</a></p>
            </div>

        </div>
    </div>
</body>
</html>
