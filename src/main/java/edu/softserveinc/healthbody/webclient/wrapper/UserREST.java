package edu.softserveinc.healthbody.webclient.wrapper;

import java.io.IOException;
import java.net.URL;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserREST implements ControllerRESTStrategy{
	
	private int constructor;
	private String nameMethod;
	private int partNumber;
	private int partSize;
	private String login;
	
	
	
	public UserREST(String nameMethod, String login) {
		this.constructor = 1;
		this.nameMethod = nameMethod;
		this.login = login;
	}
	
	
	public UserREST(String nameMethod, int partNumber, int partSize) {
		this.constructor = 2;
		this.nameMethod = nameMethod;
		this.partNumber = partNumber;
		this.partSize = partSize;
	}


	public int getConstructor() {
		return constructor;
	}
	public String getNameMethod() {
		return nameMethod;
	}
	public int getPartNumber() {
		return partNumber;
	}
	public int getPartSize() {
		return partSize;
	}
	public String getLogin() {
		return login;
	}

	@Override
	public URL createRESTRequest() throws IOException {
		URL url;
		if (constructor == 1) {
			url = new URL(BASE_URL + nameMethod + "?login=" + login);
			log.info(url.toString());
			return url;
		} 
		if (constructor == 2) {
			url = new URL(BASE_URL + nameMethod + "?partNumber=" + partNumber + "&partSize=" + partSize);
			log.info(url.toString());
			return url;
		} else {
			log.info("Created unless constructor of " + getClass().getName());
			url = null;
			log.info(url.toString());
			return url;
		}
	}

}
