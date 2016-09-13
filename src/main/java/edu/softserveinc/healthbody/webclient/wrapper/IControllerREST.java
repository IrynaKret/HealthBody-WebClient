package edu.softserveinc.healthbody.webclient.wrapper;

import java.io.IOException;
import java.net.URL;

public interface IControllerREST {
	
	public static String BASE_URL = "http://localhost:8080/HealthBody-WebService/listener/";

	URL createRESTRequest() throws IOException;
}
