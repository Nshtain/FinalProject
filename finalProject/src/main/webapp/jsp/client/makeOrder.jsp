<%@ include file="/jspf/directive/page.jspf"%>
<%@ include file="/jspf/directive/taglib.jspf"%>

<html>

<fmt:message key="makeOrder" var="makeOrdr" />
<c:set var="title" value="${makeOrdr}" />
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
				<form id="login_form" action="${pageContext.request.contextPath}/controller" method="post">

					<input type="hidden" name="command" value="makeOrder" />

					<fieldset>
						<legend><fmt:message key="withDriver"/></legend>
						<br /> <select id="driver" name="driver">
							<option value="true"><fmt:message key="yes"/></option>
							<option value="false"><fmt:message key="no"/></option>
						</select>
					</fieldset>
					<br />
					<fieldset>
						<legend><fmt:message key="amountOfDays"/></legend>
						<input type="number" name="rentalTerm" value="1" min="1" max="99" required title="Number must be within 1-99"/>
					</fieldset>
					<br /> <input type="submit" value="${makeOrdr}">
				</form> <%-- CONTENT --%>

			</td>
		</tr>

		<%@ include file="/jspf/footer.jspf"%>

	</table>
</body>
</html>