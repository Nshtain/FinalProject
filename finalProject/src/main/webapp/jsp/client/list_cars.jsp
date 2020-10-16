<%@ page pageEncoding="UTF-8"%>
<%@ include file="/jspf/directive/page.jspf"%>
<%@ include file="/jspf/directive/taglib.jspf"%>
<%@ taglib prefix="mytag" uri="/WEB-INF/tld/mytaglib.tld"%>


<html>

<c:set var="title" value="Cars" scope="page" />
<%@ include file="/jspf/head.jspf"%>


<body>
	<table id="main-container">

		<%@ include file="/jspf/header.jspf"%>

		<tr>
			<td class="content">
				<%-- CONTENT --%>
				<table id="filters">
					<tr>
						<td><div class="dropdown">
								<button class="dropbtn">Sort</button>
								<div class="dropdown-content">
									<a href="?command=listCars&sort=price">Price</a> <a
										href="?command=listCars&sort=brand">Brand</a>
								</div>
							</div></td>
						<td><h3>Filters</h3></td>
						<td><div class="dropdown">
								<button class="dropbtn">Brand</button>
								<div class="dropdown-content">
									<a href="#">Ссылка 1</a> <a href="#">Ссылка 2</a> <a href="#">Ссылка
										3</a>
								</div>
							</div><div class="dropdown">
								<button class="dropbtn">Quality Class</button>
								<div class="dropdown-content">
									<a href="#">Ссылка 1</a> <a href="#">Ссылка 2</a> <a href="#">Ссылка
										3</a>
								</div>
							</div></td>
					</tr>
				</table>
				<table id="list_cars_table" class="center">

					<tr>
						<c:set var="count" value="0" />
						<c:forEach begin="${page*12}" end="${page*12+12-1}" var="i">
						<c:if test="${i < cars.size()}">
							<td>
								<form id="make_order" action="controller" method="post">
									<input type="hidden" name="command" value="checkMakeOrder" />

									<div class="card">
										<img src="${pageContext.request.contextPath}/img/${cars[i].image}">
										<h2>${cars[i].brand} ${cars[i].model}</h2>
										<p class="price">${cars[i].price}</p>
										<p>Некоторый текст о машине..</p>
										<input type="hidden" name="carId" value="${cars[i].id}" /> <input
											type="submit" value="buy">

									</div>

								</form>
							</td>
							</c:if>
							<c:set var="count" value="${count+1}" />
							<mytag:mytag num="${count}" />

						</c:forEach>
					</tr>
				</table> <c:set var="count" value="${cars.size()/12}" /> <c:if
					test="${count%12 > 0}">
					<c:set var="count" value="${count+1}" />
				</c:if>
				<table id="pag" class="pag">
					<tr>
						<td>
							<ul id="pagination" class="pagination">
								<c:url var="myURL" value="?">
									<c:forEach items="${param}" var="entry">
										<c:if test="${entry.key != 'page'}">
											<c:param name="${entry.key}" value="${entry.value}" />
										</c:if>
									</c:forEach>
								</c:url>
								<c:forEach begin="1" end="${count}" var="i">
									<li><a
										href="${myURL}page=${i}">${i}</a></li>
								</c:forEach>
							</ul>
						</td>
					</tr>
				</table> <%-- CONTENT --%>
			</td>
		</tr>

		<%@ include file="/jspf/footer.jspf"%>

	</table>
</body>