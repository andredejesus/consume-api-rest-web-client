package br.com.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.api.dto.CommentsDTO;
import reactor.core.publisher.Mono;

@Service
public class CommentsService {

	@Autowired
	private WebClient webClient;
	
	public List<CommentsDTO> getCommentsIdPost(Long idPost){

		Mono<List<CommentsDTO>> returnComments = this.webClient
				.method(HttpMethod.GET)
				.uri("/posts/{idPost}/comments", idPost)
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<List<CommentsDTO>>() {});
		
		List<CommentsDTO> list = returnComments.block();
		
		return list;
	}
	
	public CommentsDTO saveComment(CommentsDTO comments) {
		
		Mono<CommentsDTO> returnComment = this.webClient
				.method(HttpMethod.POST)
				.uri("/comments")
				.bodyValue(comments)
				.retrieve()
				.bodyToMono(CommentsDTO.class);
		
		return returnComment.block();
	}
	
}
