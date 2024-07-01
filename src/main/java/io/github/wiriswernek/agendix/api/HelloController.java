package io.github.wiriswernek.agendix.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
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
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> helloAdmin( Authentication authentication) {
		return ResponseEntity.ok( "Hello - Admin: " + authentication.getName() );
	}

	@GetMapping( "/hello-prestador" )
	@PreAuthorize("hasRole('PRESTADOR')")
	public ResponseEntity<String> helloPrestador( Authentication authentication) {
		return ResponseEntity.ok( "Hello - Prestador: " + authentication.getName() );
	}
	
	@GetMapping( "/hello-cliente" )
	@PreAuthorize("hasRole('CLIENTE')")
	public ResponseEntity<String> helloCliente( Authentication authentication) {
		return ResponseEntity.ok( "Hello - Cliente: " + authentication.getName() );
	}
	
	@GetMapping( "/hello-visitante" )
	@PreAuthorize("hasRole('VISITANTE')")
	public ResponseEntity<String> helloVisitante( Authentication authentication) {
		return ResponseEntity.ok( "Hello - Cliente: " + authentication.getName() );
	}

}
