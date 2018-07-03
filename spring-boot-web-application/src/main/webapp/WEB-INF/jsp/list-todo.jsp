<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
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
					<td><a type="button" class="btn btn-danger btn-block"
						href="/delete-todo?id=${list.id}"> DELETE </a></td>
					<td><a type="button" class="btn btn-primary btn-block"
						href="/update-todo?id=${list.id}"> UPDATE </a></td>
				</tr>
			</jstl:forEach>
		</tbody>
	</table>
</div>
<div class="container">
	<a href="/add-todo" class="btn btn-success btn-block"> Add TODO </a>
</div>
<%@ include file="common/footer.jspf"%>