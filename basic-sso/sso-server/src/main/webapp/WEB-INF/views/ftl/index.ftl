<html>
	<head>
		<title>Auth Center</title>
	</head>
	<body>
		<div>
			<form id="login" action="/login" method="post">
				username:<input type="text" name="username" value="admin" />
				password:<input type="password" name="password" value="admin123" />
				<input type="hidden" name="clientUrl" value="${clientUrl!}" />
				<input type="submit" value="Login" />
			</form>
		</div>
	</body>
</html>
