<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<link rel="icon"
	href="https://d13yacurqjgara.cloudfront.net/users/678458/screenshots/1856046/h-icon.png">
<link rel="stylesheet" type="text/css" href="resources/css/jquery-ui.css">
<!-- Bootstrap -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"
	async></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script type="text/javascript" src="resources/js/bootstrap.min.js" async></script>
<script type="text/javascript" src="resources/js/jquery-ui.js"></script>
<script>
	$(function() {
		$('.my-datepicker').datepicker({
			dateFormat : 'yy-mm-dd'
		});
	});
</script>
<tiles:insertDefinition name="base-definition">
	<tiles:putAttribute name="body">
	<div class="container">
		<form:form action="editCompetition.html" method="POST"
			commandName="competitionToEdit">
			<table class="table">
				<tr class="info">
					<td><form:input path="idCompetition" readonly="true" type="hidden" value="${competitionToEdit.idCompetition}" /></td>
					<td></td>
					<td></td>
				</tr>
				<tr class="info">
					<td><form:label path="name">Name:</form:label></td>
					<td><form:input path="name"
							value="${competitionToEdit.name}" /></td>
					<td><form:errors path="name" class="error" style="color:red;"/></td>
				</tr>
				<tr class="info">
					<td><form:label path="description">Description:</form:label></td>
					<td><textarea name="description" rows="4" cols="50">${competitionToEdit.description}</textarea></td>
					<td><form:errors path="description" class="error" style="color:red;"/></td>
				</tr>
				<tr class="info">
					<td><form:label path="startDate">Start Date:</form:label></td>
					<td><form:input path="startDate" type="text"
							class="my-datepicker" size="30" /></td>
					<td><form:errors path="startDate" class="error" style="color:red;"/></td>
				</tr>
				<tr class="info">
					<td><form:label path="finishDate">Finish Date:</form:label></td>
					<td><form:input path="finishDate" type="text"
							class="my-datepicker" size="30" /></td>
					<td><form:errors path="finishDate" class="error" style="color:red;"/></td>
				</tr>
				<tr>
					<td colspan="2" align="left"><input class="btn btn-success"
						type="submit" value="Save" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</tiles:putAttribute>
</tiles:insertDefinition>