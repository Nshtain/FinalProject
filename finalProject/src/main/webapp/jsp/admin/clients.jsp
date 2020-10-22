<%@ page pageEncoding="UTF-8"%>
<%@ include file="/jspf/directive/page.jspf" %>
<%@ include file="/jspf/directive/taglib.jspf" %>

<html>

<fmt:message key="clients" var="cliens" />
<c:set var="title" value="${cliens}" />
<%@ include file="/jspf/head.jspf" %>

<body>
	<table id="main-container">

		<%@ include file="/jspf/header.jspf" %>
			
		<tr>
			<td class="content">
			<%-- CONTENT --%>

			<table id="order_table">
					<tr>
						<td>
							<table id="list_order_table">
								<tr>
									<td>#</td>
									<td><fmt:message key="user"/></td>
									<td><fmt:message key="login"/></td>
									<td><fmt:message key="firstName"/></td>
									<td><fmt:message key="name"/></td>
									<td><fmt:message key="lastName"/></td>
									<td><fmt:message key="status"/></td>
								</tr>
							</table>
						</td>
					</tr>
					<c:set var="k" value="0" />
					<c:forEach var="client" items="${clientList}">
						<c:set var="k" value="${k+1}" />
						<tr>
							<td>
								<form id="pay_bill" action="${pageContext.request.contextPath}/controller" method="post">
									<input type="hidden" name="command" value="updateClientStatus" />
									<table id="list_order_table">
										<tr>
											<td><c:out value="${k}" /></td>
											<td>${client.id}</td>
											<td>${client.login}</td>
											<td>${client.firstname}</td>
											<td>${client.name}</td>
											<td>${client.lastname}</td>
											<td><c:choose>
													<c:when test="${client.blocked}">
														<input type="hidden" name="clientId"
															value="${client.id}" />
															<fmt:message key="unblock" var="un"/>
														<input type="submit" value="${un}" />
													</c:when>
													<c:otherwise>
														<input type="hidden" name="clientId" value="${client.id}" />
														<fmt:message key="block" var="block"/>
														<input type="submit" value="${block}" />							
													</c:otherwise>
												</c:choose></td>
										</tr>
									</table>
								</form>
							</td>
						</tr>
					</c:forEach>
				</table>
					
			<%-- CONTENT --%>
			</td>
		</tr>
		
		<%@ include file="/jspf/footer.jspf" %>
		
	</table>
</body>
</html>