<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>Register - SB Admin</title>
    <link href="/resources/css/styles.css" rel="stylesheet"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
            crossorigin="anonymous"></script>
</head>
<body class="bg-primary">
<div id="layoutAuthentication">
    <div id="layoutAuthentication_content">
        <main>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-4">
                        <div class="card shadow-lg border-0 rounded-lg mt-5">
                            <div class="card-header"><h3 class="text-center font-weight-light my-4">Create Account</h3>
                            </div>
                            <div class="card-body">
                                <form:form metod="post" modelAttribute="user" class="user">
                                    <div class="row mb-3">
                                        <div class="col-md-6">
                                            <div class="form-floating mb-3 mb-md-0">
                                                <form:input path="username" type="text"
                                                            class="form-control form-control-user" id="exampleFirstName"
                                                            placeholder="Username"/>
                                                <label for="exampleFirstName">Username</label>
                                                <div style="color: red"><form:errors path="username"/> </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-md-6">
                                            <div class="form-floating mb-3 mb-md-0">
                                                <form:input type="password" path="password"
                                                            class="form-control form-control-user"
                                                            id="Password" placeholder="Password"/>
                                                <label for="Password">Password</label>
                                                <div style="color: red"><form:errors path="password"/></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-floating">
                                            <div class="form-floating mb-3 mb-md-0">
                                                <input class="form-control" id="inputPasswordConfirm"
                                                       type="password" placeholder="Confirm password" name="confirm"/>
                                                <label for="inputPasswordConfirm">Confirm Password</label>
                                                <div style="color: red">${confirmerror}</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div><br></div>
                                    <div class="col-md-6">
                                        <div class="form-floating">
                                            <div class="form-floating mb-3">
                                                <form:input path="email" type="text"
                                                            class="form-control form-control-user"
                                                            id="inputEmail"
                                                            placeholder="Email"/>
                                                <label for="inputEmail">Email address</label>
                                                <div style="color: red"><form:errors path="email"/></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-md-6">
                                            <div class="form-floating mb-3">
                                                <form:input path="firstName" type="text"
                                                            class="form-control form-control-user" id="inputEmail"
                                                            placeholder="First name"/>
                                                <label for="inputEmail">First Name</label>
                                                <div style="color: red"><form:errors path="firstName"/></div>

                                            </div>
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-md-6">
                                            <div class="form-floating mb-3">
                                                <form:input path="lastName" type="text"
                                                            class="form-control form-control-user" id="inputEmail"
                                                            placeholder="Last name"/>
                                                <label for="inputEmail">Last Name</label>
                                                <div style="color: red"><form:errors path="lastName"/></div>

                                            </div>
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-md-6">
                                            <div class="form-floating mb-3">
                                                <form:input path="age" type="number" step="1"
                                                            class="form-control form-control-user" id="inputEmail"
                                                            placeholder="Age"/>
                                                <label for="inputEmail">Age</label>
                                                <div style="color: red"><form:errors path="age"/></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="mt-4 mb-0">
                                        <input type="submit" value="Create account"
                                               class="btn btn-primary btn-user btn-block">
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </div>
                    <div class="card-footer text-center py-3">
                        <div class="small"><a href="${pageContext.request.contextPath}/login">Have an account?
                            Go to login</a></div>
                    </div>
                </div>
            </div>
    </div>
    </main>
</div>
<div id="layoutAuthentication_footer">
    <footer class="py-4 bg-light mt-auto">
        <div class="container-fluid px-4">
            <div class="d-flex align-items-center justify-content-between small">
                <div class="text-muted">Copyright &copy; Your Website 2021</div>
                <div>
                    <a href="#">Privacy Policy</a>
                    &middot;
                    <a href="#">Terms &amp; Conditions</a>
                </div>
            </div>
        </div>
    </footer>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
<script src="/resources/js/scripts.js"></script>
</body>
</html>