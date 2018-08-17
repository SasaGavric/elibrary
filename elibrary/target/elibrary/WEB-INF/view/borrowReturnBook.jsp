<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


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

	<div class="jumbotron" id="borrowReturn">
			<h2 class="name-title">${member.id} - ${member.firstName} ${member.lastName}</h2>
			<br>
	
		<!-- Borrow one book -->
		<h3><span>Borrow</span></h3>
		<c:if test="${member.borrowedBooks.size() < 2}">
		<form:form action="borrowBook" modelAttribute="borrowedBook" method="POST">
			<input type="hidden" name="page" value="${param.page}">
			<input type="hidden" name="memberId" value="${member.id}">
			
			<form:select path="borrowedBook" class="form-control select-book">
				<form:options items="${availableBooks}" itemValue="id" itemLabel="title" />							
			</form:select>
			
			<input type="submit" value="Borrow" class="btn btn-success" >		
		
		</form:form>
		</c:if>
		<c:if test="${member.borrowedBooks.size() >= 2}">
			<p>The member has already borrowed 2 books!</p>
		</c:if>
		<!-- Return one book -->
		<h3><span>Return</span></h3>
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Title</th>
						<th>Date of Borrowing</th>	
						<th>Action</th>	
					</tr>		
				</thead>
		
				<tbody>		
					<c:forEach var="borrowedBooks" items="${member.borrowedBooks}" >
						<tr>
							<td>${borrowedBooks.borrowedBook.title}</td>
							<td><fmt:formatDate value="${borrowedBooks.dateOfBorrowing}" pattern="dd-MM-yyyy" /></td>
							
							<c:url var="returnBook" value="returnBook">
							<c:param name="id" value="${borrowedBooks.id}"/>
							<c:param name="memberId" value="${member.id}"/>
							<c:param name="bookId" value="${borrowedBooks.borrowedBook.id}"/>
							<c:param name="page" value="${param.page}"/>
							</c:url>
							
							<td><a href="${returnBook}" ><button type="button" class="btn btn-danger">Return</button></a> </td>
						</tr>						
					</c:forEach>
				
				</tbody>
			</table>
		</div>
		<br>
			<a href="<c:url value="chooseMemberId">  <c:param name="page" value="${param.page}"/> </c:url> " ><button type="button" class="btn btn-default btn-onleft">Back</button></a>
	
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