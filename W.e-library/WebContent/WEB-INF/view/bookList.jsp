<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE>

<html lang="eng">
<head>
<meta charset="UTF-8">
<title>eLibrary-Members</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mystyle.css" />
<link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet">
</head>
<body>

	<h1>eLibrary</h1>
	
	
	<div class="jumbotron">
	
	<div class="control-panel">
	<ul class="nav nav-pills nav-justified">
 		<li role="presentation" ><a href="${pageContext.request.contextPath}/member/homePage">Members</a></li>
  		<li role="presentation" class="active"><a href="<c:url value="bookList"></c:url>">Books</a></li>
	</ul>
	</div>
	
	<hr>
	
	<a href="<c:url value="bookForm" ></c:url>" ><button type="button" class="btn btn-default navbar-btn">Add New Book</button></a>
	
	<form class="form-inline" action="bookSearch" method="POST">
  		<div class="form-group">
    		<label for="exampleInputName2">Search for Book:</label>   		
   			 <input type="text" name="name" class="form-control" id="exampleInputName2"  placeholder="The Lord of the Rings" required="required">
 		</div>
  		<button type="submit" class="btn btn-default">Search</button>
	</form>

	<div class="table-responsive">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Id</th>
				<th>Title</th>
				<th>Author</th>
				<th>Publication date</th>
				<th>Language</th>	
				<th>Action</th>	
			</tr>		
		</thead>
		
		<tbody>		
			<c:forEach var="book" items="${books}">
				<tr>
					<td>${book.id}</td>
					<td class="max-field" >${book.title}</td>
					<td>
						<c:if test="${not empty book.listOfAuthors}">
							${book.listOfAuthors.get(0).firstName} ${book.listOfAuthors.get(0).lastName}
						</c:if>				
					</td>
					<td><fmt:formatDate value="${book.dateOfIssue}" pattern="dd-MM-yyyy" /></td>
					<td>${book.language}</td>
					
					<c:url var="viewBook" value="viewBook">
						<c:param name="id" value="${book.id}"></c:param>
					</c:url>
					<c:url var="deleteBook" value="deleteBook">
						<c:param name="id" value="${book.id}"></c:param>
					</c:url>
					
					<td class="buttons-row">
					<a href="${viewBook}" ><button type="button" class="btn btn-primary btn-xs">View</button></a> | 
					<a href="${updateBook}" ><button type="button" class="btn btn-success btn-xs">Update</button></a> | 
					<a href="${deleteBook}" onclick="if(!(confirm('Are you sure you want to delete this book?'))) return false"><button type="button" class="btn btn-danger btn-xs">Delete</button></a> 			
					</td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>
		
		<c:set var="backB" value="${backButton}" />
		<c:if test="${backB}">
			<a href="<c:url value="bookList"></c:url>" ><button type="button" class="btn btn-default btn-onleft">Back</button></a>
		</c:if>
	
	</div>
	</div>
	

	<!-- Include Copyright footer -->
	<jsp:include page="footer.jsp"/>
	
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>