package com.example.practiceproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practiceproject.dto.ChannelDto;
import com.example.practiceproject.dto.ChatDto;
import com.example.practiceproject.repository.ChatDao;

@Service
public class ChatServiceImpl implements ChatService {
	@Autowired
	ChatDao dao;
	@Override
	public List<ChannelDto> getList() {
		return dao.getList();
	}


	@Override
	public ChatDto getData(int chatId) {
		return dao.getData(chatId);
	}

	@Override
	public void addChat(ChatDto dto) {
		dao.addChat(dto);
		
	}
	
	@Override
	public void createNewChannel(String channelName) {
		dao.createNewChannel(channelName);
	}


	@Override
	public List<ChatDto> chatList(int channelId) {
		return dao.ChatList(channelId);
	}


	@Override
	public void deleteChannelList(int channelId) {
		dao.deleteChannel(channelId);
		
	}


	@Override
	public void changeOneChannel(ChannelDto dto) {
		dao.changeChannel(dto);
		
	}


}
