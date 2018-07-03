<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<h1>${name} Here you can add a TODO ...</h1>
	<hr>
	<spring:form method="post" modelAttribute="todo">
		<spring:hidden path="id" />
		<fieldset class="form-group">
			<spring:label path="desc">Description Goes Here</spring:label>
			<spring:input path="desc" type="text" class="form-control"
				required="required" />
			<spring:errors path="desc" cssClass="text-warning"></spring:errors>
		</fieldset>
		<fieldset class="form-group">
			<spring:label path="targetDate">Target Completion Date</spring:label>
			<spring:input path="targetDate" type="text" class="form-control"
				required="required" />
			<spring:errors path="targetDate" cssClass="text-warning"></spring:errors>
		</fieldset>
		<Button type="submit" class="btn btn-success btn-block">ADD</Button>
	</spring:form>
	<hr>
</div>
<%@ include file="common/footer.jspf"%>