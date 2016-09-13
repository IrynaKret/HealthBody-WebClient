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
					<div class="panel-heading">
						<h3 class="panel-title">Group</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-3 col-lg-3 " align="center">
								<img alt="User Pic" src="resources/img/group.png"
									class="img-circle img-responsive">
							</div>
							<div class=" col-md-9 col-lg-9 ">
								<table class="table table-user-information">
									<tbody>
										<tr>
											<td>Name :</td>
											<td>${group.name}</td>
										</tr>
										<tr>
											<td>Description :</td>
											<td>${group.descriptions}</td>
										</tr>
										<tr>
											<td>Users :</td>
											<td>${group.count}</td>
										</tr>
										<tr>
											<td>Score :</td>
											<td>${group.scoreGroup}</td>
										</tr>
										<tr>
											<td>Status :</td>
											<td>${group.status}</td>
										</tr>
										<tr>
											<td colspan="2" align="left"><a class="btn btn-primary"
												type="submit" href="listGroups.html">Groups</a></td>
										</tr>
									</tbody>
									<c:if test="${user.roleName == 'admin'}">
										<tr>
											<td colspan="2" align="left"><a class="btn btn-primary"
												type="submit"
												href="editGroupDescription.html?nameGroup=${group.idGroup}">Edit</a>&nbsp;
												&nbsp;<a class="btn btn-primary" type="submit"
												href="createGroup.html"> Create Groups</a></td>
										</tr>
									</c:if>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>