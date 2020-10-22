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
						<input name="brand" placeholder="Brand" required> <br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="model"/></legend>
						<input name="model" placeholder="Model" required> 
						<br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="type"/></legend>
						<input name="type" placeholder="Type" required>
						<br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="image"/></legend>
						<input name="image" placeholder="image" required>
						<br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="earOfIssue"/></legend>
						<input name="earOfIssue" placeholder="Ear of issue" required>
						<br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="qualityClass"/></legend>
						<input name="qualityClass" placeholder="Quality class" required>
						<br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="price"/></legend>
						<input name="price" placeholder="Price" required>
						<br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="rentered"/></legend>
						<input name="rentered" placeholder="Rentered" required>
						<br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="damage"/></legend>
						<input name="damage" placeholder="Damage" required>
						<br />
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