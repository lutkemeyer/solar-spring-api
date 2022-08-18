package com.ltk.api.solar.config;

//public class UserDetailsServiceImpl implements UserDetailsService {
////	@Autowired
////	private UserService userService;
//
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
//
//		User domainUser = new User();
//		domainUser.setLogin("gui admin");//userService.findByLogin(username);
//		domainUser.setPassword("pwd");//userService.findByLogin(username);
////		if (domainUser == null) {
////			throw new UsernameNotFoundException("Could not find user with name '" + username + "'");
////		}
//		List<GrantedAuthority> roles = SecurityUtil.getRoles(domainUser);
//		return new UserDetailsImpl(domainUser, roles);
//	}
//
//	public static List<GrantedAuthority> getRoles(User user) {
//		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
//		roles.add(new GrantedAuthorityImpl("ROLE_USER"));
//		return roles;
//	}
//
//}
