<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@
	taglib prefix="form" uri="http://www.springframework.org/tags/form" %><%@
	taglib prefix="spring" uri="http://www.springframework.org/tags"
%>
<%@	taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8" />
		<title>RecipeMe</title>
		<link rel="stylesheet" href="<c:url value='/styles/site.css'/>">
		<link rel="stylesheet" href="<c:url value='/styles/bootstrap.min.css'/>">
		<link rel="stylesheet" href="<c:url value='/styles/bootstrap-theme.css'/>">
	</head>

	<body>
	
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-header">
	  		 <a class="navbar-brand" href="#">RecipeMe</a>
	  	</div>
	  	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	  		<ul class="nav navbar-nav">
	  			<li><a href="<c:url value='/index' />">Home page </a></li>
        		<li><a class="active" href="<c:url value='/findRecipe' />">Find recipe<span class="sr-only">(current)</span></a></li>
        		<li><a href="<c:url value='/addRecipe' />">Add recipe</a></li>
	  		</ul>
	  		
	  		<sec:authorize access="isAnonymous()">
		  		<ul class="nav navbar-nav navbar-right navMargin">
				      <li><a href="<c:url value='/user' />">Sign Up</a></li>
				      <li><a href="<c:url value='/login' />"> Login</a></li>
	   			</ul>
   			</sec:authorize>
   			<sec:authorize access="isAuthenticated()">
		  		<ul class="nav navbar-nav navbar-right navMargin">
				      <li><a href="<c:url value="/j_spring_security_logout" />""> Logout</a></li>
	   			</ul>
   			</sec:authorize>
	  	</div>
	</nav>
	<div class="container loginBox">
		<h1>Find Recipe</h1>
		
		<form action="" method="POST" modelAttribute="userCommand">
			<fieldset class="fieldcontainer">
				<legend>Enter username and password</legend>

				<div class="block">
					<div class="form-gorup">
						<label for="email">Username:</label>
						<input class="form-control" placeholder="Enter username" name="j_username">
					</div>
	
					<div class="form-group">
						<label for="pwd">Password:</label>
						<input type="password" class="form-control" placeholder="Enter password" name="j_password">
					</div>

				</div>

				<div class="field vertical text-center">
					<input id="logButton" type="submit" class='btn btn-dark btn-lg'  value="Login">
				</div>

			</fieldset>
		</form>
		<div>
			<table>
			<thead>
			</thead>
				<tbody>
					<c:forEach var="ingredient" items="${ingredients}" varStatus="row">
						<tr>
							<td>${ingredient.name}</td>
						</tr>
					</c:forEach>
	
				</tbody>
			</table>
	
		</div>
	</div>
		<div id="footer" class="">
		    <div class="container">
			   	 <div class="row text-center footerText">
			   		<div class="col-sm-3 pull-right">
			   			<p>RecipeMe 2016</p>
			   		</div>
			     </div>
		       
		    </div>
		</div>
	</body>
</html>