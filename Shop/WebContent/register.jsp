<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">

	$(document).ready(function () {
	    var x_timer;
	    $('#password').keyup(function (e) {
	        clearTimeout(x_timer);
	        var password = $('#password').val();
	        x_timer = setTimeout(function () {
	        	check_pass_ajax(password);
	        }, 1000);
	    });
	    
	    function check_pass_ajax(password) {
	        $("#pass-result").html('<img src="img/ajax-loader.gif" />');
	        $.post('CheckPassServlet', {'password': password}, function (data) {
	            $("#pass-result").html(data);
	        });
	    }
	    
	    
	});
    $(document).ready(function () {
        var x_timer;
        $("#email").keyup(function (e) {
            clearTimeout(x_timer);
            var user_name = $('#email').val();
            var password = $('#password').val();
            x_timer = setTimeout(function () {
                check_username_ajax(user_name);
            }, 1000);
        });

        function check_username_ajax(username) {
            $("#user-result").html('<img src="img/ajax-loader.gif" />');
            $.post('CheckEmailServlet', {'username': username}, function (data) {
                $("#user-result").html(data);
            });
        }
 
    });
    
 

</script>
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
						<input type="text" name="username">
					</div> 	
					<div> 	
						<span class="word">PhoneNb*</span>
						<input type="text" name="phone"> 
					</div>			
					<div> 	
						<span class="mail">Email*</span>
						<input type="text" name="email" id="email">
						<span id="user-result"></span>
					</div>
					<div> 
						<span class="word">Password*</span>
						<input type="password" name="password" id="password">
						<span id="pass-result"></span>
					</div>				
						<input type="hidden" value="Insert" name="command">
						<input type="submit" value="Register"> 
					</form>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>