<%@ page pageEncoding="UTF-8"%>
<%@ include file="/jspf/directive/page.jspf" %>
<%@ include file="/jspf/directive/taglib.jspf" %>

<html>

<fmt:message key="contracts" var="contrcts" />
<c:set var="title" value="${contrcts}" />
<%@ include file="/jspf/head.jspf" %>

<body>
	<table id="main-container">

		<%@ include file="/jspf/header.jspf" %>
			
		<tr>
			<td class="content">
			<%-- CONTENT --%>

			<c:choose>
			<c:when test="${fn:length(userOrderList) == 0}"><fmt:message key="noSuchOrders"/></c:when>
	
			<c:otherwise>
			<table id="order_table">
					<tr>
						<td>
							<table id="list_order_table">
								<tr>
									<th>#</th>
									<th><fmt:message key="car"/></th>
									<th><fmt:message key="user"/></th>
									<th><fmt:message key="rentalTerm"/></th>
									<th><fmt:message key="driver"/></th>
									<th><fmt:message key="status"/></th>
									<th><fmt:message key="input"/></th>
									<th><fmt:message key="action"/></th>
								</tr>
							</table>
						</td>
					</tr>
					<c:set var="k" value="0" />
					<c:forEach var="contract" items="${userOrderList}">
						<c:set var="k" value="${k+1}" />
						<tr>
							<td>
								<form id="contracts" action="controller" method="post">
									<input type="hidden" name="command" value="updateContractStatus" />
									<table id="list_order_table">
										<tr>
											<th><c:out value="${k}" /></th>
											<th>${contract.carId}</th>
											<th>${contract.userId}</th>
											<th>${contract.rentalTerm}</th>
											<th>${contract.withDriver}</th>
											<th>${contract.status}</th>
											<c:choose>
													<c:when test="${contract.status == 'NEW'}">
														<input type="hidden" name="contractId"
															value="${contract.id}" />
															<fmt:message key="causeDecline" var="causeDecl"/>
														<th><input name="cause" type="text" placeholder="${causeDecl}" /></th>
														<th><button name="decline" value="decline" type="submit"><fmt:message key="decline"/></button>
														<button name="confirm" value="confirm" type="submit"><fmt:message key="confirm"/></button></th>
													</c:when>
													<c:when test="${contract.status == 'PAID'}">
														<input type="hidden" name="contractId"
															value="${contract.id}" />
															<fmt:message key="setDamage" var="setDam"/>
														<th><input name="damageValue" type="number" placeholder="${setDam}" required min="0" max="99" title="Damage must be within 0-100%"/></th>
														<th><button name="damage" value="damage" type="submit"><fmt:message key="damage"/></button>
														<button name="close" value="close" type="submit"><fmt:message key="close"/></button></th>
													</c:when>
													<c:when test="${contract.status == 'PAID_DAMAGE'}">
														<input type="hidden" name="contractId"
															value="${contract.id}" />
														<th></th>
														<th><button name="close" value="close" type="submit"><fmt:message key="close"/></button></th>
													</c:when>
													<c:otherwise>
													<th></th>
													<th></th>
													</c:otherwise>
												</c:choose>
										</tr>
									</table>
								</form>
							</td>
						</tr>
					</c:forEach>
				</table>
							</c:otherwise>
			</c:choose>
						
			<%-- CONTENT --%>
			</td>
		</tr>
		
		<%@ include file="/jspf/footer.jspf" %>
		
	</table>
</body>
</html>