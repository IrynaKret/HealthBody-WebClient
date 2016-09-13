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
				<th>Name :</th>
				<th>Users Count :</th>
				<th>Start Date :</th>
				<th>Finish Date :</th>
			</tr>
			<c:forEach items="${getCompetitions}" var="p">
				<tr class="info">
					<td><a
						href="competition.html?idCompetition=${p.idCompetition}&userLogin=${user.login}">${p.name}</a></td>
					<td>${p.count}</td>
					<td>${p.startDate}</td>
					<td>${p.finishDate}</td>
				</tr>
			</c:forEach>
		</table>

	</div>

	<div class="container" align="center">
		<ul class="pagination">

			<%--For displaying Previous link --%>
			<li><c:if test="${currentPage > 1}">
					<a
						href="<c:url value="/listCompetitions.html" >
        <c:param name="partNumber" value="${currentPage - 1}"/>${p}</c:url>">«</a>
				</c:if></li>

			<%--For displaying Page numbers --%>
			<li><c:forEach begin="${startPartNumber}"
					end="${lastPartNumber}" var="p">
					<a
						href="<c:url value="/listCompetitions.html" >
        <c:param name="partNumber" value="${p}"/>${p}</c:url>">${p}</a>
				</c:forEach></li>

			<%--For displaying Next link --%>
			<li><c:if test="${currentPage < lastPartNumber}">
					<a
						href="<c:url value="/listCompetitions.html" >
        <c:param name="partNumber" value="${currentPage + 1}"/>${p}</c:url>">»</a>
				</c:if></li>
		</ul>
	</div>
</tiles:putAttribute>
</tiles:insertDefinition>