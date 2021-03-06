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
	<div id="form-box" class="container loginBox">
		<h1>Find Recipe</h1>
		<legend id="legend">Choose ingredients and click find button</legend>
		<form:form action="findRecipe" method="POST"
			commandName="ingredientGrid">
			<fieldset>
				<div class="row">

							<div class="form-group panel-group" id="accordion">
								<c:forEach var="mapEntry" items="${ingredientGrid.categoryMap}"
									varStatus="status">
									<div class="panel panel-primary">
										<div class="panel-heading">
											<h3 class="panel-title">
												<a data-toggle="collapse" data-target="#${mapEntry.key}"
													href="#${mapEntry.key}" class="collapsed">
													${mapEntry.key} </a>
											</h3>
										</div>

										<div id="${mapEntry.key}" class="panel-collapse collapse">
										<div class="panel-body ingredient">
											<c:forEach var="ingredient" items="${mapEntry.value.ingList}"
												varStatus="status">

												<form:input type="hidden"
													path="categoryMap[${mapEntry.key}].ingList[${status.index}].name" />
												<form:input type="hidden"
													path="categoryMap[${mapEntry.key}].ingList[${status.index}].category" />
												<form:input type="hidden"
													path="categoryMap[${mapEntry.key}].ingList[${status.index}].category.name" />
												<form:input type="hidden"
													path="categoryMap[${mapEntry.key}].ingList[${status.index}].category.id" />
												<form:input type="hidden"
													path="categoryMap[${mapEntry.key}].ingList[${status.index}].Id" />
												<form:input type="hidden"
													path="categoryMap[${mapEntry.key}].ingList[${status.index}].isApproved" />

												<div class="form-group row checkbox">
													<c:if test="${ingredient.selected}">
														<form:checkbox
															path="categoryMap[${mapEntry.key}].ingList[${status.index}].selected"
															checked="checked" />
														<span class="c-indicator"></span>${ingredient.name }
									</c:if>
													<c:if test="${!ingredient.selected}">
														<label class="c-input c-checkbox"> <form:checkbox
																path="categoryMap[${mapEntry.key}].ingList[${status.index}].selected" />
															<span class="c-indicator"></span> ${ingredient.name }
														</label>
													</c:if>

												</div>

											</c:forEach>

										</div>
									</div>
									</div>
								</c:forEach>
							</div>

				</div>
				<div class="row">
					<div class="text-center col-md-4 col-md-offset-4">
						<input id="logButton" type="submit" class='btn btn-dark btn-lg'
							value="Find">
					</div>

				</div>

			</fieldset>
		</form:form>
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