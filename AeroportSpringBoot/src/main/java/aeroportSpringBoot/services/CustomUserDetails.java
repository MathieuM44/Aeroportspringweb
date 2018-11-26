package aeroportSpringBoot.services;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import aeroportSpringBoot.model.Login;

@SuppressWarnings("serial")
public class CustomUserDetails implements UserDetails {

	private Login login;

	public CustomUserDetails(Login login) {
		this.login = login;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<String> roleList = Collections.emptySet();
		if (login.getAdmin()) {
			roleList.add("ADMIN");
		} else {
			roleList.add("USER");
		}
		return AuthorityUtils
				.commaSeparatedStringToAuthorityList(StringUtils.collectionToCommaDelimitedString(roleList));
	}

	@Override
	public String getPassword() {
		return login.getMotDePasse();
	}

	@Override
	public String getUsername() {
		return login.getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
