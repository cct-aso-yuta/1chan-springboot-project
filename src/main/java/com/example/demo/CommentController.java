package com.example.demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@CrossOrigin
@RequestMapping("/comment")
@RequiredArgsConstructor
@RestController
public class CommentController {

	private final CommentRepository repository;
	
	@Operation(summary = "テスト")
	@RequestMapping("/")
	Comment testData() {
		LocalDateTime now = LocalDateTime.now();
		String time = now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
		return new Comment((long)1 , "name", "content", time, (long)0);
	}
	
	@Operation(summary = "全件取得")
	@GetMapping("/view")
	List<Comment> view() {
		return repository.findAll();
	}
	
	@Operation(summary = "登録")
	@PostMapping("/create")
	Comment create(@RequestBody Comment comment) {
		LocalDateTime now = LocalDateTime.now();
		String time = now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
		comment.setTime(time);
		return repository.save(comment);
	}
	
	@Operation(summary = "削除")
	@DeleteMapping("/delete/{id}")
	void delete(@PathVariable(value = "id") Long id ) {
		repository.deleteById(id);
	}

	
	@Operation(summary = "更新")
	@PutMapping("/update/{id}")
	Comment update(@RequestBody Comment comment, @PathVariable Long id ) {
		LocalDateTime now = LocalDateTime.now();
		String time = now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
		comment.setTime(time);
		return repository.save(comment);
	}
	
	
	@Operation(summary = "いいね")
	@PutMapping("/likeNumUpdate/{id}")
	Comment likeNumUpdate(@RequestBody Comment comment, @PathVariable Long id ) {
		Long nowLikeNum = comment.getLikeNum();
		comment.setLikeNum(nowLikeNum + (long) 1);
		return repository.save(comment);
	}
	
}

