/*package edu.softserveinc.healthbody.webclient.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import edu.softserveinc.healthbody.webclient.api.GroupDTO;
import edu.softserveinc.healthbody.webclient.api.HealthBodyService;
import edu.softserveinc.healthbody.webclient.api.HealthBodyServiceImplService;
import edu.softserveinc.healthbody.webclient.api.UserDTO;
import edu.softserveinc.healthbody.webclient.constants.GoogleConstants;
import edu.softserveinc.healthbody.webclient.servlets.GoogleUser;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class GoogleOAuthAuthenticationProvider implements AuthenticationProvider {

	@Override
	public org.springframework.security.core.Authentication authenticate(
			org.springframework.security.core.Authentication authentication) throws AuthenticationException {
		String rn = System.lineSeparator();
		OutputStreamWriter writer = null;
		BufferedReader reader = null;
		String code = authentication.getCredentials().toString();
		try {
			// get code
			// format parameters to post
			String urlParameters = "code=" + code + "&client_id=" + GoogleConstants.CLIENT_ID + "&client_secret="
					+ GoogleConstants.CLIENT_SECRET + "&redirect_uri=" + GoogleConstants.REDIRECT_URI + "&grant_type="
					+ GoogleConstants.GRANT_TYPE;

			// post parameters
			URL url = new URL(GoogleConstants.TOKEN_URL);
			URLConnection urlConn = url.openConnection();
			urlConn.setDoOutput(true);
			writer = new OutputStreamWriter(urlConn.getOutputStream());
			writer.write(urlParameters);
			writer.flush();

			// get output in outputString
			String line, outputString = "";
			reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
			while ((line = reader.readLine()) != null) {
				outputString += line;
			}
			log.info(outputString + rn);

			// get Access Token
			JsonObject json = new JsonParser().parse(outputString).getAsJsonObject();
			String access_token = json.get("access_token").getAsString();
			log.info(access_token + rn);

			// get User Info
			url = new URL(GoogleConstants.USERINFO_URL + access_token);
			urlConn = url.openConnection();

			UserDTO user = saveUser(createUser(urlConn));
			url = new URL(GoogleConstants.TOKEN_URL);
			urlConn = url.openConnection();
			reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
			while ((line = reader.readLine()) != null) {
				outputString += line;
			}
			json = new JsonParser().parse(outputString).getAsJsonObject();
			access_token = json.get("access_token").getAsString();
			Authentication principal = new Authentication();
			principal.setLogin(user.getLogin());
			principal.setPassword(access_token);
			Collection<GrantedAuthority> authorities = getAuthorities();
			GoogleOAuthAuthenticationToken token = new GoogleOAuthAuthenticationToken(principal, code, authorities);
			token.setDetails(principal);
			return token;
		} catch (IOException e) {
			log.error("IOException catched" + e);
			return null;
		} finally {
			if (writer != null && reader != null) {
				try {
					writer.close();
					reader.close();
				} catch (IOException e) {
					log.error("IOException catched" + e);
					return null;
				}

			}
		}
	}

	private Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return GoogleOAuthAuthenticationToken.class.equals(authentication);
	}

	public String getGoogleGender(String a) {
		String b = null;
		if ("male".equalsIgnoreCase(a))
			b = GoogleConstants.GOOGLE_MAIL_GENDER;
		else if ("female".equalsIgnoreCase(a))
			b = GoogleConstants.GOOGLE_FEMALE_GENDER;
		else
			b = GoogleConstants.GOOGLE_OTHER_GENDER;
		return b;
	}

	public UserDTO createUser(URLConnection urlConn) throws JsonSyntaxException, JsonIOException, IOException {
		GoogleUser googleUser = new Gson()
				.fromJson(new InputStreamReader(urlConn.getInputStream(), StandardCharsets.UTF_8), GoogleUser.class);
		String email = googleUser.getEmail();
		String login = email.substring(0, email.indexOf("@")).toString();
		String firstname = googleUser.getGiven_name();
		String lastname = googleUser.getFamily_name();
		String photoURL = googleUser.getPicture();
		String fullgender = googleUser.getGender();
		String gender = getGoogleGender(fullgender);

		GroupDTO gg = new GroupDTO();
		gg.setIdGroup(UUID.randomUUID().toString());
		gg.setName(GoogleConstants.DEFAULT_GROUP_NAME);
		gg.setCount("0");
		gg.setDescriptions("");
		gg.setScoreGroup("");
		gg.setStatus("");

		UserDTO userDTO = new UserDTO();
		userDTO.setIdUser(UUID.randomUUID().toString());
		userDTO.setLogin(login);
		userDTO.setPassword(null);
		userDTO.setFirstname(firstname);
		userDTO.setLastname(lastname);
		userDTO.setEmail(email);
		userDTO.setAge("0");
		userDTO.setWeight("0.0");
		userDTO.setGender(gender);
		userDTO.setPhotoURL(photoURL);
		userDTO.setRoleName(GoogleConstants.DEFAULT_ROLE_NAME);
		userDTO.setStatus(null);

		userDTO.setScore("0");
		userDTO.getGroups().add(gg);
		userDTO.setIsDisabled(GoogleConstants.DEFAULT_USER_DISABLED);

		return userDTO;
	}

	public UserDTO saveUser(UserDTO userDTO) {
		HealthBodyService service = new HealthBodyServiceImplService().getHealthBodyServiceImplPort();
		if (service.getUserByLogin(userDTO.getLogin()) == null) {
			service.createUser(userDTO);
		}
		return userDTO;
	}
}
*/