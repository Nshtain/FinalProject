<%@ page pageEncoding="UTF-8"%>
<%@ include file="/jspf/directive/page.jspf"%>
<%@ include file="/jspf/directive/taglib.jspf"%>
<%@ taglib prefix="mytag" uri="/WEB-INF/tld/mytaglib.tld"%>


<html>

<fmt:message key="bill" var="bil" />
<c:set var="title" value="${bil}" />
<%@ include file="/jspf/head.jspf"%>

<body>
	<table id="main-container">

		<%@ include file="/jspf/header.jspf"%>

		<tr>
			<td class="content">
				<%-- CONTENT --%>

				<form id="pay_bill" action="${pageContext.request.contextPath}/controller" method="post">
					<input type="hidden" name="command" value="payBill" />

					<table id="list_order_table">
						<tr>
							<td>#</td>
							<td><fmt:message key="contract"/></td>
							<td><fmt:message key="totalPrice"/></td>
						</tr>
						<tr>
							<td>1</td>
							<td>${bill.contractId}</td>
							<td>${bill.totalPrice}</td>
						</tr>
						<tr>
							<td></td>
							<fmt:message key="pay" var="pay" />
							
							<td><input type="submit" value="${pay}" /></td>
							<td></td>
						</tr>
					</table>

					<%-- CONTENT --%>
				</form>
			</td>
		</tr>

		<%@ include file="/jspf/footer.jspf"%>

	</table>
</body>