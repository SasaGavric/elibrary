<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
 		<li role="presentation" class="active"><a href="<c:url value="homePage"></c:url>">Members</a></li>
  		<li role="presentation"><a href="${pageContext.request.contextPath}/book/bookList">Books</a></li>
	</ul>
	</div>
	
	<hr>
	
	<a href="<c:url value="memberForm" ></c:url>" ><button type="button" class="btn btn-default navbar-btn">Add New Customer</button></a>
	
	<form class="form-inline" action="memberSearch" method="POST">
  		<div class="form-group">
    		<label for="exampleInputName2">Search Member:</label>   		
   			 <input type="text" name="memberName" class="form-control" id="exampleInputName2"  placeholder="Jane Doe" required="required">
 		</div>
  		<button type="submit" class="btn btn-default">Search</button>
	</form>

	<div class="table-responsive">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Phone</th>
				<th>Email</th>
				<th>Action</th>			
			</tr>		
		</thead>
		
		<tbody>		
			<c:forEach var="member" items="${members}">
				<tr>
					<td>${member.id}</td>
					<td>${member.firstName}</td>
					<td>${member.lastName}</td>
					<td>${member.phone}</td>
					<td>${member.email}</td>
					
					<c:url var="viewMember" value="viewMember">
						<c:param name="id" value="${member.id}"></c:param>
					</c:url>
					<c:url var="updateMember" value="updateMember">
						<c:param name="id" value="${member.id}"></c:param>
					</c:url>
					<c:url var="deleteMember" value="deleteMember">
						<c:param name="id" value="${member.id}"></c:param>
					</c:url>
					
					<td class="buttons-row">
					<a href="${viewMember}" ><button type="button" class="btn btn-primary btn-xs">View</button></a> | 
					<a href="${updateMember}" ><button type="button" class="btn btn-success btn-xs">Update</button></a> | 
					<a href="${deleteMember}" onclick="if(!(confirm('Are you sure you want to delete this member?'))) return false"><button type="button" class="btn btn-danger btn-xs">Delete</button></a> 			
					</td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>
		
		<c:set var="backButton" value="${backButton}" />
		<c:if test="${backButton == true }">
			<a href="<c:url value="homePage"></c:url>" ><button type="button" class="btn btn-default btn-onleft">Back</button></a>
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