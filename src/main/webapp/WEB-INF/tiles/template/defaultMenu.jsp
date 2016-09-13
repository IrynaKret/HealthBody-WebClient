<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar">1</span> <span class="icon-bar">2</span> <span
					class="icon-bar">3</span>
			</button>
			<a class="navbar-brand" href="main.html">Health Body</a>
			<ul class="nav navbar-nav">
				<li><a href="userCabinet.html">${pageContext.request.userPrincipal.name}</a></li>
				<li><a href="userlist.html">Users</a></li>
				<li class="dropdown">
				        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Groups
				        <span class="caret"></span></a>
				        <ul class="dropdown-menu">
				          <li><a href="allGroups.html">All Groups</a></li>
				          <li><a href="listGroups.html">Groups with participants</a></li>
				        </ul>
				 </li>
				
				<li><a href="listCompetitions.html">Competitions</a></li>
				<li><a href="pieChart.html">Statistics</a></li>
			</ul>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<form class="navbar-form navbar-right" role="form">
				<a class="btn btn-success" type="submit" href="logout.html">Sign
					out</a>
			</form>
		</div>
	</div>
	</nav>
	<br>
	<br>
	<br>
	<br>