<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<html>
<head>
<title>My Login Page</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<h1>${name}Hereyou can add a TODO ...</h1>
		<hr>
		<spring:form method="post" modelAttribute="todo">
			<spring:hidden path="id" />
			<fieldset class="form-group">
				<spring:label path="desc">Description Goes Here</spring:label>
				<spring:input path="desc" type="text" class="form-control"
					required="required" />
				<spring:errors path="desc" cssClass="text-warning"></spring:errors>
			</fieldset>
			<Button type="submit" class="btn btn-success btn-block">ADD
			</Button>
		</spring:form>
		<hr>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>