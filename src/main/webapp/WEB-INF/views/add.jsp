<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
    <html lang="en">
        <head>
            <title>Student Management</title>
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css" />
        </head>
        <body>
            <h2 class="title mt-4 ml-4">Add new student</h2>
            <form:form action="addpost" modelAttribute="student">
                <table class="table ml-4">
                    <tr>
                        <td>First Name:</td>
                        <td>
                            <form:input path="firstName" cssClass="input is-primary" />
                        </td>
                        <td>
                            <form:errors path="firstName" cssClass="has-text-danger" />
                        </td>
                    </tr>
                    <tr>
                        <td>Last Name:</td>
                        <td>
                            <form:input path="lastName" cssClass="input is-primary" />
                        </td>
                        <td>
                            <form:errors path="lastName" cssClass="has-text-danger" />
                        </td>
                    </tr>
                    <tr>
                        <td>Date of Birth:</td>
                        <td>
                            <form:input path="dob" type="date" cssClass="input is-primary" />
                        </td>
                        <td>
                            <form:errors path="dob" cssClass="has-text-danger" />
                        </td>
                    </tr>
                    <tr>
                        <td>GPA:</td>
                        <td>
                            <form:input path="gpa" type="number" step="0.1" cssClass="input is-primary" />
                        </td>
                        <td>
                            <form:errors path="gpa" cssClass="has-text-danger" />
                        </td>
                    </tr>
                </table>
                <button class="button is-light ml-4" type="submit">Add</button>
            </form:form>
            <a class="button is-ghost" href="./">Back to home...</a>
        </body>
    </html>
