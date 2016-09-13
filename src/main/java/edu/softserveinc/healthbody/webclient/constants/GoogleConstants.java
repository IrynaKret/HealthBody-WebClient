package edu.softserveinc.healthbody.webclient.constants;

//for GoogleAuthServlet
public class GoogleConstants {

	public static final String CLIENT_ID = "48524677967-juniqolaio06efre3m3q7774097q50u8.apps.googleusercontent.com";
	public static final String CLIENT_SECRET = "KBpMscuWOZc43u-4KKpwbE5T";
	public static final String REDIRECT_URI = "http://healthbody-cliendside.herokuapp.com/GoogleAuthServ";
	public static final String GRANT_TYPE = "authorization_code";
	public static final String TOKEN_URL = "https://accounts.google.com/o/oauth2/token";
	public static final String USERINFO_URL = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
	public static final String DEFAULT_GROUP_NAME = "Name group number 1";
	public static final String DEFAULT_ROLE_NAME = "user";
	public static final String ADMIN_ROLE_NAME = "admin";
	public static final String DEFAULT_USER_DISABLED = "false";
	public static final String GREATING_NOT_REGISTRED = ", wellcome! You've singed up HealthBody!";
	public static final String GREATING_ALREADY_REGISTRED = ", wellcome HealthBody!";
	public static final String SUCSESFULL_REGISTRATION_EMALE = ", <br><br> You just have been registered in Health Body Service "
			+ "<br> Thank you! You can visit your cabinet by this link"
			+ " <a href=http://healthbody-cliendside.herokuapp.com/userCabinet.html>http://healthbody-cliendside.herokuapp.com/userCabinet.html</a>"
			+ "<br><br><br><br>Best regrads, Health Body team";
}