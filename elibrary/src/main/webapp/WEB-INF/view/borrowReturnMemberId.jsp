<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE>

<html lang="eng">
<head>
<meta charset="UTF-8" />
<title>Borrow &amp; Return - elibrary</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/mystyle.css" />
<link href="https://fonts.googleapis.com/css?family=Pacifico"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>

	<h1>eLibrary</h1>

	<div class="jumbotron" id="customerForm">

		<h2 class="name-title">Borrow &amp; Return</h2>
		<hr>

		<form:form action="borrowReturnBook" method="GET">
		
		<input type="hidden" name="page" value="${param.page}">
		
		
			<select name="memberId" class="form-control select-book">
					<option disabled>Select member</option>
					
					<c:forEach var="member" items="${members}" >
						<option value="${member.id}" >${member.id} - (${member.firstName} ${member.lastName})</option>
					</c:forEach>
					
			</select>
			<br>

			
		<a href="<c:url value="/member/homePage"> <c:param name="page" value="${param.page}"/> </c:url>" ><button type="button" class="btn btn-default btn-onleft">Cancel</button></a>
		<input type="submit" value="Submit" class="btn btn-default btn-onright"/>

		</form:form>

	</div>

	<!-- Include Copyright footer -->
	<jsp:include page="footer.jsp" />

	<!-- jQuery library -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>