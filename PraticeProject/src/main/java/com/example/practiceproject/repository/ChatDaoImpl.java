package com.example.practiceproject.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.practiceproject.dto.ChannelDto;
import com.example.practiceproject.dto.ChatDto;

@Repository
public class ChatDaoImpl implements ChatDao {
	
	@Autowired
	SqlSession session;
	@Override
	public List<ChannelDto> getList() {
		
		return session.selectList("chat.getList");
	}

	@Override
	public ChatDto getData(int chatId) {
		
		return session.selectOne("chat.getData",chatId);
	}
	@Override
	public void addChat(ChatDto dto) {
		session.insert("chat.insertChat", dto);
		
	}
	
	@Override
	public void createNewChannel(String channelName) {
		session.insert("chat.newChannel", channelName);
		
	}

	@Override
	public List<ChatDto> ChatList(int channelId) {
		
		return session.selectList("chat.chatList", channelId);
	}

	@Override
	public void deleteChannel(int channelName) {
		session.delete("chat.deleteChannel", channelName);
		
	}

	@Override
	public void changeChannel(ChannelDto dto) {
		session.update("chat.updateChannel", dto);
		
	}




}
