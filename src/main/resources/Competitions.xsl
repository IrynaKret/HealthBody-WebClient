<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>
	<xsl:template match="//ns2:getAllCompetitionsResponse" xmlns:ns2="http://webservice.healthbody.softserveinc.edu/">
	  <html>
	  <head>
	  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"/>
	  </head>
	  <body>
	  <h2>List of competitions</h2>
	  <table class="table table-bordered table-hover">
	    <tr>
	      <th>Name</th>
	      <th>Description</th>
	      <th>Start date</th>
	      <th>Finish date</th>
	      <th>Participants count</th>
	    </tr>
	    <xsl:for-each select="return">
	    <tr>
	      <td><xsl:value-of select="name"/></td>
	      <td><xsl:value-of select="description"/></td>
	      <td><xsl:value-of select="startDate"/></td>
	      <td><xsl:value-of select="finishDate"/></td>
	      <td><xsl:value-of select="count"/></td>
	    </tr>
	    </xsl:for-each>
	  </table>
	  </body>
	  </html>
	</xsl:template>
</xsl:stylesheet>