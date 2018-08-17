<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE>

<html lang="eng">
<head>
<meta charset="UTF-8"/>
<title>Member-${member.firstName} ${member.lastName} - elibrary</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/mystyle.css" />
<link href="https://fonts.googleapis.com/css?family=Pacifico"
	rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" >

</head>
<body>

	<h1>eLibrary</h1>
	
	<div class="jumbotron" id="customerForm">

	
		<h2 class="name-title">${member.firstName} ${member.lastName}</h2>
		
		
		<!-- Does book have image or not--> 
		<c:choose >
			<c:when test="${empty member.profileImageUrl}">
					<img src="${pageContext.request.contextPath}/resources/image/unknown-user.png" alt="..." class="img-circle cover">
			</c:when>
			<c:otherwise>
					<img src="${member.profileImageUrl}" alt="..." class="img-circle cover">
			</c:otherwise>	
		</c:choose>
		
		
		<table class="table">
		<tbody>
			<tr>
				<td> <i class="fa fa-id-card-o fa-2x" aria-hidden="true"></i> ${member.id}</td>
			</tr>
			<tr>
				<td> <i class="fa fa-birthday-cake fa-2x" aria-hidden="true"></i> <fmt:formatDate value="${member.dateOfBirth}" pattern="dd-MM-yyyy" /> </td>
			</tr>
			<tr>
				<td><i class="fa fa-map-marker fa-2x" aria-hidden="true"></i> ${member.adress} - ${member.city}</td>
			</tr>
			<tr>
				<td> <i class="fa fa-phone fa-2x" aria-hidden="true"></i>${member.phone}</td>
			</tr>
			<tr>
				<td> <i class="fa fa-envelope fa-2x" aria-hidden="true"></i>${member.email}</td>
			</tr>
		</tbody>
 
		</table>
		
		<a href="<c:url value="homePage"><c:param name="page" value="${param.page}"/></c:url>"><button type="button" class="btn btn-default btn-onright">Back</button></a>
		<br><br>
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