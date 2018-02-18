<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE>

<html lang="eng">
<head>
<meta charset="UTF-8">
<title>New Member</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/mystyle.css" />
<link href="https://fonts.googleapis.com/css?family=Pacifico"
	rel="stylesheet">

</head>
<body>

	<h1>eLibrary</h1>


	<div class="jumbotron" id="customerForm">
		<h2 class="form-header" >Add Member</h2>

		<form:form action="saveMember" modelAttribute="member" method="POST">
			
			<form:hidden path="id"/>
			<input type="hidden" name="page" value="${param.page}"/>
			
			<div class="form-group">
				<form:label path="firstName">First Name</form:label>
				<form:input path="firstName" cssClass="form-control" id="exampleInputName2" placeholder="Jane"/>
				<form:errors path="firstName" cssClass="errors"/>
			</div>
			<div class="form-group">
				<form:label path="lastName">Last Name</form:label>
				<form:input path="lastName" cssClass="form-control" id="exampleInputName2" placeholder="Smith"/>
				<form:errors path="lastName" cssClass="errors"/>
			</div>
			<div class="form-group">
				<form:label path="dateOfBirth">Date of Birth</form:label>
				<form:input path="dateOfBirth" type="date" placeholder="25-01-1995"/>
				<form:errors path="dateOfBirth" cssClass="errors"/>
			</div>
			<div class="form-group">
				<form:label path="adress">Adress</form:label>
				<form:input path="adress" cssClass="form-control" id="exampleInputName2" placeholder="Oak Street 50"/>
				<form:errors path="adress" cssClass="errors"/>
			</div>
			<div class="form-group">
				<form:label path="city">City</form:label>
				<form:input path="city" cssClass="form-control" id="exampleInputName2" placeholder="New York"/>
				<form:errors path="city" cssClass="errors"/>
			</div>
			<div class="form-group">
				<form:label path="phone">Phone</form:label>
				<form:input path="phone" cssClass="form-control" id="exampleInputName2" placeholder="212-509-6995"/>
				<form:errors path="phone" cssClass="errors"/>
			</div>
			<div class="form-group">
				<form:label path="email">Email</form:label>
				<form:input path="email" cssClass="form-control" id="inputEmail2" placeholder="johndoe@gmail.com"/>
				<form:errors path="email" cssClass="errors"/>
			</div>
			<div class="form-group">
				<form:label path="profileImageUrl">Profile Image (url)</form:label>
				<form:input path="profileImageUrl" cssClass="form-control" id="exampleInputName2" placeholder="www.images.com/image1"/>
			</div>

			<button type="submit" class="btn btn-default">Submit</button>
			<a href="<c:url value="homePage"><c:param name="page" value="${param.page}"/></c:url>" ><button type="button" class="btn btn-default btn-onright">Cancel</button></a>
		</form:form>

	</div>

	<!-- Include Copyright footer -->
	<jsp:include page="footer.jsp"/>
	
	<!-- jQuery library -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>