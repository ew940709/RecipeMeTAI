<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@
	taglib
	prefix="form" uri="http://www.springframework.org/tags/form"%><%@
	taglib
	prefix="spring" uri="http://www.springframework.org/tags"%>
<%@	taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>RecipeMe</title>
<link rel="stylesheet" href="<c:url value='/styles/site.css'/>">
<link rel="stylesheet" href="<c:url value='/styles/bootstrap.min.css'/>">
<link rel="stylesheet"
	href="<c:url value='/styles/bootstrap-theme.css'/>">
<link rel="stylesheet"
	href="<c:url value='/styles/font-awesome.min.css'/>">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="<c:url value='/scripts/lib/bootstrap.min.js'/>"></script>
</head>

<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">RecipeMe</a>
	</div>
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav">
			<li><a href="<c:url value='/index' />">Home page </a></li>
			<li><a class="active" href="<c:url value='/findRecipe' />">Find
					recipe<span class="sr-only">(current)</span>
			</a></li>
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
				<li><a href="<c:url value="/j_spring_security_logout" />">
						Logout</a></li>
			</ul>
		</sec:authorize>
	</div>
	</nav>

	<div id="form-box" class="container">

		<span class="post-attr">Posted by: ${recipe.author.name} </span>
		<h2>
			<span class="rating label label-primary">${recipe.averageRating }</span>
		</h2>


		<h1>${recipe.title}</h1>

		<hr class="" />
		<div class="row">

			<div class="container col-md-4 pull-right">

				<div class="panel panel-primary ">
					<div class="panel-heading">
							<h3 class="panel-title">
								Ingredients:
							</h3>
					</div>
					<div class="panel-body">

						<c:forEach var="ingredient" items="${recipe.ingredientList}">
							<span class="ingredient"> ${ingredient.name} </span>								
						</c:forEach>
					</div>
				</div>

			</div>

			<div class="container col-md-12">

				<div class="panel panel-primary ">
					<div class="panel-heading">
							<h3 class="panel-title">
								Method:
							</h3>
					</div>
					<div class="panel-body">
						${recipe.description}</div>
				</div>

			</div>
		</div>




		<hr class="" />

		<div class="row container">
			<h4><b>Comment list</b></h4>
			<c:forEach var="comment" items="${commentList }">
				<div class="row">
					<div class="container col-md-7">${comment.content}<span
							class="post-attr"> ${comment.author.name} ${comment.date }</span>
							<hr />
					</div>

				</div>


			</c:forEach>
		</div>


		<sec:authorize access="isAuthenticated()">
			<div class="row">
				<h4 id="commentH">Add comment</h4>
				<div class="col-md-12">
					<form:form action="addComment" method="POST"
						commandName="commentForm">
						<form:input type="hidden" path="recipeId" value="${recipe.id}" />
						<form:textarea class="form-control" path="content" />
						<div class="commentButton">
							<button class="btn btn-default commentButton pull-right"
								type="submit">Add</button>
						</div>
					</form:form>
				</div>

			</div>

		</sec:authorize>
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