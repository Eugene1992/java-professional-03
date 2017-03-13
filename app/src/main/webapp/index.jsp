<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">
                    Employees CRUD
                </h3>
            </div>
            <br>
            <form class="form-horizontal" action="/employees" method="post">
                <input type="hidden" name="id" value="${updEmployee.id}"/>

                <div class="form-group">
                    <label class="control-label col-sm-4" for="firstname">First name: </label>
                    <div class="col-sm-5">
                        <input class="form-control" id="firstname" type="text" name="firstname" value="${updEmployee.firstName}" required/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-4" for="lastname">Last name: </label>
                    <div class="col-sm-5">
                        <input class="form-control" id="lastname" type="text" name="lastname" value="${updEmployee.lastName}" required/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-4" for="hiredate">Hiredate: </label>
                    <div class="col-sm-5">
                        <input class="form-control" id="hiredate" type="date" name="hiredate" value="${updEmployee.hiredate}" required/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-4" for="age">Age: </label>
                    <div class="col-sm-5">
                        <input class="form-control" id="age" type="number" name="age" value="${updEmployee.age}" required/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-4" for="salary">Salary: </label>
                    <div class="col-sm-5">
                        <input class="form-control" id="salary" type="number" name="salary" value="${updEmployee.salary}" required/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-4 col-sm-10">
                        <c:choose>
                            <c:when test="${param.action == null}">
                                <button type="submit" class="btn btn-success">Add employee</button>
                            </c:when>
                            <c:when test="${param.action == 'update'}">
                                <button type="submit" class="btn btn-info">Update</button>
                                <button type="submit" class="btn btn-warning" onclick="window.history.back()">Cancel</button>
                            </c:when>
                        </c:choose>

                    </div>
                </div>
            </form>
            <br>
            <table class="table table-bordered table-hover">
                <tr>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Age</th>
                    <th>Salary</th>
                    <th>Hire date</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
                <c:forEach var="employee" items="${employees}">
                    <tr>
                        <td>${employee.firstName}</td>
                        <td>${employee.lastName}</td>
                        <td>${employee.age}</td>
                        <td>${employee.salary}</td>
                        <td>${employee.hiredate}</td>
                        <td><a href="/employees?action=update&id=${employee.id}"><button type="submit" class="btn btn-info btn-xs">Update</button></a></td>
                        <td><a href="/employees?action=delete&id=${employee.id}"><button type="submit" class="btn btn-danger btn-xs">Delete</button></a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
