package com.example.practiceproject.dto;

import org.apache.ibatis.type.Alias;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Alias("chatDto")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ChatDto {
	//@JsonProperty("chat_id")
//	private int chatId;
//	private String chatName;
	//@JsonIgnore
	
	private int chatId;
	private int channelId;  
	private String content;
	private String author;
	private String regdate;
}
