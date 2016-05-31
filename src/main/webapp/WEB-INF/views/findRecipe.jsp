<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@
	taglib prefix="form" uri="http://www.springframework.org/tags/form" %><%@
	taglib prefix="spring" uri="http://www.springframework.org/tags"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>RecipeMe</title>
<link rel="stylesheet" href="<c:url value='/styles/site.css'/>">
<link rel="stylesheet" href="<c:url value='/styles/bootstrap.min.css'/>">
<link rel="stylesheet"
	href="<c:url value='/styles/bootstrap-theme.css'/>">
</head>

<body>
	<h1>Tu kiedyś będzie content do szukania przepisów</h1>
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
</body>
</html>