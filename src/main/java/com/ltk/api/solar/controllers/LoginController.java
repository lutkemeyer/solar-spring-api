package com.ltk.api.solar.controllers;

import com.ltk.api.solar.services.LoginService;
import com.ltk.api.solar.tos.login.TokenResponseTO;
import com.ltk.api.solar.tos.login.UserCredentialsRequestTO;
import com.ltk.api.solar.utils.LocalDateTimeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LoginController /* implements AuthenticationControllerDocumentation */ {
	
	private final LoginService loginService;
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = "/login",
	             produces = MediaType.APPLICATION_JSON_VALUE,
	             consumes = MediaType.APPLICATION_JSON_VALUE)
	public TokenResponseTO signIn(@RequestBody UserCredentialsRequestTO userCredentialsRequestTO) {
		
		log.info("Try to authenticate {}", userCredentialsRequestTO.getUsername());
		
		TokenResponseTO responseTO = null;
		
		try {
			responseTO = loginService.signIn(userCredentialsRequestTO);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return responseTO;//userService.signIn(userCredentialsRequestTO);
	}
	
	@ResponseStatus(HttpStatus.OK)
	//	@PreAuthorize("hasAnyAuthority('USER', 'STAFF', 'ADMIN')")
	@GetMapping(value = "/sign",
	            produces = MediaType.APPLICATION_JSON_VALUE,
	            consumes = MediaType.APPLICATION_JSON_VALUE)
	public TokenResponseTO sign() {
		
		TokenResponseTO responseTO = TokenResponseTO.builder()
				.token("123123123")
				.expiration(LocalDateTimeUtil.now())
				.build();
		
		return responseTO;
	}
	
	//	@PostMapping(value = Routes.FORGOT_PASSWORD)
	//	public void forgotPassword(@Valid @RequestBody ForgotPasswordRequest forgotPasswordRequest)
	//			throws ConflictException, NotFoundException {
	//		authenticationService.forgotPassword(forgotPasswordRequest);
	//	}
	
	//	@PostMapping(value = Routes.FORGOT_PASSWORD_CONFIRMATION)
	//	public void forgotPasswordConfirmation(@RequestParam("token") UUID token,
	//	                                       @Valid @RequestBody ForgotPasswordConfirmationRequest forgotPasswordConfirmationRequest)
	//			throws ConflictException, NotFoundException {
	//		authenticationService.forgotPasswordConfirmation(token, forgotPasswordConfirmationRequest.getPassword());
	//	}
	
}
