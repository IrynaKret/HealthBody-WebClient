
package edu.softserveinc.healthbody.webclient.wrapperD;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class URLFormatter {

	private static final String BASE_URL_LOCAL_HOST = "http://localhost:8080";




	public URL getUsersByPartnumberPartsize(String methodName, Integer partNumber, Integer partSize)
			throws MalformedURLException {
			Formatter formatter = new Formatter();
				URL urlGetUsersByPartnumberPartsize = 
						new URL(formatter.format(URLEnumForConnectionToService
						 		 	.Users
						 		 	.GET_USERS_PART_NUMBER_PART_SIZE
						 		 	.getUrlForConnetionToListener(),BASE_URL_LOCAL_HOST, methodName, partNumber, partSize)
						 		 	.toString());
				formatter.close();
		return urlGetUsersByPartnumberPartsize;
	}

//========================================================================================================================================================//
	
	/** URL formatter for Users
	 * @throws IOException */	
	public void updateUser(UserDTORest userDTORest) throws IOException{
		Formatter formatter = new Formatter();
				URL updateUser = new URL(formatter.format(URLEnumForConnectionToService
						 		 	.Users
						 		 	.UPDATE_USER_DTO
						 		 	.getUrlForConnetionToListener(),BASE_URL_LOCAL_HOST)
						 		 	.toString());
				Gson gson = new Gson();
				String json = gson.toJson(userDTORest);
				RestConnector.getInstance().sendRequestPOST(updateUser, json);
				formatter.close();
	}

//========================================================================================================================================================//
	/** URL formatter for Groups. 
	 * @throws IOException, JsonParseException, JsonMappingException */
	public UserDTORest getUserByLogin(String methodName, String login) throws IOException {
		Formatter formatter = new Formatter();
				URL urlGetUserByLogin = 
						new URL(formatter.format(URLEnumForConnectionToService
							     	.Users
							     	.GET_USER_BY_LOGIN
							     	.getUrlForConnetionToListener(),BASE_URL_LOCAL_HOST, methodName, login)
								 	.toString());
				JsonElement jsonElement = RestConnector.getInstance().sendRequestGetGetAsJsonElement(urlGetUserByLogin);
				Gson gson = new Gson();
				String jsonElementTostring = jsonElement.toString();
				UserDTORest userDTORest = gson.fromJson(jsonElementTostring, UserDTORest.class);
				formatter.close();
		return userDTORest;
	}

//========================================================================================================================================================//		
	/** URL formatter for Groups. With help of Jackson 2.0.
	 * @throws IOException */
	public List<GroupDTORest> getGroupsByPartnumberPartsize(String methodName, Integer partNumber, Integer partSize) 
			throws IOException{	
		Formatter formatter = new Formatter();
				URL urlGetGroupsByPartnumberPartsize = 
						new URL(formatter.format(URLEnumForConnectionToService
									 	.Groups
									 	.GET_GROUPS_PART_NUMBER_PART_SIZE
									 	.getUrlForConnetionToListener(),BASE_URL_LOCAL_HOST, methodName, partNumber, partSize)
				  					 	.toString()); 
				
			JsonArray jsonArray = RestConnector.getInstance().sendRequestGetAsJsonArray(urlGetGroupsByPartnumberPartsize);
			ObjectMapper mapper = new ObjectMapper();			
			List<GroupDTORest> listGroupDTORest = new ArrayList<>();
				for (int i = 0; i < jsonArray.size(); i++) {
					listGroupDTORest.add(mapper.readValue(jsonArray.get(i).toString(), GroupDTORest.class));
				}
			
				formatter.close();
			return listGroupDTORest;
			
	}
//========================================================================================================================================================//		
	
	public URL getGroupDescription(String methodName, String groupName) throws MalformedURLException{	
		Formatter formatter = new Formatter();
		URL urlGetGroupDescription = 
				new URL(formatter.format(URLEnumForConnectionToService
								 .Groups
								 .GET_GROUP_DESCRIPTION
								 .getUrlForConnetionToListener(),BASE_URL_LOCAL_HOST, methodName, groupName)
								 .toString());
				
	formatter.close();
		return urlGetGroupDescription; 
	}

	/** URL formatter for Competitions*/	
	public URL getCompetitionsByPartnumberPartsize(String methodName, Integer partNumber, Integer partSize) 
			throws MalformedURLException{
		Formatter formatter = new Formatter();
				URL urlGetCompetitionsByPartnumberPartsize = 
						new URL(formatter.format(URLEnumForConnectionToService
										 .Competitions
										 .GET_COMPETITIONS_PART_NUMBER_PART_SIZE
										 .getUrlForConnetionToListener(),BASE_URL_LOCAL_HOST, methodName, partNumber, partSize)
									     .toString());
				formatter.close();
		return urlGetCompetitionsByPartnumberPartsize; 
	}
	
	public URL getCompetitionsByPartNumberPartSizeLogin(String methodName, Integer partNumber, Integer partSize, String login) 
			throws MalformedURLException{
		Formatter formatter = new Formatter();
			URL urlGetCompetitionsByPartNumberPartSizeLogin = 
					new URL(formatter.format(URLEnumForConnectionToService
									 .Competitions
									 .GET_COMPETITIONS_PART_NUMBER_PART_SIZE_LOGIN
									 .getUrlForConnetionToListener(),BASE_URL_LOCAL_HOST, methodName, partNumber, partSize, login)
									 .toString());
			formatter.close();
		return urlGetCompetitionsByPartNumberPartSizeLogin;
	}
	
	public URL getCompetitionsDescription(String competitionName) throws MalformedURLException{
		Formatter formatter = new Formatter();
		URL urlGetCompetitionsDescription = 
				new URL(formatter.format(URLEnumForConnectionToService
								 .Competitions
								 .GET_COMPETITION_DESCRIPTION
								 .getUrlForConnetionToListener(),BASE_URL_LOCAL_HOST, competitionName)
								 .toString());
		formatter.close();
		return urlGetCompetitionsDescription;
	}
}
