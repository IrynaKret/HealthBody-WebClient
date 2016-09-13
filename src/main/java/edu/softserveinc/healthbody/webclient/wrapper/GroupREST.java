package edu.softserveinc.healthbody.webclient.wrapper;

import java.io.IOException;
import java.net.URL;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GroupREST implements IControllerREST{
	
	private int constructor;
	private String nameMethod;
	private int partNumber;
	private int partSize;
	private String groupName;
	
	
	
	public GroupREST(String nameMethod, String groupName) {
		this.constructor = 1;
		this.nameMethod = nameMethod;
		this.groupName = groupName;
	}

	

	public GroupREST(String nameMethod, int partNumber, int partSize) {
		this.constructor = 2;
		this.nameMethod = nameMethod;
		this.partNumber = partNumber;
		this.partSize = partSize;
	}



	@Override
	public URL createRESTRequest() throws IOException {
		URL url;
		if (constructor == 1) {
			url = new URL(BASE_URL + nameMethod + "?groupName=" + groupName);
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
