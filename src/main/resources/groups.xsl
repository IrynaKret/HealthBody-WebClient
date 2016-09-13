<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>
<xsl:template match="//ns2:getAllGroupsResponse" xmlns:ns2="http://webservice.healthbody.softserveinc.edu/">
			<html>
				<body>
					<h1>Table of Groups</h1>
					<table border="1">
						<tr>
							<th>Name</th>
							<th>Description</th>
							<th>Count</th>
							<th>Score Group</th>
						</tr>
						<xsl:for-each select="return">
							<tr>
								<td>
									<xsl:value-of select="name" />
								</td>
								<td>
									<xsl:value-of select="descriptions" />
								</td>
								<td>
									<xsl:value-of select="count" />
								</td>
								<td>
									<xsl:value-of select="scoreGroup" />
								</td>
							</tr>
						</xsl:for-each>
					</table>
				</body>
			</html>
		</xsl:template>
</xsl:stylesheet>