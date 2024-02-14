package com.example.practiceproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.practiceproject.dto.ChannelDto;
import com.example.practiceproject.dto.ChatDto;
import com.example.practiceproject.service.ChatService;

import lombok.extern.slf4j.Slf4j;

@RestController
public class ChannelController {
	@Autowired
	ChatService service;

	/**
	 * 채널에 메시지를 보내고, GPT 가 생성한 메시지를 받습니다. 
	 * @param channelId 채널 
	 * @return GPT 의 응답이 반환됩니다 
	 */
	@PostMapping("/channel/{channelId}/chat")
	public ChatDto sendChat(ChatDto requestDto, @PathVariable("channelId") int channelId) {
		requestDto.setChannelId(channelId);
		requestDto.setAuthor("me");
		service.addChat(requestDto);
		
		ChatDto responseDto = new ChatDto();
		responseDto.setChannelId(channelId);
		responseDto.setContent("이것만 대답함");
		responseDto.setAuthor("GPT");
		service.addChat(responseDto);
		
		return responseDto; 
	}
	
	/**
	 * 
	 * @param channelId
	 * @return 채팅 리스트가 응답합니다
	 */
	@GetMapping("/chat")
	public List<ChatDto> chatList(@RequestParam("channelId") int channelId){
		return service.chatList(channelId);
	
	/**
	 * channelId 요청하신 채널 번호를 보내십시요
	 * @param channelId 요청하신 채널 번호를 보내십시요
	 * @return 반환값 없습니다	
	 */
	}
	@DeleteMapping("/channel/{channelId}/delete")
	public void DelChannelList(@PathVariable("channelId") int channelId) {
		service.deleteChannelList(channelId);
	}
	
	/**
	 * 
	 * @param 수정할 channelName 과 channelId 를 json 형식으로 요청바람
	 * @return 반환값 없음
	 */
	@PatchMapping("channel/update")
	public void UpdateChannelName(@RequestBody ChannelDto dto) {
		service.changeOneChannel(dto);
	}
	
	/**
	 * 모든 채널의 정보를 가지고 옵니다
	 * @return 모든 채널의 리스트가 반환됩니다 
	 */
	@GetMapping("/channel")
	public List<ChannelDto> channelList(){
	
		return service.getList(); 
	}

	/**
	 * 새로운 채널을 만듭니다
	 * 
	 * @param channelName 새로 만들어질 채널의 이름입니다
	 * @return 새로 만들어진 채널의 정보가 반환됩니다
	 */
	@PostMapping("/channel/new")
	public void createNewChannel(@RequestBody ChannelDto channelCreateRequest) {
		service.createNewChannel(channelCreateRequest.getChannelName()); 
	}

//	
//	/**
//	 * channel 에 해당하는 모든 채팅을 가지고 옵니다
//	 * @param channelId  채팅 목록을 조회할 채널의 아이디입니다
//	 * @return 해당 채널의 모든 채팅 정보를 가지고 옵니다 
//	 */
//	@GetMapping("/channel/{channelId}/chat")
//	public ResponseEntity<ChatDto> chatListData(@PathVariable("channelId") int channelId) {
//		ChatDto dto = service.getData(channelId);
//
//		var headers = new HttpHeaders();
//		headers.set("Set-Cookie", "NID_SES=AAlkbnslkdfjsdf");
//		
//		return ResponseEntity
//				.ok()
//				.headers(headers)
//				.body(dto);			
//	}
	
	
}
