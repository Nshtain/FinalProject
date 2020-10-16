<%@ page pageEncoding="UTF-8"%>
<%@ include file="/jspf/directive/page.jspf"%>
<%@ include file="/jspf/directive/taglib.jspf"%>
<%@ taglib prefix="mytag" uri="/WEB-INF/tld/mytaglib.tld"%>


<html>

<c:set var="title" value="Contract" scope="page" />
<%@ include file="/jspf/head.jspf"%>

<body>
	<table id="main-container">

		<%@ include file="/jspf/header.jspf"%>

		<tr>
			<td class="content">
				<%-- CONTENT --%>
				<table id="order_table">
					<tr>
						<td>
							<table id="list_order_table">
								<tr>
									<th>#</th>
									<th>car id</th>
									<th>user id</th>
									<th>rental term</th>
									<th>driver</th>
									<th>status</th>
									<th>action</th>
								</tr>
							</table>
						</td>
					</tr>
					<c:set var="k" value="0" />
					<c:forEach var="contract" items="${contracts}">
						<c:set var="k" value="${k+1}" />
						<tr>
							<td>
								<form id="pay_bill" action="controller" method="post">
									<input type="hidden" name="command" value="showBill" />
									<table id="list_order_table">
										<tr>
											<td><c:out value="${k}" /></td>
											<td>${contract.carId}</td>
											<td>${contract.userId}</td>
											<td>${contract.rentalTerm}</td>
											<td>${contract.withDriver}</td>
											<td>${contract.status}</td>
											<td><c:choose>
													<c:when test="${contract.status.ordinal() == 0}">
														<input type="hidden" name="contractId"
															value="${contract.id}" />
														<input type="submit" value="pay" />
													</c:when>
													<c:when test="${contract.status.ordinal() == 1}">
											${contract.status.getDescription()}	
										</c:when>
												</c:choose></td>
										</tr>
									</table>
								</form>
							</td>
						</tr>
					</c:forEach>
				</table> <%-- CONTENT --%>
			</td>
		</tr>

		<%@ include file="/jspf/footer.jspf"%>

	</table>
</body>