<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
    // Load the Visualization API and the piechart package.
    google.load('visualization', '1', {
    	'packages':['columnchart','corechart']
    });
 
    // Set a callback to run when the Google Visualization API is loaded.
    google.setOnLoadCallback(drawChart);
 
    // Callback that creates and populates a data table,
    // instantiates the pie chart, passes in the data and
    // draws it.
    function drawChart() {
 
        // Create the data table.
        var data = google.visualization.arrayToDataTable([
                                                          ['Login', 'Duration(minutes)'],
                                                          <c:forEach items="${userDurationOnApp}" var="entry">
                                                          ['${entry.key}', ${entry.value}],
                                                          </c:forEach>
                                                          ]);
        // Set chart options
        var options = {
            'title' : 'The most active users',
            is3D : true,
            pieSliceText: 'label',
            tooltip :  {showColorCode: true},
            'width' : 1200,
            'height' : 700
        };
 
        // Instantiate and draw our chart, passing in some options.
        var chart1 = new google.visualization.PieChart(document.getElementById('chart_div'));
        var chart2 = new google.visualization.ColumnChart (document.getElementById('chart'));
        chart1.draw(data, options);
        chart2.draw(data, options);
    }
</script>
<tiles:insertDefinition name="base-definition">
	<tiles:putAttribute name="body">
		<div id="chart_div"></div>
		<div id="chart"></div>
</tiles:putAttribute>
</tiles:insertDefinition>