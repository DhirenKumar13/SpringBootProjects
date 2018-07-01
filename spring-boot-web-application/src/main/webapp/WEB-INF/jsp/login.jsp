<html>
	<head>
		<title>My Login Page</title>
	</head>
	<body>
		<h1> Welcome ${name}  .. </h1>
		<form action="/loginUser" method="post">
			Name : <input type="text" name="name"/>
			Password : <input type="password" name="password"/>
			<input type="submit" name="Login"/> 
		</form>
	</body>
</html>