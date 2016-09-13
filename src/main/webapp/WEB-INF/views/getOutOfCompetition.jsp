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
				<th>Description :</th>
				<th>StartDate :</th>
				<th>FinishDate :</th>
			</tr>
			<tr>
				<td>${getCompetition.name}</td>
				<td>${getCompetition.description}</td>
				<td>${getCompetition.startDate}</td>
				<td>${getCompetition.finishDate}</td>
				<td><a class="confirm btn btn-primary" type="submit"
					href="getOutOfCompetition.html?idCompetition=${getCompetition.idCompetition}&userLogin=${login}">
					Get out of competition
					</a>
				</td>
			</tr>
		</table>
	</div>
</tiles:putAttribute>
</tiles:insertDefinition>