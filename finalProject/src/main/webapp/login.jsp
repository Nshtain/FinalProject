<%@ include file="/jspf/directive/page.jspf"%>
<%@ include file="/jspf/directive/taglib.jspf"%>

<html>
<fmt:message key="login" var="login" />
<c:set var="title" value="${login}" />

<%@ include file="/jspf/head.jspf"%>



<body>


	<%--=========================================================================== 
Here we use a table layout.
Class page corresponds to the '.page' element in included CSS document.
===========================================================================--%>
	<table id="main-container">

		<%--=========================================================================== 
This is the HEADER, containing a top menu.
header.jspf contains all necessary functionality for it.
Just included it in this JSP document.
===========================================================================--%>

		<%-- HEADER --%>
		<%@ include file="/jspf/header.jspf"%>
		<%-- HEADER --%>

		<%--=========================================================================== 
This is the CONTENT, containing the main part of the page.
===========================================================================--%>
		<tr>
			<td class="content center">
				<%-- CONTENT --%> <%--=========================================================================== 
Defines the web form.
===========================================================================--%>
				<form id="login_form"
					action="${pageContext.request.contextPath}/controller"
					method="post">

					<%--=========================================================================== 
Hidden field. In the query it will act as command=login.
The purpose of this to define the command name, which have to be executed 
after you submit current form. 
===========================================================================--%>
					<input type="hidden" name="command" value="login" />
					<fieldset>
						<legend>${login}</legend>
						<fmt:message key="titleLog" var="titleLog"/>
						<input id="login" name="login" required pattern=".{4,16}" title="${titleLog}"/><br />
					</fieldset>
					<br />
					<fieldset>
						<legend>
							<fmt:message key="password" />
						</legend>
						<fmt:message key="titlePas" var="titlePas"/>
						<input type="password" name="password" required pattern=".{4,32}" title="${titlePas}"/>
					</fieldset>
					<br /> <br>
					<button name="login" value="login" type="submit">${login}</button>
					<button name="newAcc" value="newAcc" type="submit">
						<fmt:message key="newAcc" />
					</button>
					

				</form> <%-- CONTENT --%>
			</td>
		</tr>

		<%@ include file="/jspf/footer.jspf"%>

	</table>

</body>
</html>