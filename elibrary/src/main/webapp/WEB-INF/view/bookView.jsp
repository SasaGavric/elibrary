<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE>

<html lang="eng">
<head>
<meta charset="UTF-8"/>
<title>Book-${book.title} - elibrary</title>
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

	
		<h2 class="name-title">${book.title}</h2>
		
		<!-- Does book have image or not--> 
		<c:choose >
			<c:when test="${empty book.coverImageUrl }">
					<img src="${pageContext.request.contextPath}/resources/image/unknown-book.jpg" alt="..." class="img-rounded cover">
			</c:when>
			<c:otherwise>
					<img src="${book.coverImageUrl}" alt="..." class="img-rounded cover" id="book-image">
			</c:otherwise>	
		</c:choose>
		
		<!--Go to book overview-->
		<c:url var="overviewBook" value="bookOverview">
			<c:param name="bookId" value="${book.id}"></c:param>
			<c:param name="page" value="${param.page}"></c:param>
		</c:url>
		<h4 class="overview"><a href="${overviewBook}">Summary</a></h4>
		
		
		
		<table class="table">
		<tbody>
			<tr>
				<td> <i class="fa fa-id-card-o fa-2x" aria-hidden="true"></i> ${book.id}</td>
			</tr>
			<tr>
				<td><i class="fa fa-calendar fa-2x" aria-hidden="true"></i> <fmt:formatDate value="${book.dateOfIssue}" pattern="dd-MM-yyyy" /></td>
			</tr>
			<tr>
				<td> <i class="fa fa-user fa-2x" aria-hidden="true"></i>
					<ol class="ordered-list">
					<c:forEach var="author" items="${book.listOfAuthors }">											
							<li>${author.firstName} ${author.lastName}</li>						
					</c:forEach>
					</ol>
				</td>
			</tr>
			<tr>
				<td> <i class="fa fa-file-text fa-2x" aria-hidden="true"></i>${book.numberOfPages} pages</td>
			</tr>
			<tr>
				<td> <i class="fa fa-globe fa-2x" aria-hidden="true"></i>${book.language}</td>
			</tr>
			<tr>
				<td> <i class="fa fa-book fa-2x" aria-hidden="true"></i> ${book.booksInStock}</td>
			</tr>
		</tbody>
 
		</table>
		
		
		<a href="<c:url value="bookList"> <c:param name="page" value="${param.page}"/> </c:url>"><button type="button" class="btn btn-default btn-onright">Back</button></a>
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