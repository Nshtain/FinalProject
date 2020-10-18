<%@ page pageEncoding="UTF-8"%>
<%@ include file="/jspf/directive/page.jspf" %>
<%@ include file="/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="Contracts" scope="page" />
<%@ include file="/jspf/head.jspf" %>

<body>
	<table id="main-container">

		<%@ include file="/jspf/header.jspf" %>
			
		<tr>
			<td class="content">
			<%-- CONTENT --%>

			<c:choose>
			<c:when test="${fn:length(userOrderList) == 0}">No such orders</c:when>
	
			<c:otherwise>
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
									<th>input</th>
									<th>action</th>
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
														<th><input name="cause" type="text" placeholder="Cause decline" /></th>
														<th><button name="decline" value="decline" type="submit">Decline</button>
														<button name="confirm" value="confirm" type="submit">Confirm</button></th>
													</c:when>
													<c:when test="${contract.status == 'PAID'}">
														<input type="hidden" name="contractId"
															value="${contract.id}" />
														<th><input name="damageValue" type="text" placeholder="Set % damage" required/></th>
														<th><button name="damage" value="damage" type="submit">Damage</button>
														<button name="close" value="close" type="submit">Close</button></th>
													</c:when>
													<c:when test="${contract.status == 'PAID_DAMAGE'}">
														<input type="hidden" name="contractId"
															value="${contract.id}" />
														<th></th>
														<th><button name="confirm" value="confirm" type="submit">Close</button></th>
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