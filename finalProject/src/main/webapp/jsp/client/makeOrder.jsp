<%@ include file="/jspf/directive/page.jspf"%>
<%@ include file="/jspf/directive/taglib.jspf"%>

<html>

<c:set var="title" value="Make order" />
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
				<form id="login_form" action="${pageContext.request.contextPath}/controller" method="post">

					<%--=========================================================================== 
Hidden field. In the query it will act as command=login.
The purpose of this to define the command name, which have to be executed 
after you submit current form. 
===========================================================================--%>
					<input type="hidden" name="command" value="makeOrder" />

					<fieldset>
						<legend>Driver</legend>
						<br /> <select id="driver" name="driver">
							<option value="true">Yes</option>
							<option value="false">No</option>
						</select>
					</fieldset>
					<br />
					<fieldset>
						<legend>Amount of days</legend>
						<input type="text" name="rentalTerm" value="1" required />
					</fieldset>
					<br /> <input type="submit" value="make order">
				</form> <%-- CONTENT --%>

			</td>
		</tr>

		<%@ include file="/jspf/footer.jspf"%>

	</table>
</body>
</html>