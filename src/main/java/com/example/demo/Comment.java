package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="comment")
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("comment_id")
	private Long commentId;
	
	@NotBlank
	@JsonProperty("name")
	private String name;
	
	@NotBlank
	@Size(max = 200)
	@JsonProperty("content")
	private String content;
	
	@JsonProperty("time")
	private String time;
	
	@JsonProperty("like_num")
	private Long likeNum;
}
	