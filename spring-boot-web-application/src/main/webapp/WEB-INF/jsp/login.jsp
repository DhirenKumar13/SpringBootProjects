<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<h1>Welcome ${name} ..</h1>
	<form action="/loginUser" method="post">
		Name : <input type="text" name="name" /> Password : <input
			type="password" name="password" /> <input type="submit" name="Login" />
	</form>
</div>
<%@ include file="common/footer.jspf"%>