package edu.softserveinc.healthbody.webclient.dto;

import java.util.Date;

public class StatisticsDTO {
	
	private String id;
	private String userLogin;
	private Date loginDate;
	private Date logoutDate;
	
	public StatisticsDTO() {
		
	}
	
	public StatisticsDTO(String id, String userLogin, Date loginDate, Date logoutDate) {
		this.id = id;
		this.userLogin = userLogin;
		this.loginDate = loginDate;
		this.logoutDate = logoutDate;
	}

	public String getId() {
		return id;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public Date getLogoutDate() {
		return logoutDate;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public void setLogoutDate(Date logoutDate) {
		this.logoutDate = logoutDate;
	}
}
