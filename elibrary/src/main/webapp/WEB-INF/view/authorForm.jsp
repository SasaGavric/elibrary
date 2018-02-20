<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>

<html lang="eng" >

<head>
<meta charset="UTF-8" >
<title>New Author - elibrary</title>

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
	<h2 class="form-header">Add Author</h2>
	
	<form:form action="saveAuthor" modelAttribute="author" method="POST">
	
	<input type="hidden" name="page" value="${param.page}">
	
	<div class="form-group">
		<form:label path="firstName">First Name</form:label>
		<form:input path="firstName" cssClass="form-control" id="exampleInputName2" placeholder="Jane"/>
		<form:errors path="firstName" cssClass="errors"/>
	</div>
	<div class="form-group">
		<form:label path="lastName">Last Name</form:label>
		<form:input path="lastName" cssClass="form-control" id="exampleInputName2" placeholder="Jane"/>
		<form:errors path="lastName" cssClass="errors"/>
	</div>
	<div class="form-group">
		<form:label path="description">Biography</form:label>
		<form:textarea path="description" rows="8"  class="form-control txtarea"/> 
	</div>
		
		<input type="submit" value="Submit" class="btn btn-default"/>
		<a href="<c:url value="bookForm"> <c:param name="page" value="${param.page}"/> </c:url>" ><button type="button" class="btn btn-default btn-onright">Cancel</button></a>
	
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
