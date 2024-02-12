package io.github.wiriswernek.agendix.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/" )
public class HelloController {

	@GetMapping( "/hello-user" )
	public ResponseEntity<String> helloUser() {
		return ResponseEntity.ok( "Hello - User" );
	}

	@GetMapping( "/hello-admin" )
	public ResponseEntity<String> helloAdmin() {
		return ResponseEntity.ok( "Hello - Admin" );
	}

}
