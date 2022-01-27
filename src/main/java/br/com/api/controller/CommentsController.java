package br.com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.dto.CommentsDTO;
import br.com.api.service.CommentsService;

@RestController
@RequestMapping("/comments")
public class CommentsController {
	
	@Autowired
	private CommentsService commentsService;
	
	@GetMapping("/idPost/{idPost}")
	public ResponseEntity<List<CommentsDTO>> getCommentsByIdPost(@PathVariable Long idPost){
		
		return new ResponseEntity<List<CommentsDTO>>(this.commentsService.getCommentsIdPost(idPost), HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<CommentsDTO> saveComment(@RequestBody CommentsDTO commentDTO){
		return new ResponseEntity<CommentsDTO>(this.commentsService.saveComment(commentDTO), HttpStatus.CREATED);
	}

}
