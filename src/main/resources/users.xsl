<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>
<xsl:template match="//ns2:getAllUsersResponse" xmlns:ns2="http://webservice.healthbody.softserveinc.edu/">
			<html>
				<body>
					<h1>Table of Users</h1>
					<table border="1">
						<tr>
							<th>Login</th>
							<th>FirstName</th>
							<th>LastName</th>
							<th>Age</th>
							<th>E-mail</th>
							<th>Role</th>
							<th>Weight</th>
							<th>Gender</th>
						</tr>
						<xsl:for-each select="return">
						<tr>
							<td>
								<xsl:value-of select="login" />
							</td>
							<td>
								<xsl:value-of select="firstname" />
							</td>
							<td>
								<xsl:value-of select="lastname" />
							</td>
							<td>
								<xsl:value-of select="age" />
							</td>
							<td>
								<xsl:value-of select="email" />
							</td>
							<td>
								<xsl:value-of select="roleName" />
							</td>
							<td>
								<xsl:value-of select="weight" />
							</td>
							<td>
								<xsl:value-of select="gender" />
							</td>
						</tr>
						</xsl:for-each>
					</table>
				</body>
			</html>
		</xsl:template>
</xsl:stylesheet>