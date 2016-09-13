/*package edu.softserveinc.healthbody.webclient.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import edu.softserveinc.healthbody.webclient.config.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class GoogleOAuthAuthenticationToken extends AbstractAuthenticationToken {

	private static final long serialVersionUID = 1L;
	private Authentication authentication;
	private String code;

	public GoogleOAuthAuthenticationToken(Authentication authentication, String accessToken,
			Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		this.authentication = authentication;
		this.code = accessToken;
	}

	public GoogleOAuthAuthenticationToken(String accessToken) {
		super(Collections.emptySet());
		this.code = accessToken;
	}

	@Override
	public Object getCredentials() {
		return this.code;
	}

	@Override
	public Object getPrincipal() {
		return this.authentication;
	}

}*/