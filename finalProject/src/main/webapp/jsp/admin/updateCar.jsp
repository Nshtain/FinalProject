<%@ include file="/jspf/directive/page.jspf" %>
<%@ include file="/jspf/directive/taglib.jspf" %>

<html>

<fmt:message key="updateCar" var="updateC" />
<c:set var="title" value="${updateC}" />
<%@ include file="/jspf/head.jspf" %>

<body>
	<table id="main-container">

		<%@ include file="/jspf/header.jspf" %>

		<tr>
			<td class="content center">
				<%-- CONTENT --%>
				<h2><fmt:message key="updateCar"/></h2>

				<form id="login_form" action="${pageContext.request.contextPath}/controller" method="post">
				<c:set var="i" value="${param.i}"/>
				<c:set var="car" value="${sessionScope.cars[i]}"/>
					<input type="hidden" name="command" value="updateCar" />
					<input type="hidden" name="carId" value="${car.id}" />
					<fieldset>
						<legend><fmt:message key="brand"/></legend>
						<input name="brand" placeholder="Brand" value="${car.brand}" required> <br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="model"/></legend>
						<input name="model" placeholder="Model" value="${car.model}" required> 
						<br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="type"/></legend>
						<input name="type" placeholder="Type" value="${car.type}" required>
						<br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="image"/></legend>
						<input name="image" placeholder="image" value="${car.image}" required>
						<br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="earOfIssue"/></legend>
						<input name="earOfIssue" placeholder="Ear of issue" value="${car.earOfIssue}" required>
						<br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="qualityClass"/></legend>
						<input name="qualityClass" placeholder="Quality class" value="${car.qualityClass}" required>
						<br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="price"/></legend>
						<input name="price" placeholder="Price" value="${car.price}" required>
						<br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="rentered"/></legend>
						<input name="rentered" placeholder="Rentered" value="${car.rentered}" required>
						<br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="damage"/></legend>
						<input name="damage" placeholder="Damage" value="${car.damage}" required>
						<br />
					</fieldset>
					<br /><fmt:message key="update" var="update" />
					<input type="submit" value="${update}"><br/>
					</form> 
				
				<%-- CONTENT --%>
			</td>
		</tr>

		<%@ include file="/jspf/footer.jspf" %>
		
	</table>
</body>
</html>