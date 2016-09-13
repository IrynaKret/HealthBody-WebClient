<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="base-definition">
	<tiles:putAttribute name="body">
	<div class="container">
		<form:form action="createGroup.html" method="POST"
			commandName="groupToCreate">
			<table class="table">
				<tr class="info">
					<td><form:label path="name">Name:</form:label></td>
					<td><form:input path="name" /></td>
					<td><form:errors path="name" class="error" style="color:red;"/></td>
				</tr>
				<tr>
					<td><form:label path="descriptions">Description:</form:label></td>
					<td><textarea name="descriptions" rows="4" cols="50"></textarea></td>
					<td><form:errors path="descriptions" class="error" style="color:red;"/></td>
				</tr>
				<tr>
					<td><form:label path="status">Status:</form:label></td>
					<td><textarea name="status" rows="2" cols="25"></textarea></td>
					<td><form:errors path="status" class="error" style="color:red;"/></td>
				</tr>
				
					<form:label path="count" readonly="true" type="hidden"></form:label>
					<form:input path="count" readonly="true" type="hidden"></form:input>
				
				<tr>
					<td colspan="2" align="left"><input class="btn btn-success"
						type="submit" value="Save" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</tiles:putAttribute>
</tiles:insertDefinition>