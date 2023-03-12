<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <link href="webjars\bootstrap\5.1.3\css\bootstrap.min.css" rel="stylesheet"/>
        <link href="webjars\bootstrap-datepicker\1.9.0\css\bootstrap-datepicker.standalone.min.css" rel="stylesheet"/>
        <title>Add Todo Page</title>
    </head>
    <body>
        <div class="container">
            <h1> Enter Todo Details  </h1>
            <form:form method="post" modelAttribute="todo">
                <fieldset class="mb-3">
                    <form:label path="description" cssClass="col-sm-2 col-form-label">Description</form:label>
                    <form:input type="text" path="description" required="required"/>
                    <form:errors path="description" cssClass="text-warnings"/>
                </fieldset>

                <fieldset class="mb-3">
                    <form:label path="targetDate" cssClass="col-sm-2 col-form-label">Target Date</form:label>
                    <form:input type="text" path="targetDate" required="required"/>
                    <form:errors path="targetDate" cssClass="text-warnings"/>
                </fieldset>

                 <form:input type="hidden" path="id"/>
                 <form:input type="hidden" path="done"/>
                 <input type="submit" value="Submit" class="btn btn-success"/>
            </form:form>
            </table>
        </div>
        <script source="webjars\bootstrap\5.1.3\js\bootstrap.min.js"></script>
        <script source="webjars\jquery\3.6.0\jquery.min.js"></script>
        <script source="webjars\bootstrap-datepicker\1.9.0\css\bootstrap-datepicker.standalone.min.js"></script>
        <script type="text/javascript">
        	$('#targetDate').datepicker({
        	    format: 'yyyy-mm-dd'
        	});
        </script>
    </body>
</html>