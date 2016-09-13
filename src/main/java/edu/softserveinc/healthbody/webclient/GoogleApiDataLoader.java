package edu.softserveinc.healthbody.webclient;

//import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
//import com.google.api.client.http.javanet.NetHttpTransport;
//import com.google.api.client.json.jackson2.JacksonFactory;

public class GoogleApiDataLoader {
	
	public String getUserData(String token){
		// Setting a start and end date using a range of 1 week before this moment.
//		Calendar cal = Calendar.getInstance();
//		Date now = new Date();
//		cal.setTime(now);
//		long endTime = cal.getTimeInMillis();
//		cal.add(Calendar.WEEK_OF_YEAR, -1);
//		long startTime = cal.getTimeInMillis();
//
//		java.text.DateFormat dateFormat = getDateInstance();
//
//		DataReadRequest readRequest = new DataReadRequest.Builder()
//		        // The data request can specify multiple data types to return, effectively
//		        // combining multiple data queries into one call.
//		        // In this example, it's very unlikely that the request is for several hundred
//		        // datapoints each consisting of a few steps and a timestamp.  The more likely
//		        // scenario is wanting to see how many steps were walked per day, for 7 days.
//		        .aggregate(DataType.TYPE_STEP_COUNT_DELTA, DataType.AGGREGATE_STEP_COUNT_DELTA)
//		                // Analogous to a "Group By" in SQL, defines how data should be aggregated.
//		                // bucketByTime allows for a time span, whereas bucketBySession would allow
//		                // bucketing by "sessions", which would need to be defined in code.
//		        .bucketByTime(1, TimeUnit.DAYS)
//		        .setTimeRange(startTime, endTime, TimeUnit.MILLISECONDS)
//		        .build();
//		
//		GoogleCredential credential = new GoogleCredential().setAccessToken(token);   
//		 Oauth2 oauth2 = new Oauth2.Builder(new NetHttpTransport(), new JacksonFactory(), credential).setApplicationName(
//		          "Oauth2").build();
//		 Userinfoplus userinfo = oauth2.userinfo().get().execute();
//		 userinfo.toPrettyString();
		return "Not implemented yet";
	}

}
