package com.ltk.api.solar.tos.login;

import com.ltk.api.solar.models.User;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsImplTO implements UserDetails {
	
	private User user;
	
	@Builder.Default
	private boolean accountExpired = false;
	
	@Builder.Default
	private boolean enabled = true;
	
	@Builder.Default
	private boolean accountLocked = false;
	
	@Builder.Default
	private boolean credentialsExpired = false;
	
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
		return !accountExpired;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return !accountLocked;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return !credentialsExpired;
	}
	
}
