package edu.softserveinc.healthbody.webclient.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="statistics")
public class Statistics implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "userlogin", nullable = false)
	private String userLogin;
	
	@Column(name = "logindate", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date loginDate;
	
	@Column(name = "logoutdate", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date logoutDate;
	
	public Statistics() {
		
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUserLogin() {
		return userLogin;
	}
	
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	
	public Date getLoginDate() {
		return loginDate;
	}
	
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	
	public Date getLogoutDate() {
		return logoutDate;
	}
		
	public void setLogoutDate(Date logoutDate) {
		this.logoutDate = logoutDate;
	}
}
