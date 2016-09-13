package edu.softserveinc.healthbody.webclient.wrapper;

import java.io.IOException;

public class TestRESTConnection {
	
	public static void main(String[] args) throws IOException {
//		HttpURLConnectionREST.getInstance().sendGet(new CompettionREST("allComp", 1, 3));
//		HttpURLConnectionREST.getInstance().sendGet(new CompettionREST("activeUComp", 1, 2, "Login%201"));
//		HttpURLConnectionREST.getInstance().sendGet(new UserREST("UByLogin", "Login%206"));
//		HttpURLConnectionREST.getInstance().sendGet(new UserREST("UWithNoComp", 1, 2));
//		HttpURLConnectionREST.getInstance().sendGet(new UserREST("allUInGroup", 1, 2));
//		HttpURLConnectionREST.getInstance().sendGet(new GroupREST("groupDescr", "Name%20group%20number%201"));
		HttpURLConnectionREST.getInstance().sendGet(new GroupREST("allGroups", 1, 3));
	}

}
