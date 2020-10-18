<%@ include file="/jspf/directive/page.jspf" %>
<%@ include file="/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="Update car" scope="page" />
<%@ include file="/jspf/head.jspf" %>

<body>
	<table id="main-container">

		<%@ include file="/jspf/header.jspf" %>

		<tr>
			<td class="content center">
				<%-- CONTENT --%>
				<h3>Update car</h3>

				<form id="updateCar_form" action="${pageContext.request.contextPath}/controller" method="post">
				<c:set var="i" value="${param.i}"/>
				<c:set var="car" value="${sessionScope.cars[i]}"/>
					<input type="hidden" name="command" value="updateCar" />
					<input type="hidden" name="carId" value="${car.id}" />
					<div>
						<input name="brand" placeholder="Brand" value="${car.brand}" required>
					</div>
					<br>
					<div>
						<input name="model" placeholder="Model" value="${car.model}" required>
					</div>
					<br>
					<div>
						<input name="type" placeholder="Type" value="${car.type}" required>
					</div>
					<br>
					<div>
						<input name="image" placeholder="image" value="${car.image}" required>
					</div>
					<br>
					<div>
						<input name="earOfIssue" placeholder="Ear of issue" value="${car.earOfIssue}" required>
					</div>
					<br>
					<div>
						<input name="qualityClass" placeholder="Quality class" value="${car.qualityClass}" required>
					</div>
					<br>
					<div>
						<input name="price" placeholder="Price" value="${car.price}" required>
					</div>	
					<br>
					<div>
						<input name="rentered" placeholder="Rentered" value="${car.rentered}" required>
					</div>
					<br>
					<div>
						<input name="damage" placeholder="Damage" value="${car.damage}" required>
					</div>
					<input type="submit" value="Update"><br/>
				</form> 
				
				<%-- CONTENT --%>
			</td>
		</tr>

		<%@ include file="/jspf/footer.jspf" %>
		
	</table>
</body>
</html>