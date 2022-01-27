package br.com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.dto.PostDTO;
import br.com.api.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping
	public ResponseEntity<PostDTO> savePost(@RequestBody PostDTO post){
		return new ResponseEntity<PostDTO>(this.postService.savePost(post), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO post){
		return new ResponseEntity<PostDTO>(this.postService.updatePost(post), HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> deletePost(@PathVariable Long id){
		this.postService.deletePost(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<List<PostDTO>> getPostIdUser(@PathVariable Long id){
		return new ResponseEntity<List<PostDTO>>(this.postService.getPostIdUser(id), HttpStatus.OK);
	}
	

}
