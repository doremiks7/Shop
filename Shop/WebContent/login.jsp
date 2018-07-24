<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login</title>
</head>
	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<jsp:include page="banner.jsp"></jsp:include>
		<div class="container">
			<div class="account">
				<h2 class="account-in">Login</h2>
					<form action="UserServlet" method="post">
					<div>
						<span>Username*</span>
						<input type="text">
					</div> 	
					<div> 
						<span class="word">Password*</span>
						<input type="password">
					</div>				
						<input type="submit" value="Login"> 
					</form>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>