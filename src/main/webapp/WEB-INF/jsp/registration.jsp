<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="ISO-8859-1">
    <title>REGISTRATION</title>
    <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <script type="text/javascript" src="/webjars/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container text-center">
    <div>
        <h1>Client registration page</h1>
    </div>
    <form:form action="/process_register" modelAttribute="client" id="client"
          method="post" style="max-width: 600px; margin: 0 auto;">
        <div class="m-3">
            <div class="form-group row">
                <label class="col-4 col-form-label">Login: </label>
                <div class="col-8">
                    <form:input type="email" path="email" class="form-control" required = "required"/>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-4 col-form-label">Password: </label>
                <div class="col-8">
                    <form:input  type="password" path="password" class="form-control"
                                minlength ="6" maxlength="10" required = "required"   />
                </div>
            </div>

            <div class="form-group row">
                <label class="col-4 col-form-label">First Name: </label>
                <div class="col-8">
                    <form:input type="text" path="firstName" class="form-control"
                                minlength ="2" maxlength="20" required = "required"/>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-4 col-form-label">Last Name: </label>
                <div class="col-8">
                    <form:input type="text" path="lastName" class="form-control"
                           minlength ="2" maxlength="20" required = "required" />
                </div>
            </div>

            <div>
                <button type="submit" class="btn btn-primary"> Registration </button>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>