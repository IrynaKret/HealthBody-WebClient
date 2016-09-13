<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="base-definition">
	<tiles:putAttribute name="body">

		<script>
		<!--
			function makeCompetitionTable(data) {
				var login = '${login}';
				var trHTML = '<tr class="info"><th>Name of Competition :</th><th>Amount :</th><th>Start Date :</th><th>End Date :</th>';
				$.each(data, function(i, item) {
					trHTML += '<tr><td>'
							+ '<a href="competition.html?idCompetition='
							+ item.idCompetition + '&userLogin=' + login
							+ '" style="color: black">' + item.name + '</a>'
							+ '</td><td>' + item.count + '</td><td>'
							+ item.startDate + '</td><td>' + item.finishDate
							+ '</td></tr>';
				});
				document.getElementById('competitiontable').innerHTML = trHTML;
			}
		
			function getData(jsonURL) {
				$.getJSON(jsonURL, function(data) {
									makeCompetitionTable(data);
								});
			}
		
			function allCompetitions() {
				var url = 'http://ws-healthbody.rhcloud.com/HealthBody-WebService/listener/competitions?partNumber=0&partSize=0';
				getData(url);
			}
		
			function activeCompetitions() {
				var url = 'http://ws-healthbody.rhcloud.com/HealthBody-WebService/listener/activecompetitions?partNumber=0&partSize=0';
				getData(url);
			}

		//-->
		</script>
		<div class="weather" align="center">
			<b>Weather in: </b>${city_name}<br> <img
				src="http://openweathermap.org/img/w/${weather_icon}.png"
				alt="weather_icon" /><br> <b>Temperature: </b>${temp} C<br>
			<b>Humidity: </b>${humidity} %<br> <b>Wind: </b>${wind} m/s<br>
		</div>
		<br>
		<div class="container">
			<ul class="nav nav-tabs">
				<li class="active"><a data-toggle="tab"
					onclick="activeCompetitions()">Active Competitions</a></li>
				<li><a data-toggle="tab" onclick="allCompetitions()"> All
						Competitions</a></li>
			</ul>
			<table class="table table-hover" id="competitiontable">
				<tr class="info">
					<th>Name of Competition</th>
					<th>Amount</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>Take part</th>
				</tr>
				<c:forEach items="${getAllComp}" var="comp">
					<tr class="info">
						<c:set var="check" value="false" />
						<td>${comp.name}</td>
						<td>${comp.count}</td>
						<td>${comp.startDate}</td>
						<td>${comp.finishDate}</td>
						<td><a
							href="check_take_part.html?idCompetition=${comp.idCompetition}&userLogin=${login}">
								<c:forEach items="${getAllCompTakePart}" var="t">
									<c:if test="${t.idCompetition == comp.idCompetition}">
										<c:set var="check" value="true" />
									</c:if>
								</c:forEach> <c:choose>
									<c:when test="${check}"> 	
						    		Get out						    	
				    			</c:when>
									<c:otherwise>						    	
							    	Take part					    	
							    </c:otherwise>
								</c:choose>
						</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="container" align="center">
			<ul class="pagination">

				<%--For displaying Previous link --%>
				<li><c:if test="${currentPage != 1}">
						<a
							href="<c:url value="/main.html" >
        <c:param name="partNumber" value="${currentPage - 1}"/>${p}</c:url>">«</a>
					</c:if></li>

				<%--For displaying Page numbers --%>
				<li><c:forEach begin="${startPartNumber}"
						end="${lastPartNumber}" var="p">
						<a
							href="<c:url value="/main.html" >
        <c:param name="partNumber" value="${p}"/>${p}</c:url>">${p}</a>
					</c:forEach></li>

				<%--For displaying Next link --%>
				<li><c:if test="${currentPage lt lastPartNumber}">
						<a
							href="<c:url value="/main.html" >
        <c:param name="partNumber" value="${currentPage + 1}"/>${p}</c:url>">»</a>
					</c:if></li>
			</ul>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>