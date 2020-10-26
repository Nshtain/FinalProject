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
						<fmt:message key="titleBrand" var="titleBrand"/>
						<input name="brand" placeholder="Brand" value="${car.brand}" required pattern="[A-Za-z\u0400-\u04ff]{2,25}" title="${titleBrand}"> <br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="model"/></legend>
						<fmt:message key="titleModel" var="titleModel"/>
						<input name="model" placeholder="Model" value="${car.model}" required pattern="[\w\u0400-\u04ff]{1,25}" title="${titleModel}"> 
						<br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="type"/></legend>
						<fmt:message key="titleType" var="titleType"/>
						<input name="type" placeholder="Type" value="${car.type}" required pattern="[A-Za-z\u0400-\u04ff]{4,45}" title="${titleType}">
						<br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="image"/></legend>
						<fmt:message key="titleImage" var="titleImage"/>
						<input name="image" placeholder="image" value="${car.image}" required pattern="[\w\u0400-\u04ff]+.[a-z]+" maxlength="45" title="${titleImage}">
						<br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="earOfIssue"/></legend>
						<fmt:message key="titleEarOfIssue" var="titleEarOfIssue"/>
						<input type="number" name="earOfIssue" placeholder="Ear of issue" value="${car.earOfIssue}" required min="1800" max="2020" title="${titleEarOfIssue}">
						<br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="qualityClass"/></legend>
						<fmt:message key="titleQualityClass" var="titleQualityClass"/>
						<input name="qualityClass" placeholder="Quality class" value="${car.qualityClass}" required pattern="[A-Za-z\u0400-\u04ff]{3,45}" title="${titleQualityClass}">
						<br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="price"/></legend>
					    <fmt:message key="titlePrice" var="titlePrice"/>
						<input type="number" name="price" placeholder="Price" value="${car.price}" required min="100" max="9000" title="${titlePrice}">
						<br />
					</fieldset>
					<br />
					<fmt:message key="update" var="update" />
					<input type="submit" value="${update}"><br/>
					</form> 
				
				<%-- CONTENT --%>
			</td>
		</tr>

		<%@ include file="/jspf/footer.jspf" %>
		
	</table>
</body>
</html>