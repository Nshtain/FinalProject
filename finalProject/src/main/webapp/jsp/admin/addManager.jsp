<%@ include file="/jspf/directive/page.jspf"%>
<%@ include file="/jspf/directive/taglib.jspf"%>

<html>

<fmt:message key="addNewManager" var="addManag" />
<c:set var="title" value="${addManag}" />
<%@ include file="/jspf/head.jspf"%>

<body>
	<table id="main-container">

		<%@ include file="/jspf/header.jspf"%>

		<tr>
			<td class="content center">
				<%-- CONTENT --%>
				<h2><fmt:message key="insertInfo"/></h2>

				<form id="login_form"
					action="${pageContext.request.contextPath}/controller"
					method="post">
					<input type="hidden" name="command" value="addManager" />

					<fieldset>
						<legend><fmt:message key="login"/></legend>
						<input name="login" value="" required> <br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="password"/></legend>
						<input name="password" value="" required> <br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="firstName"/></legend>
						<input name="firstname" value="" required> <br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="name"/></legend>
						<input name="name" value="" required> <br />
					</fieldset>
					<br />

					<fieldset>
						<legend><fmt:message key="lastName"/></legend>
						<input name="lastname" value="" required> <br />
					</fieldset>
					<br />

					<fieldset>
						<legend><fmt:message key="adress"/></legend>
						<input name="adress" value="" required> <br />
					</fieldset>
					<br />

					<fieldset>
						<legend><fmt:message key="pasport"/></legend>
						<input name="pasport" value="" required> <br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="telephone"/></legend>
						<input name="tel" value="" required> <br />
					</fieldset>
					<br /> <br /> 
					
					<input type="submit" value="${addManag}"><br />
				</form> <%-- CONTENT --%>
			</td>
		</tr>

		<%@ include file="/jspf/footer.jspf"%>

	</table>
</body>
</html>