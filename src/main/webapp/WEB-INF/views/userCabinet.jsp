<!DOCTYPE html> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="base-definition">
	<tiles:putAttribute name="body">
	<div class="container">
		<div class="row">
			<div class="panel panel-info">
				<div class="panel-body">
					<div class="row">
						<div class="col-md-3 col-lg-3 " align="center">
							<img alt="User Pic" src="${user.photoURL}"
								class="img-circle img-responsive">
						</div>
						<div class=" col-md-9 col-lg-9 ">
							<table class="table table-user-information">
								<tbody>
									<tr>
										<td>Role :</td>
										<td>${user.roleName}</td>
									</tr>
									<tr>
										<td>Name :</td>
										<td>${user.firstname}</td>
									</tr>
									<tr>
										<td>Surname :</td>
										<td>${user.lastname}</td>
									</tr>
									<tr>
										<td>Age :</td>
										<td>${user.age}</td>
									</tr>

									<tr>
									<tr>
										<td>Gender :</td>
										<td>${user.gender}</td>
									</tr>
									<tr>
										<td>Weight :</td>
										<td>${user.weight}</td>
									</tr>
									<tr>
										<td>Email :</td>
										<td>${user.email}</td>
									</tr>
									<tr>
										<td>Health :</td>
										<td>${user.health}</td>
									</tr>
									<tr>
										<td>Steps :</td>
										<td>${steps}</td>
									</tr>
								</tbody>
							</table>
							<a href="editUser.html?userLogin=${user.login}"
								class="btn btn-primary">Edit</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div>
		<div class="container">
			<div class="row">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">Groups :</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<table class="table table-user-information">
								<tr>
									<c:forEach items="${user.groups}" var="p">
										<td><a
											href="group.html?nameGroup=${p.idGroup}&userLogin=${user.login}" style="color: black">${p.name}</a></td>
									</c:forEach>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">Competitions :</h3>
					</div>
					<c:if test="${empty usercompetitions}">
						<div class="panel-body">
							<div class="row">
								<table class="table table-user-information">
									<tr>
										<td align="left">You don't have any competitions yet,
											chose some competition from list <a
											href="listCompetitions.html" > competitions</a>
										</td>
									</tr>
								</table>
							</div>
						</div>
					</c:if>
					<c:if test="${not empty usercompetitions}">
						<div class="panel-body">
							<div class="row">
								<table class="table table-user-information">
									<tr>
										<c:forEach items="${usercompetitions}" var="p">
											<td><a
												href="competition.html?idCompetition=${p.idCompetition}&userLogin=${user.login}" style="color: black">${p.name}</a></td>

										</c:forEach>
									</tr>
								</table>
							</div>
						</div>
					</c:if>
				</div>
			</div>
		</div>
		<br>
	</div>
</tiles:putAttribute>
</tiles:insertDefinition>