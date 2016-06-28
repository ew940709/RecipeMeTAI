<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%@
	taglib prefix="form" uri="http://www.springframework.org/tags/form" %><%@
	taglib prefix="spring" uri="http://www.springframework.org/tags"
%>
<%@	taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Users</title>
		<link rel="stylesheet" href="<c:url value='/styles/site.css'/>">
		<link rel="stylesheet" href="<c:url value='/styles/bootstrap.min.css'/>">
		<link rel="stylesheet" href="<c:url value='/styles/bootstrap-theme.css'/>">
		<script src="<c:url value='/scripts/lib/bootstrap.min.js'/>"></script>
	</head>
	<body>
	
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-header">
	  		 <a class="navbar-brand" href="#">RecipeMe</a>
	  	</div>
	  	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	  		<ul class="nav navbar-nav">
	  			<li><a href="<c:url value='/index' />">Home page <span class="sr-only">(current)</span></a></li>
        		<li><a href="<c:url value='/findRecipe' />">Find recipe</a></li>
        		<li><a href="<c:url value='/addRecipe' />">Add recipe</a></li>
	  		</ul>
	  		
	  		<sec:authorize access="isAnonymous()">
		  		<ul class="nav navbar-nav navbar-right navMargin">
				      <li><a  class="active" href="<c:url value='/user' />">Sign Up</a></li>
				      <li><a href="<c:url value='/login' />"> Login</a></li>
	   			</ul>
   			</sec:authorize>
   			<sec:authorize access="isAuthenticated()">
		  		<ul class="nav navbar-nav navbar-right navMargin">
				      <li><a href="<c:url value="/j_spring_security_logout" />"> Logout</a></li>
	   			</ul>
   			</sec:authorize>
	  	</div>
	</nav>
	<div class="container loginBox">
		<h1>Registration form</h1>
		<c:if test="${!registration}">
		<form:form action="" method="post" modelAttribute="userCommand">
			<fieldset class="fieldcontainer">
				
					
				
				<legend>Enter username and password</legend>

				<div class="block">
					<div class="field">
						<form:label for="name" path="name">Name:</form:label>
						<form:errors path="name" cssClass="errors" />
						<form:input class="form-control" placeholder="Enter username" path="name" />
					</div>
	
					<div class="field">
						<form:label for="password" path="password">Password:</form:label>
						<form:errors path="password" cssClass="errors" />
						<form:input type="password" class="form-control" placeholder="Enter password" path="password" />
					</div>

					<div class="field vertical">
						<form:label for="email" path="email">Email:</form:label>
						<form:errors path="email" cssClass="errors" />
						<form:input class="form-control" placeholder="Enter email" path="email" />
					</div>
				</div>

				<div class="field">
					<form:label for="address" path="address">Address:</form:label>
					<form:errors path="address" cssClass="errors" />
					<form:textarea class="form-control" path="address" />
				</div>

				<div class="field vertical">
					<input id="logButton" class='btn btn-dark btn-lg' type="submit" value="Register">
				</div>

			</fieldset>
		</form:form>
		</c:if>
		<c:if test="${registration == true}">
		<div class="col-md-4 col-md-offset-4 text-center">
			You're successfully registered. <br>Click button below to login. 
					<a href="<c:url value="/login"/>" id="logButton" type="submit" class='btn btn-dark btn-lg'>Login</a>
		</div>		
		</c:if>
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
		
		<script src="<c:url value='/scripts/lib/prototype.js'/>"></script>
		<script src="<c:url value='/scripts/lib/RowSelector.js'/>"></script>
		<script src="<c:url value='/scripts/user.js'/>"></script>
	</body>
</html>
