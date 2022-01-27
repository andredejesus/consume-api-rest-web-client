package br.com.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentsDTO {

	private Long id;
	private Long postId;
	private String name;
	private String email;
	private String body;
	
}
