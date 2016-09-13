<!DOCTYPE html> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<link rel="icon"
	href="https://d13yacurqjgara.cloudfront.net/users/678458/screenshots/1856046/h-icon.png">
<!-- Bootstrap -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"
	async></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script type="text/javascript" src="resources/js/bootstrap.min.js" async></script>
<!-- bootbox code -->
<script src="resources/js/bootbox.min.js" async></script>
<!-- heartcode-canvasloader code -->
<script src="resources/js/heartcode-canvasloader-min.js" async></script>
<script>
	$(document).on("click", ".confirm", function(e) {
		var cl = new CanvasLoader('canvasloader-container');
		cl.setColor('#6e6ec2');
		cl.setShape('spiral');
		cl.show();

	});
</script>
<tiles:insertDefinition name="base-definition">
	<tiles:putAttribute name="body">
	<div class="container">
		<table class="table">
			<tr class="info">
				<th><a class="btn btn-success" type="submit"
					href="createCompetition.html">Create competition</a></th>
					<th></th>
			</tr>
			<tr class="info" style="height: 62px;">
				<th><a class="confirm btn btn-warning" type="submit"
					href="recountAwards.html">Recount all the awards</a></th>
					<th><div id="canvasloader-container" class="wrapper"></div>
					</th>
			</tr>
		</table>
		<table class="table">
			<tr class="info">
				<th>Name :</th>
				<th>Users Count :</th>
				<th>Start Date :</th>
				<th>Finish Date :</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${getCompetitions}" var="p">
				<tr class="info">
					<td><a
						href="competition.html?idCompetition=${p.idCompetition}&userLogin=${user.login}">${p.name}</a></td>
					<td>${p.count}</td>
					<td>${p.startDate}</td>
					<td>${p.finishDate}</td>
					<td><a class="btn btn-primary" type="submit"
						href="editCompetition.html?idCompetition=${p.idCompetition}">Edit</a></td>
					<td><a class="btn btn-success" type="submit"
						href="listOfGroups.html?idCompetition=${p.idCompetition}">Join/leave groups</a></td>
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