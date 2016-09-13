package edu.softserveinc.healthbody.webclient.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import edu.softserveinc.healthbody.webclient.constants.GoogleConstants;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GoogleFitUtils {
	/**
	 * Make Post call to Google Fit
	 **/
	public static String post(String access_token, Long startTimeMillis, Long endTimeMillis) {
		String data = "";
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost("https://www.googleapis.com/fitness/v1/users/me/dataset:aggregate");
		String param = "{\"aggregateBy\":[{\"dataTypeName\": \"com.google.step_count.delta\","
				+ "\"dataSourceId\": \"derived:com.google.step_count.delta:com.google.android.gms:estimated_steps\"}],"
				+ "\"bucketByTime\": { \"durationMillis\": 888888888886400000 },\"startTimeMillis\":" + startTimeMillis
				+ ",\"endTimeMillis\":" + endTimeMillis + "}";
		StringEntity entity = new StringEntity(param, "UTF-8");
		request.setEntity(entity);
		request.addHeader("Content-type", "application/json");
		request.addHeader("Accept", "application/json");
		request.addHeader("Authorization", "Bearer " + access_token);
		try {
			HttpResponse response = httpClient.execute(request);

			log.info("Code :" + response.getStatusLine().getStatusCode());
			if (response.getStatusLine().getStatusCode() != 200) {
				data = "empty";
			} else {
				InputStream body = response.getEntity().getContent();
				BufferedReader in = new BufferedReader(new InputStreamReader(body));
				String line;
				String fitData = "";
				while ((line = in.readLine()) != null) {
					fitData += line;
				}
				data = fitData;
			}
		} catch (IOException e) {
			log.error("IOException catched ", e);
		}
		return data;
	}

	/**
	 * Make Post call for getting new access token by refresh token
	 * 
	 **/
	public static String postForAccessToken(String refreshToken) {
		String urlParameters = "&client_id=" + GoogleConstants.CLIENT_ID + "&client_secret="
				+ GoogleConstants.CLIENT_SECRET + "&refresh_token=" + refreshToken + "&grant_type=refresh_token";
		String token = "";
		StringBuffer response = new StringBuffer();
		try {
			URL url = new URL("https://www.googleapis.com/oauth2/v4/token");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			// Send post request
			conn.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			int responseCode = conn.getResponseCode();
			log.info("Sending 'POST' request to URL : " + url);
			log.info("Post parameters : " + urlParameters);
			log.info("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			JsonObject json = new JsonParser().parse(response.toString()).getAsJsonObject();
			token = json.get("access_token").getAsString();
			log.info("New Access Token : " + token);
		} catch (IOException e) {
			log.error("Bad request , no access token returned");
		}
		return token;
	}

	/**
	 * Get Step value from response JSON parameter fitData represents JSON
	 **/
	public static String getStepCount(String fitData) {
		String stepCount = "0";
		if ("empty".equals(fitData)) {
			log.info("You don't have steps , we will set your step count \"0\"");
		} else {
			log.info(fitData);
			JSONObject googleSteps = new JSONObject(fitData);
			if (googleSteps.isNull("bucket")) {
				log.info("Sorry your info about steps is empty");
			} else {
				try {
					stepCount = googleSteps.getJSONArray("bucket").getJSONObject(0).getJSONArray("dataset")
							.getJSONObject(0).getJSONArray("point").getJSONObject(0).getJSONArray("value")
							.getJSONObject(0).get("intVal").toString();
				} catch (JSONException e) {
					stepCount = "0";
				}
			}
		}
		log.info("Your steps count :" + stepCount);
		return stepCount;

	}
}
