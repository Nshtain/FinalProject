<%@ page pageEncoding="UTF-8"%>
<%@ include file="/jspf/directive/page.jspf"%>
<%@ include file="/jspf/directive/taglib.jspf"%>
<%@ taglib prefix="mytag" uri="/WEB-INF/tld/mytaglib.tld"%>


<html>

<fmt:message key="cars" var="Сars" />
<c:set var="title" value="${Сars}" />
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
								<button class="dropbtn"><fmt:message key="sort"/></button>
								<div class="dropdown-content">
									<a href="${pageContext.request.contextPath}/controller?command=listCars&sort=price"><fmt:message key="price"/></a>
									<a href="${pageContext.request.contextPath}/controller?command=listCars&sort=brand"><fmt:message key="brand"/></a>
								</div>
							</div></td>
						<td><h3><fmt:message key="filters"/></h3></td>
						<td><div class="dropdown">
								<button class="dropbtn"><fmt:message key="brand"/></button>
								<div class="dropdown-content">
									<a href="${pageContext.request.contextPath}/controller?command=listCars&brand=audi">Audi</a> <a
										href="${pageContext.request.contextPath}/controller?command=listCars&brand=bmw">BMW</a> <a
										href="${pageContext.request.contextPath}/controller?command=listCars&brand=tesla">Tesla</a>
								</div>
							</div>
							<div class="dropdown">
								<button class="dropbtn"><fmt:message key="qualityClass"/></button>
								<div class="dropdown-content">
									<a href="${pageContext.request.contextPath}/controller?command=listCars&class=elita"><fmt:message key="elit"/></a> <a
										href="${pageContext.request.contextPath}/controller?command=listCars&class=econom"><fmt:message key="econom"/></a> <a
										href="${pageContext.request.contextPath}/controller?command=listCars&class=norm"><fmt:message key="norm"/></a>
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
									<form id="make_order" action="${pageContext.request.contextPath}/controller" method="post">
										<input type="hidden" name="command" value="checkMakeOrder" />

										<div class="card">
											<img
												src="${pageContext.request.contextPath}/img/${cars[i].image}">
											<h2>${cars[i].brand} ${cars[i].model}</h2>
											<p class="price">${cars[i].price}</p>
											<p><fmt:message key="someText"/></p>
											<c:choose>
												<c:when test="${userRole.name == 'admin'}">
													<c:set var="cars" value="${cars}" scope="session" />
													<a href="${pageContext.request.contextPath}/jsp/admin/updateCar.jsp?i=${i}"><fmt:message key="update"/></a>
													<a href="${pageContext.request.contextPath}/controller?command=deleteCar&carId=${cars[i].id}"><fmt:message key="delete"/></a>
												</c:when>
												<c:otherwise>
													<input type="hidden" name="carId" value="${cars[i].id}" />
													<fmt:message key="buy" var = "buy"/>
													<input type="submit" value="${buy}">
												</c:otherwise>
											</c:choose>

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
									<c:if test="${!param.containsKey('command')}">
											<c:param name="command" value="listCars" />
									</c:if>
								</c:url>
								<c:forEach begin="1" end="${count}" var="i">
									<li><a href="${pageContext.request.contextPath}/controller${myURL}page=${i}">${i}</a></li>
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