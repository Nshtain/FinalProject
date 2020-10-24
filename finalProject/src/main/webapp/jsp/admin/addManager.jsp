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
						<fmt:message key="titleLog" var="titleLog"/>
						<input id="login" name="login" required pattern=".{4,16}" title="${titleLog}"/><br />					
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="password"/></legend>
						<fmt:message key="titlePas" var="titlePas"/>
						<input type="password" name="password" required pattern=".{4,32}" title="${titlePas}"/><br/>
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="firstName"/></legend>
						<fmt:message key="titleFirstName" var="titleFirstName"/>
						<input type="text" name="firstName" required pattern="[A-Za-z\u0400-\u04ff]{2,45}" title="${titleFirstName}"/><br/>
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="name"/></legend>
						<fmt:message key="titleName" var="titleName"/>
						<input type="text" name="name" required pattern="[A-Za-z\u0400-\u04ff]{2,45}" title="${titleName}"/><br/>
					</fieldset>
					<br />

					<fieldset>
						<legend><fmt:message key="lastName"/></legend>
						<fmt:message key="titleLastName" var="titleLastName"/>
						<input type="text" name="lastName" required pattern="[A-Za-z\u0400-\u04ff]{2,45}" title="${titleLastName}"/><br/>
					</fieldset>
					<br />

					<fieldset>
						<legend><fmt:message key="adress"/></legend>
						<fmt:message key="titleAdress" var="titleAdress"/>
						<input type="text" name="adress" required pattern="\w{8,255}" title="${titleAdress}"/><br/>
					</fieldset>
					<br />

					<fieldset>
						<legend><fmt:message key="pasport"/></legend>
						<fmt:message key="titlePasport" var="titlePasport"/>
						<input type="text" name="pasport" required pattern="[A-Za-z\u0400-\u04ff]{2}\d{6}" title="${titlePasport}"/>
						 <br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="telephone"/></legend>
						<fmt:message key="titleTel" var="titleTel"/>
						<input type="tel" name="tel" placeholder="+380123456789" required pattern="+380\d{9}" title="${titleTel}"/>
						 <br />
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