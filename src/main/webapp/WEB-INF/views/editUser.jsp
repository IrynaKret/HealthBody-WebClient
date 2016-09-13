<!DOCTYPE html> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="base-definition">
	<tiles:putAttribute name="body">
	<div class="container">
		<form:form action="editUser.html" method="POST"
			commandName="user">
			<table class="table">
				<tr class="info">
					<td><form:label path="login">Login:</form:label></td>
					<td><form:input path="login" disabled="true" /></td>
				</tr>
				<tr class="info">
					<td><form:label path="firstname">Name:</form:label></td>
					<td><form:input path="firstname" /></td>
					<td><form:errors path="firstname" class="error" style="color:red;"/></td>
				</tr>
				<tr class="info">
					<td><form:label path="lastname">SurName</form:label></td>
					<td><form:input path="lastname" /></td>
					<td><form:errors path="lastname" class="error" style="color:red;"/></td>
				</tr>
				<tr class="info">
					<td><form:label path="age">Age</form:label></td>
					<td><form:input path="age" /></td>
					<td><form:errors path="age" class="error" style="color:red;"/></td>
				</tr>
				<tr class="info">
					<td><form:label path="weight">Weight</form:label></td>
					<td><form:input path="weight" /></td>
					<td><form:errors path="weight" class="error" style="color:red;"/></td>
				</tr>
				<tr class="info">
					<td><form:radiobutton path="gender" value="male" />Male</td>
					<td><form:radiobutton path="gender" value="female" />Female</td>
				</tr>
				<tr class="info">
					<td><form:label path="health">Health</form:label></td>
					<td><form:input path="health" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Save" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</tiles:putAttribute>
</tiles:insertDefinition>