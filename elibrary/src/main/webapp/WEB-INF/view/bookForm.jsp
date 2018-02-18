<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE>

<html lang="eng">
<head>
<meta charset="UTF-8">
<title>New Book</title>
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

		<h2 class="form-header">Add Book</h2>
		
		<form:form action="saveBook" modelAttribute="book" method="POST">
			
			<form:hidden path="id"/>
			<input type="hidden" name="page" value="${param.page}">
			
			<div class="form-group">
				<form:label path="title">Title</form:label>
				<form:input path="title" cssClass="form-control" id="exampleInputName2" placeholder="The Lord of the Rings"/>
				<form:errors path="title" cssClass="errors"/>
			</div>
			 <div class="form-group form-authors">
				<form:label path="listOfAuthors">Authors (Hold Ctrl for multiple select)</form:label>
				<form:select path="listOfAuthors" multiple="true" size="3" class="form-control authors" items="${listOfAuthors}" itemValue="id"  />
				<a href="<c:url value="authorForm"> <c:param name="page" value="${param.page}"/> </c:url>"><button type="button" class="btn btn-primary author-btn">Add New Author</button></a>
			</div>
			<div class="form-group">
				<form:label path="dateOfIssue">Publication Date</form:label>
				<form:input path="dateOfIssue" type="date" placeholder="25-01-1995"/>
				<form:errors path="dateOfIssue" cssClass="errors"/>
			</div>
			<div class="form-group">
				<form:label path="numberOfPages">Number of Pages</form:label>
				<form:input path="numberOfPages" cssClass="form-control" id="exampleInputName2" placeholder="625"/>
				<form:errors path="numberOfPages" cssClass="errors"/>
			</div>
			<div class="form-group">
				<form:label path="language">Language</form:label>
				<form:input path="language" cssClass="form-control" id="exampleInputName2" placeholder="English"/>
				<form:errors path="language" cssClass="errors"/>
			</div>
			<div class="form-group">
				<form:label path="coverImageUrl">Cover Image: </form:label>
				<form:input type="" path="coverImageUrl" cssClass="form-control" id="exampleInputName2" placeholder="www.images.com/image1"/>
				<form:errors path="coverImageUrl" cssClass="errors"/>
			</div>
			<div class="form-group">
				<form:label path="description">Summary</form:label>
				<form:textarea path="description" class="form-control txtarea" rows="8"/>
				<form:errors path="description" cssClass="errors"/>		
			</div>
			<div class="form-group">
				<form:label path="booksInStock">Books in stock: </form:label>
				<form:input path="booksInStock" cssClass="form-control" id="exampleInputName2" placeholder="15"/>
				<form:errors path="booksInStock" cssClass="errors"/>
			</div>
			

			<button type="submit" class="btn btn-default">Submit</button>
			<a href="<c:url value="bookList"><c:param name="page" value="${param.page}"/></c:url>" ><button type="button" class="btn btn-default btn-onright">Cancel</button></a>
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