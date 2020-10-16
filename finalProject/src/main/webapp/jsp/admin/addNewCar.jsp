<%@ include file="/jspf/directive/page.jspf" %>
<%@ include file="/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="Add car" scope="page" />
<%@ include file="/jspf/head.jspf" %>

<body>
	<table id="main-container">

		<%@ include file="/jspf/header.jspf" %>

		<tr>
			<td class="content center">
				<%-- CONTENT --%>
				<h3>Add car</h3>

				<form id="addNewCar_form" action="${pageContext.request.contextPath}/controller" method="post">
					<input type="hidden" name="command" value="addNewCar" />
					<div>
						<input name="brand" placeholder="Brand" required>
					</div>
					<br>
					<div>
						<input name="model" placeholder="Model" required>
					</div>
					<br>
					<div>
						<input name="type" placeholder="Type" required>
					</div>
					<br>
					<div>
						<input name="image" placeholder="image" required>
					</div>
					<br>
					<div>
						<input name="earOfIssue" placeholder="Ear of issue" required>
					</div>
					<br>
					<div>
						<input name="qualityClass" placeholder="Quality class" required>
					</div>
					<br>
					<div>
						<input name="price" placeholder="Price" required>
					</div>	
					<br>
					<div>
						<input name="rentered" placeholder="Rentered" required>
					</div>
					<br>
					<div>
						<input name="damage" placeholder="Damage" required>
					</div>
					<input type="submit" value="Add"><br/>
				</form> 
				
				<%-- CONTENT --%>
			</td>
		</tr>

		<%@ include file="/jspf/footer.jspf" %>
		
	</table>
</body>
</html>