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
					<td>${getCompetition.name}</td>
				</tr>
				<tr class="info">
					<th>Description :</th>
					<td>${getCompetition.description}</td>
				</tr>
				<tr class="info">
					<th>Start Date :</th>
					<td>${getCompetition.startDate}</td>
				</tr>
				<tr class="info">
					<th>Finish Date :</th>
					<td>${getCompetition.finishDate}</td>
				</tr>
			</table>
		</div>
		<div class="container">
			<div class="row">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">Groups :</h3>
					</div>
					<c:if test="${empty groupcompetitions}">
						<div class="panel-body">
							<div class="row">
								<table class="table table-user-information">
									<tr>
										<td align="left">There are no groups in this competition yet,
											chose some competition from list <a
											href="listOfGroups.html?idCompetition=${getCompetition.idCompetition}"> groups</a>
										</td>
									</tr>
								</table>
							</div>
						</div>
					</c:if>
					<c:if test="${not empty groupcompetitions}">
						<div class="panel-body">
							<div class="row">
								<table class="table table-user-information">
									<tr>
										<c:forEach items="${groupcompetitions}" var="p">
											<td><a
											href="group.html?nameGroup=${p.idGroup}&userLogin=${user.login}" style="color: black">${p.name}</a></td>
										</c:forEach>
									</tr>
								</table>
							</div>
						</div>
					</c:if>
				</div>
			</div>
		</div>
		<div class="container">
			<table class="table">
				<tr>
					<td><a class="btn btn-success" type="submit"
						href="joinCompetition.html?idCompetition=${getCompetition.idCompetition}&userLogin=${user.login}">Join
							Competition</a></td>
				</tr>
			</table>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>