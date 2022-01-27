package br.com.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.api.dto.UserDTO;
import reactor.core.publisher.Mono;

@Service
public class UserService {
	
	@Autowired
	private WebClient webClient;
	
	public List<UserDTO> getUsers() {
		
		Mono<List<UserDTO>> listUsers = this.webClient
					.method(HttpMethod.GET)
					.uri("/users")
					.retrieve()
					.bodyToMono(new ParameterizedTypeReference<List<UserDTO>>() {});
		
		List<UserDTO> listReturn = listUsers.block();
		
		
		return listReturn;
	}
	

}
