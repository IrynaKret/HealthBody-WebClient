<!DOCTYPE html> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="base-definition">
	<tiles:putAttribute name="body">
	<div class="container">
		<table class="table">
			<tr class="info">
				<th>Name:</th>
				<th>Status:</th>
				<th>Participants:</th>
			</tr>
			<tr>
				<c:forEach items="${groups}" var="p" >
				<tr>
					<td>
						<a href="group.html?nameGroup=${p.idGroup}&userLogin=${user.login}">${p.name}</a><br><br>
							<td>
								${p.status}<br><br>
							<td/>
						 <c:forEach  begin="0" end="${fn:length(p.users)}" var="index">
								<c:out value="${p.users[index]}" /><br>
								<c:out value="${p.firstname[index]}" /><br>
								<c:out value="${p.lastname[index]}" /><br><br>
						</c:forEach>		
					<td/>        
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
						href="<c:url value="/listGroups.html" >
        <c:param name="groupsParticipantsPartnumber" value="${currentPage - 1}"/>${p}</c:url>">«</a>
				</c:if></li>

			<%--For displaying Page numbers --%>
			<li><c:forEach begin="${startPartNumber}"
					end="${lastpagePartNumber}" var="p">
					<a
						href="<c:url value="/listGroups.html" >
        <c:param name="groupsParticipantsPartnumber" value="${p}"/>${p}</c:url>">${p}</a>
				</c:forEach></li>

			<%--For displaying Next link --%>
			<li><c:if test="${currentPage lt lastpagePartNumber}">
					<a
						href="<c:url value="/listGroups.html" >
        <c:param name="groupsParticipantsPartnumber" value="${currentPage + 1}"/>${p}</c:url>">»</a>
				</c:if></li>
		</ul>
	</div>
</tiles:putAttribute>
</tiles:insertDefinition>