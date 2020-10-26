<%@ include file="/jspf/directive/page.jspf"%>
<%@ include file="/jspf/directive/taglib.jspf"%>

<html>

<fmt:message key="registration" var="reg" />
<c:set var="title" value="${reg}" />
<%@ include file="/jspf/head.jspf"%>

<body>
	<table id="main-container">

		<%@ include file="/jspf/header.jspf"%>

		<tr>
			<td class="content center">
				<%-- CONTENT --%>
				<h2><fmt:message key="insertInfo"/>
				</h2>

				<form id="login_form"
					action="${pageContext.request.contextPath}/controller"
					method="post">
					<input type="hidden" name="command" value="registration" />

					<fieldset>
						<legend><fmt:message key="firstName"/>
						</legend>
						<fmt:message key="titleFirstName" var="titleFirstName"/>
						<c:choose>
							<c:when test="${user.firstname == null}">
								<input name="firstname" value="" required pattern="[A-Za-z\u0400-\u04ff]{2,45}" title="${titleFirstName}">
							</c:when>
							<c:when test="${user.firstname != null}">
								<input name="firstname" value="${user.firstname}" required pattern="[A-Za-z\u0400-\u04ff]{2,45}" title="${titleFirstName}">
							</c:when>
						</c:choose>
						<br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="name"/></legend>
						<fmt:message key="titleName" var="titleName"/>
						<c:choose>
							<c:when test="${user.name == null}">
								<input name="name" value="" required pattern="[A-Za-z\u0400-\u04ff]{2,45}" title="${titleName}">
							</c:when>
							<c:when test="${user.name != null}">
								<input name="name" value="${user.name}" required pattern="[A-Za-z\u0400-\u04ff]{2,45}" title="${titleName}">
							</c:when>
						</c:choose>
						<br />
					</fieldset>
					<br />
					
					<fieldset>
						<legend><fmt:message key="lastName"/></legend>
						<fmt:message key="titleLastName" var="titleLastName"/>
						<c:choose>
							<c:when test="${user.lastname == null}">
								 <input name="lastname" value="" required pattern="[A-Za-z\u0400-\u04ff]{2,45}" title="${titleLastName}">
							</c:when>
							<c:when test="${user.lastname != null}">
								 <input name="lastname" value="${user.lastname}" required pattern="[A-Za-z\u0400-\u04ff]{2,45}" title="${titleLastName}">
							</c:when>
						</c:choose>
						<br />
					</fieldset>
					<br />
					
					<fieldset>
						<legend><fmt:message key="adress"/></legend>
						<fmt:message key="titleAdress" var="titleAdress"/>
						<c:choose>
							<c:when test="${user.adress == null}">
								 <input name="adress" value="" required pattern="[\w\u0400-\u04ff]{8,255}" title="${titleAdress}">
							</c:when>
							<c:when test="${user.adress != null}">
								<input name="adress" value="${user.adress}" required pattern="[\w\u0400-\u04ff]{8,255}" title="${titleAdress}">
							</c:when>
						</c:choose>
						<br />
					</fieldset>
					<br />
					
					<fieldset>
						<legend><fmt:message key="pasport"/></legend>
						<fmt:message key="titlePasport" var="titlePasport"/>
						<c:choose>
							<c:when test="${user.pasport == null}">
								 <input name="pasport" value="" required pattern="[A-Za-z\u0400-\u04ff]{2}\d{6}" title="${titlePasport}">
							</c:when>
							<c:when test="${user.pasport != null}">
								 <input name="pasport" value="${user.pasport}" required pattern="[A-Za-z\u0400-\u04ff]{2}\d{6}" title="${titlePasport}">
							</c:when>
						</c:choose>
						<br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="telephone"/></legend>
						<fmt:message key="titleTel" var="titleTel"/>
						<c:choose>
							<c:when test="${user.tel == null}">
								 <input name="tel" value="" required pattern="\d{7}" title="${titleTel}">
							</c:when>
							<c:when test="${user.tel != null}">
								 <input name="tel" value="${user.tel}" required pattern="\d{7}" title="${titleTel}">
							</c:when>
						</c:choose>
						<br />
					</fieldset>
					<br />
					<br />
					<fmt:message key="addInfo" var = "addInf"/>
					<input type="submit" value="${addInf}"><br />
				</form> <%-- CONTENT --%>
			</td>
		</tr>

		<%@ include file="/jspf/footer.jspf"%>

	</table>
</body>
</html>