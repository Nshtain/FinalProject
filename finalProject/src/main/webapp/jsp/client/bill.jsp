<%@ page pageEncoding="UTF-8"%>
<%@ include file="/jspf/directive/page.jspf"%>
<%@ include file="/jspf/directive/taglib.jspf"%>
<%@ taglib prefix="mytag" uri="/WEB-INF/tld/mytaglib.tld"%>


<html>

<c:set var="title" value="Bill" scope="page" />
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
							<td>contract id</td>
							<td>total price</td>
						</tr>
						<tr>
							<td>1</td>
							<td>${bill.contractId}</td>
							<td>${bill.totalPrice}</td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="pay" /></td>
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