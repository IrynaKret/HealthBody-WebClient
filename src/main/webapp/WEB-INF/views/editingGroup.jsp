<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="base-definition">
	<tiles:putAttribute name="body">
		<div class="container">
			<form:form action="editingGroup.html" method="POST"
				commandName="group">
				<table class="table">
					<tr class="info">
						<td><form:label path="idGroup">Edit Group :</form:label></td>
						<td><form:input path="idGroup" readonly="true" name="name"
								type="hidden" value="${group.idGroup}"></form:input>${group.name}</td>
					</tr>
					<tr>
						<td><form:label path="name">Name:</form:label></td>
						<td><form:input path="name"></form:input></td>
						<td><form:errors path="name" class="error" style="color:red;" /></td>
					</tr>
					<tr>
						<td><form:label path="descriptions">Description :</form:label></td>
						<td><textarea name="descriptions" rows="4" cols="50">${group.descriptions}</textarea></td>
						<td><form:errors path="descriptions" class="error"
								style="color:red;" /></td>
					</tr>
					<tr>
						<td><form:label path="count">Users :</form:label></td>
						<td><form:input path="count" readonly="true" name="name"
								type="hidden" value="${group.count}"></form:input>${group.count}</td>
					</tr>
					<tr>
						<td><form:label path="scoreGroup">Score :</form:label></td>
						<td><form:input path="scoreGroup" readonly="true" name="name"
								type="hidden" value="${group.scoreGroup}"></form:input>${group.scoreGroup}</td>
					</tr>
					<tr>
						<td><form:label path="status">Status :</form:label></td>
						<td><form:input path="status" value="${group.status}"></form:input></td>
						<td><form:errors path="status" class="error"
								style="color:red;" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input class="btn btn-success"
							type="submit" value="Save" /></td>
					</tr>
				</table>
			</form:form>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>