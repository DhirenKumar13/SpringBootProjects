<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<html>
<head>
<title>My Login Page</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="well">
			<h1>Here is your list of Todo's ${name} ..</h1>
		</div>
		<table class="table table-striped table-bordered">
			<caption>Here are your list of todo's</caption>
			<thead>
				<tr>
					<th>Description</th>
					<th>Target Completion Date</th>
					<th>Is it DONE ?</th>
					<th>Want to Delete</th>
					<th>Want to Update</th>
				</tr>
			</thead>
			<tbody>
				<jstl:forEach items="${list}" var="list">
					<tr>
						<td>${list.desc}</td>
						<td>${list.targetDate}</td>
						<td>${list.done}</td>
						<td>
							<a type="button" class="btn btn-danger btn-block" href="/delete-todo?id=${list.id}">
							 DELETE 
							</a>
						</td>
						<td>
							<a type="button" class="btn btn-primary btn-block" href="/update-todo?id=${list.id}">
							 UPDATE 
							</a>
						</td>
					</tr>
				</jstl:forEach>
			</tbody>
		</table>
	</div>
	<div class="container">
		<a href="/add-todo" class="btn btn-success btn-block"> Add TODO </a>
	</div>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>