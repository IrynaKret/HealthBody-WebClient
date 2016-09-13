package edu.softserveinc.healthbody.webclient.wrapperD;

public class URLEnumForConnectionToService { 

	public enum Users{
		GET_USER_BY_LOGIN("%s/HealthBody-WebService/listener/%s?login=%s"),
		UPDATE_USER_DTO("%s/HealthBody-WebService/listener/UpdateUser"),
		GET_USERS_PART_NUMBER_PART_SIZE("%s/HealthBody-WebService/listener/%s?partNumber=%d&partSize=%d");		
		
		private String urlForConnetionToListener;

		private Users(String urlForConnetionToListener) {
			this.urlForConnetionToListener = urlForConnetionToListener;
		}

		public String getUrlForConnetionToListener() {
			return urlForConnetionToListener;
		}

	}
	
	public enum Groups{
		GET_GROUP_DESCRIPTION("%s/HealthBody-WebService/listener/%s?groupName=%s"),
		GET_GROUPS_PART_NUMBER_PART_SIZE("%s/HealthBody-WebService/listener/%s?partNumber=%d&partSize=%d");
		
		private String urlForConnetionToListener;

		private Groups(String urlForConnetionToListener) {
			this.urlForConnetionToListener = urlForConnetionToListener;
		}

		public String getUrlForConnetionToListener() {
			return urlForConnetionToListener;
		}

	}

	public enum Competitions{
		GET_COMPETITION_DESCRIPTION("%s/HealthBody-WebService/listener/%s?competitionName=%s"),
		GET_COMPETITIONS_PART_NUMBER_PART_SIZE("%s/HealthBody-WebService/listener/%s?partNumber=%d&partSize=%d"),
		GET_COMPETITIONS_PART_NUMBER_PART_SIZE_LOGIN("%s/HealthBody-WebService/listener/%s?partNumber=%d&partSize=%d&login=%s");
		
		private String urlForConnetionToListener;

		private Competitions(String urlForConnetionToListener) {
			this.urlForConnetionToListener = urlForConnetionToListener;
		}

		public String getUrlForConnetionToListener() {
			return urlForConnetionToListener;
		}

	} 
}