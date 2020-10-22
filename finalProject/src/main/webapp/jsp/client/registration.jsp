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
						<c:choose>
							<c:when test="${user.firstname == null}">
								<input name="firstname" value="" required>
							</c:when>
							<c:when test="${user.firstname != null}">
								<input name="firstname" value="${user.firstname}" required>
							</c:when>
						</c:choose>
						<br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="name"/></legend>
						<c:choose>
							<c:when test="${user.name == null}">
								<input name="name" value="" required>
							</c:when>
							<c:when test="${user.name != null}">
								<input name="name" value="${user.name}" required>
							</c:when>
						</c:choose>
						<br />
					</fieldset>
					<br />
					
					<fieldset>
						<legend><fmt:message key="lastName"/></legend>
						<c:choose>
							<c:when test="${user.lastname == null}">
								 <input name="lastname" value="" required>
							</c:when>
							<c:when test="${user.lastname != null}">
								 <input name="lastname" value="${user.lastname}"
									required>
							</c:when>
						</c:choose>
						<br />
					</fieldset>
					<br />
					
					<fieldset>
						<legend><fmt:message key="adress"/></legend>
						<c:choose>
							<c:when test="${user.adress == null}">
								 <input name="adress" value="" required>
							</c:when>
							<c:when test="${user.adress != null}">
								<input name="adress" value="${user.adress}" required>
							</c:when>
						</c:choose>
						<br />
					</fieldset>
					<br />
					
					<fieldset>
						<legend><fmt:message key="pasport"/></legend>
						<c:choose>
							<c:when test="${user.pasport == null}">
								 <input name="pasport" value="" required>
							</c:when>
							<c:when test="${user.pasport != null}">
								 <input name="pasport" value="${user.pasport}" required>
							</c:when>
						</c:choose>
						<br />
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="telephone"/></legend>
						<c:choose>
							<c:when test="${user.tel == null}">
								 <input name="tel" value="" required>
							</c:when>
							<c:when test="${user.tel != null}">
								 <input name="tel" value="${user.tel}" required>
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