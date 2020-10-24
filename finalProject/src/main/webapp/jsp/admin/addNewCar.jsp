<%@ include file="/jspf/directive/page.jspf" %>
<%@ include file="/jspf/directive/taglib.jspf" %>

<html>

<fmt:message key="addNewCar" var="newCar" />
<c:set var="title" value="${newCar}" />
<%@ include file="/jspf/head.jspf" %>

<body>
	<table id="main-container">

		<%@ include file="/jspf/header.jspf" %>

		<tr>
			<td class="content center">
				<%-- CONTENT --%>
				<h3><fmt:message key="addNewCar"/></h3>

				<form id="login_form" action="${pageContext.request.contextPath}/controller" method="post">
					<input type="hidden" name="command" value="addNewCar" />
					<fieldset>
						<legend><fmt:message key="brand"/></legend>
						<fmt:message key="titleBrand" var="titleBrand"/>
						<input type="text" name="brand" placeholder="Brand" required pattern="[A-Za-z\u0400-\u04ff]{2,25}" title="${titleBrand}"/><br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="model"/></legend>
						<fmt:message key="titleModel" var="titleModel"/>
						<input type="text" name="model" placeholder="Model" required pattern="[\w\u0400-\u04ff]{1,25}" title="${titleModel}"/><br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="type"/></legend>
						<fmt:message key="titleType" var="titleType"/>
						<input type="text" name="type" placeholder="Type" required pattern="[A-Za-z\u0400-\u04ff]{4,45}" title="${titleType}"/><br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="image"/></legend>
						<fmt:message key="titleImage" var="titleImage"/>
						<input type="text" name="image" placeholder="Image" required pattern="[\w\u0400-\u04ff]+.[a-z]+" maxlength="45" title="${titleImage}"/><br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="earOfIssue"/></legend>
						<fmt:message key="titleEarOfIssue" var="titleEarOfIssue"/>
						<input type="number" name="earOfIssue" placeholder="Ear of issue" required min="1800" max="2020" title="${titleEarOfIssue}"/><br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="qualityClass"/></legend>
						<fmt:message key="titleQualityClass" var="titleQualityClass"/>
						<input type="text" name="qualityClass" placeholder="Quality class" required pattern="[A-Za-z\u0400-\u04ff]{3,45}" title="${titleQualityClass}"/><br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="price"/></legend>
						<fmt:message key="titlePrice" var="titlePrice"/>
						<input type="number" name="price" placeholder="Price" required min="100" max="9000" title="${titlePrice}"/><br />
					</fieldset>
					<br />
					<fmt:message key="add" var = "add"/>
					<input type="submit" value="${add}"><br/>
				</form> 
				
				<%-- CONTENT --%>
			</td>
		</tr>

		<%@ include file="/jspf/footer.jspf" %>
		
	</table>
</body>
</html>