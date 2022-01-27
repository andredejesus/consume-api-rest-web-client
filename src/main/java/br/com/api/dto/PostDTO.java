package br.com.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDTO {
	
	private Long id;
	private String title;
	private String body;
	private Long userId;

}
