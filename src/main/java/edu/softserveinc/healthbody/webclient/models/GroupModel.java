package edu.softserveinc.healthbody.webclient.models;

public class GroupModel {

	private String idGroup;
	private String name;
	private int count;
	private String descriptions;
	private int scoreGroup;
	
	//getters
	public String getIdGroup() {
		return idGroup;
	}
	public String getName() {
		return name;
	}
	public int getCount() {
		return count;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public int getScoreGroup() {
		return scoreGroup;
	}
	
	//setters
	public void setIdGroup(String idGroup) {
		this.idGroup = idGroup;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	public void setScoreGroup(int scoreGroup) {
		this.scoreGroup = scoreGroup;
	}
}
