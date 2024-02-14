package com.example.practiceproject.dto;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Alias("channelDto")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ChannelDto {
	private int channelId; 
	private String channelName; 
}
