package edu.softserveinc.healthbody.webclient;

import edu.softserveinc.healthbody.webclient.healthbody.webservice.GetAllCompetitions;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		GetAllCompetitions com = new GetAllCompetitions();
		com.setArg0(1);
		com.setArg1(10);
	}
}
