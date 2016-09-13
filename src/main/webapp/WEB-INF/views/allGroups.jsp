<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="base-definition">
	<tiles:putAttribute name="body">
		<div class="container">
			<table class="table">
				<tr class="info">
					<th>Name:</th>
					<th>Users :</th>
					<th>Score :</th>
					<th>Status :</th>
				</tr>
				<tr>
					<c:forEach items="${groups}" var="p">
						<tr>
							<td><a
								href="group.html?nameGroup=${p.idGroup}&userLogin=${user.login}">${p.name}</a>
							</td>
							<td>${p.count}</td>
							<td>${p.scoreGroup}</td>
							<td>${p.status}</td>
						</tr>
					</c:forEach>
				</tr>
			</table>
		</div>

		<div class="container" align="center">
			<ul class="pagination">

				<%--For displaying Previous link --%>
				<li><c:if test="${currentPage != 1}">
						<a
							href="<c:url value="/allGroups.html" >
        <c:param name="groupsPartnumber" value="${currentPage - 1}"/>${p}</c:url>">«</a>
					</c:if></li>

				<%--For displaying Page numbers --%>
				<li><c:forEach begin="${startPartNumber}"
						end="${lastpagePartNumber}" var="p">
						<a
							href="<c:url value="/allGroups.html" >
        <c:param name="groupsPartnumber" value="${p}"/>${p}</c:url>">${p}</a>
					</c:forEach></li>

				<%--For displaying Next link --%>
				<li><c:if test="${currentPage lt lastpagePartNumber}">
						<a
							href="<c:url value="/allGroups.html" >
        <c:param name="groupsPartnumber" value="${currentPage + 1}"/>${p}</c:url>">»</a>
					</c:if></li>
			</ul>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>