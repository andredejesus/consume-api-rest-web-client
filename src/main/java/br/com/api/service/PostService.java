package br.com.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.api.dto.PostDTO;
import reactor.core.publisher.Mono;

@Service
public class PostService {
	
	@Autowired
	private WebClient webCliente;

	public PostDTO savePost(PostDTO post) {
		
		Mono<PostDTO> postSave = this.webCliente
					.method(HttpMethod.POST)
					.uri("/posts")
					.body(BodyInserters.fromValue(post))
					.retrieve()
					.bodyToMono(PostDTO.class);
		
		
		return postSave.block();
		
	}
	
	public PostDTO updatePost(PostDTO post) {
		
		Mono<PostDTO> postUpdate = this.webCliente
				.method(HttpMethod.PUT)
				.uri("/posts")
				.body(BodyInserters.fromValue(post))
				.retrieve()
				.bodyToMono(PostDTO.class);
		
		return postUpdate.block();
	}
	
	public void deletePost(Long id) {
		
		this.webCliente
			.method(HttpMethod.DELETE)
			.uri("/posts/{id}", id)
			.retrieve()
			.bodyToMono(Void.class);
		
	}
	
	public List<PostDTO> getPostIdUser(Long id){
		
		Mono<List<PostDTO>> returnPosts = this.webCliente
				.method(HttpMethod.GET)
				.uri("posts?userId={id}", id)
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<List<PostDTO>>() {});
		
		List<PostDTO> lista = returnPosts.block();
		
		return lista;
		
	}
	
}
