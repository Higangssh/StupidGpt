package com.example.practiceproject.service;

import java.util.List;

import com.example.practiceproject.dto.ChannelDto;
import com.example.practiceproject.dto.ChatDto;

public interface ChatService {
	public List<ChannelDto> getList();
	public List<ChatDto> chatList(int channelId);
	public ChatDto getData(int chatId);
	public void addChat(ChatDto dto);
	public void createNewChannel(String channelName);
	public void deleteChannelList(int channelId);
	public void changeOneChannel(ChannelDto dto);
}
