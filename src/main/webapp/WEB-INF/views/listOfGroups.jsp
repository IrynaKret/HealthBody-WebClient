<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<script>
	$(document).on("click", ".alert", function(e) {
		var link = $(this).attr("href");
		e.preventDefault();
        bootbox.confirm("Are you sure?", function(result){ 
				if (result) {
					document.location.href = link;
				} else {
				}
		});
    });
</script>

<tiles:insertDefinition name="base-definition">
	<tiles:putAttribute name="body">
		<div class="container">
			<table class="table">
				<tr class="info">
					<th>Name:</th>
					<th>Status:</th>
					<th></th>
				</tr>
				<tr>
					<c:forEach items="${groups}" var="p">
						<tr class="info">
							<c:set var="check" value="false" />
							<td><a
								href="group.html?nameGroup=${p.idGroup}&userLogin=${user.login}">${p.name}</a>
							</td>
							<td>${p.status}</td>
							<td>
								<c:forEach items="${groupcompetitions}" var="t">
									<c:if test="${t.idGroup == p.idGroup}">
										<c:set var="check" value="true" />
									</c:if>
								</c:forEach>
								<c:choose>
									<c:when test="${check}">
										<a class="alert btn btn-primary" style="height: 34px; margin-bottom: 0; padding: 6px 12px; vertical-align: middle;"
											href="leaveGroupCompetition.html?idGroup=${p.idGroup}&idCompetition=${getCompetition.idCompetition}">Leave
											group from competition</a>
									</c:when>
									<c:otherwise>
										<a class="btn btn-success" type="submit"
											href="joinGroupCompetition.html?idGroup=${p.idGroup}&idCompetition=${getCompetition.idCompetition}">Join
											group to competition</a>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</tr>
			</table>
		</div>
		<div class="container" align="center">
			<ul class="pagination">

				<%--For displaying Previous link --%>
				<li><c:if test="${currentPage > 1}">
						<a
							href="<c:url value="/listOfGroups.html?idCompetition=${getCompetition.idCompetition}" >
        <c:param name="partNumber" value="${currentPage - 1}"/>${p}</c:url>">«</a>
					</c:if></li>

				<%--For displaying Page numbers --%>
				<li><c:forEach begin="${startPartNumber}"
						end="${lastPartNumber}" var="p">
						<a
							href="<c:url value="/listOfGroups.html?idCompetition=${getCompetition.idCompetition}" >
        <c:param name="partNumber" value="${p}"/>${p}</c:url>">${p}</a>
					</c:forEach></li>

				<%--For displaying Next link --%>
				<li><c:if test="${currentPage < lastPartNumber}">
						<a
							href="<c:url value="/listOfGroups.html?idCompetition=${getCompetition.idCompetition}" >
        <c:param name="partNumber" value="${currentPage + 1}"/>${p}</c:url>">»</a>
					</c:if></li>
			</ul>
		</div>

	</tiles:putAttribute>
</tiles:insertDefinition>