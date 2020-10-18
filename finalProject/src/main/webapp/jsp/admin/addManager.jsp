<%@ include file="/jspf/directive/page.jspf"%>
<%@ include file="/jspf/directive/taglib.jspf"%>

<html>

<c:set var="title" value="Add manager" scope="page" />
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
					<input type="hidden" name="command" value="addManager" />

					<fieldset>
						<legend>Login</legend>
						<input name="login" value="" required> <br />
					</fieldset>
					<br />
					<fieldset>
						<legend>Password</legend>
						<input name="password" value="" required> <br />
					</fieldset>
					<br />
					<fieldset>
						<legend>First name</legend>
						<input name="firstname" value="" required> <br />
					</fieldset>
					<br />
					<fieldset>
						<legend>Name</legend>
						<input name="name" value="" required> <br />
					</fieldset>
					<br />

					<fieldset>
						<legend>Last name</legend>
						<input name="lastname" value="" required> <br />
					</fieldset>
					<br />

					<fieldset>
						<legend>Adress</legend>
						<input name="adress" value="" required> <br />
					</fieldset>
					<br />

					<fieldset>
						<legend>Pasport</legend>
						<input name="pasport" value="" required> <br />
					</fieldset>
					<br />
					<fieldset>
						<legend>Telephone</legend>
						<input name="tel" value="" required> <br />
					</fieldset>
					<br /> <br /> <input type="submit" value="Add manager"><br />
				</form> <%-- CONTENT --%>
			</td>
		</tr>

		<%@ include file="/jspf/footer.jspf"%>

	</table>
</body>
</html>