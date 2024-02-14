package com.example.practiceproject.repository;

import java.util.List;

import com.example.practiceproject.dto.ChannelDto;
import com.example.practiceproject.dto.ChatDto;

public interface ChatDao {
	public List<ChannelDto> getList();
	public List<ChatDto> ChatList(int channelId);
	public ChatDto getData(int chatId);
	public void addChat(ChatDto dto);
	public void createNewChannel(String name);
	public void deleteChannel(int channelName);
	public void changeChannel(ChannelDto dto);
}
