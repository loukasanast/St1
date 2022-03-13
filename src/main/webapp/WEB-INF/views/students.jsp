<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
    <html lang="en">
        <head>
            <title>Student Management</title>
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css" />
        </head>
        <body>
            <h2 class="title mt-4 ml-4">Student management</h2>
            <table class="table is-striped is-hoverable ml-4">
                <thead>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Date of Birth</th>
                        <th>GPA</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${students}" var="s">
                        <tr>
                            <td>${s.firstName}</td>
                            <td>${s.lastName}</td>
                            <td><fmt:setLocale value="en_US" scope="session" /><fmt:formatDate value = "${s.dob}" /></td>
                            <td>${s.gpa}</td>
                            <td><a class="button is-light" href="update?id=${s.id}">Update</a></td>
                            <td><a class="button is-warning" href="delete?id=${s.id}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a class="button is-ghost" href="add">Add new student</a>
        </body>
    </html>
