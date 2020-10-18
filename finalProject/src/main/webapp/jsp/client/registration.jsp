<%@ include file="/jspf/directive/page.jspf"%>
<%@ include file="/jspf/directive/taglib.jspf"%>

<html>

<c:set var="title" value="Registration" scope="page" />
<%@ include file="/jspf/head.jspf"%>

<body>
	<table id="main-container">

		<%@ include file="/jspf/header.jspf"%>

		<tr>
			<td class="content center">
				<%-- CONTENT --%>
				<h2>Insert info</h2>

				<form id="login_form"
					action="${pageContext.request.contextPath}/controller"
					method="post">
					<input type="hidden" name="command" value="registration" />

					<fieldset>
						<legend>First name</legend>
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
						<legend>Name</legend>
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
						<legend>Last name</legend>
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
						<legend>Adress</legend>
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
						<legend>Pasport</legend>
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
						<legend>Telephone</legend>
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
					
					<input type="submit" value="Add info"><br />
				</form> <%-- CONTENT --%>
			</td>
		</tr>

		<%@ include file="/jspf/footer.jspf"%>

	</table>
</body>
</html>