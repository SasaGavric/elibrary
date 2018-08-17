<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE>

<html lang="eng">
<head>
<meta charset="UTF-8">
<title>Book-${book.title} - elibrary</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mystyle.css" />
<link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet">
</head>
<body>

	<h1>eLibrary</h1>
	
	
	<div class="jumbotron overview-panel">
		<h2 class="name-title">${title}</h2>
		<hr>
		
		<br>
		<p>${description}</p>
	
		<hr>
		
		<c:url var="backToviewBook" value="viewBook">
			<c:param name="id" value="${id}"></c:param>
		</c:url>
		<a href="<c:url value="${backToviewBook}"><c:param name="page" value="${param.page}"/></c:url>"><button type="button" class="btn btn-default btn-onleft">Back</button></a>
		
		<br><br>
	</div>
	

	<!-- Include Copyright footer -->
	<jsp:include page="footer.jsp"/>
	
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>