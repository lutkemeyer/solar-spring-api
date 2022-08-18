package com.ltk.api.solar.config;

import com.ltk.api.solar.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDetailsImpl implements UserDetails {
	
	private User user;
	
	private List<GrantedAuthority> roles;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}
	
	@Override
	public String getPassword() {
		return getUser().getPassword();
	}
	
	@Override
	public String getUsername() {
		return getUser().getLogin();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return false;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return false;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
