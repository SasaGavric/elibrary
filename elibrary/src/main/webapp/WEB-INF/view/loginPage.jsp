<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html lang="en">
<head>
<title>Login Page - elibrary</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/loginstyle.css" />
<link href="https://fonts.googleapis.com/css?family=Pacifico"
	rel="stylesheet">

</head>
<body>

	<div class="header">
		<h1>eLibrary</h1>
	</div>

	<form:form action="${pageContext.request.contextPath}/processLoginData"
		method="POST">		
		<div class="login-wrap">	
			<div class="login-html">
		
			<c:if test="${param.logout != null}">
				<p class="logout" ><i>You have been logged out</i></p>
			</c:if>
			
			<c:if test="${param.error != null}">
				<p class="bad">
					<i>Sorry! You entered invalid username/password.</i>
				</p>
			</c:if>
				<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label
					for="tab-1" class="tab">Sign In</label> <input id="tab-2"
					type="radio" name="tab" class="sign-up"><label for="tab-2"
					class="tab"></label>

				<div class="login-form">
					<div class="sign-in-htm">
						<div class="group">
							<label for="user" class="label">Username</label> <input
								name="username" id="user" type="text" class="input">
						</div>
						<div class="group">
							<label for="pass" class="label">Password</label> <input
								name="password" id="pass" type="password" class="input"
								data-type="password">
						</div>
						<div class="group">
							<input id="check" type="checkbox" class="check" name="remember-me">
							<label for="check"><span class="icon"></span> Keep me
								Signed in</label>
						</div>
						<div class="group">
							<input type="submit" class="button" value="Sign In">
						</div>
						<div class="hr"></div>
				
					</div>
				</div>
			</div>
		</div>
	</form:form>
</body>
</html>
