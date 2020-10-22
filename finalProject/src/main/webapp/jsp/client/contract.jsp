<%@ page pageEncoding="UTF-8"%>
<%@ include file="/jspf/directive/page.jspf"%>
<%@ include file="/jspf/directive/taglib.jspf"%>
<%@ taglib prefix="mytag" uri="/WEB-INF/tld/mytaglib.tld"%>


<html>

<fmt:message key="contract" var="contr" />
<c:set var="title" value="${contr}" />
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
									<td><b>#</b></td>
									<td><b><fmt:message key="car"/></b></td>
									<td><b><fmt:message key="user"/></b></td>
									<td><b><fmt:message key="rentalTerm"/></b></td>
									<td><b><fmt:message key="driver"/></b></td>
									<td><b><fmt:message key="status"/></b></td>
									<td><b><fmt:message key="action"/></b></td>
								</tr>
							</table>
						</td>
					</tr>
					<c:set var="k" value="0" />
					<c:forEach var="contract" items="${contracts}">
						<c:set var="k" value="${k+1}" />
						<tr>
							<td>
								<form id="pay_bill" action="${pageContext.request.contextPath}/controller" method="post">
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
													<c:when test="${contract.status == 'CONFIRMED' || contract.status == 'DAMAGE'}">
														<input type="hidden" name="contractId"
															value="${contract.id}" />
															<fmt:message key="pay" var="pay"/>
														<input type="submit" value="${pay}" />
													</c:when>
													<c:when test="${contract.status == 'DECLINED'}">
														${contract.status.getDescription()}	
													</c:when>
													<c:when test="${contract.status == 'NEW'}">
														<fmt:message key="waitForConfirmation"/>
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