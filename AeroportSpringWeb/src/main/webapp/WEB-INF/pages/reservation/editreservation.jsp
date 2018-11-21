<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<fieldset>
			<legend>edition de la reservation</legend>
			<form:form action="./save" method="post" modelAttribute="reservation">
				<form:hidden path="version" />
				<div class="form-group">
					<form:label path="id">id</form:label>
					<form:input path="id" readonly="true" cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:label path="date">date de la reservation</form:label>
					<form:input type="date" path="date" cssClass="form-control" />
					<form:errors path="date"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="numero">numero</form:label>
					<form:input type="number" path="numero" cssClass="form-control" />
					<form:errors path="numero"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="vol">vol</form:label>
					<form:select path="vol.id" cssClass="form-control">
						<form:options items="${vols}" itemLabel="id" itemValue="id" />
					</form:select>
				</div>

				<div class="form-group">
					<label>client</label> <select class="form-control" name="clientId">
						<c:forEach var="client" items="${clients}">
							<c:choose>
								<c:when test="${client.id == reservation.client.id}">
									<option value="${client.id}" label="${client.nom}"
										selected="selected" />
								</c:when>
								<c:otherwise>
									<option value="${client.id}" label="${client.nom}" />
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<form:label path="passager">passager</form:label>
					<form:select path="passager.id" cssClass="form-control">
						<form:options items="${passagers}" itemLabel="nom" itemValue="id" />
					</form:select>
				</div>
				<div>
					<button class="btn btn-success" type="submit">enregistrer</button>
					<a class="btn btn-warning" href="./">annuler</a>
				</div>
			</form:form>
		</fieldset>
	</div>
</body>
</html>