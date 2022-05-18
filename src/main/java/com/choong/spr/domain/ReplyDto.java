package com.choong.spr.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ReplyDto {
	private int id;
	private int boardId;
	private String content;
	private LocalDateTime inserted;
	private int numOfReply;
	
	public int getNumOfReply() {
		return numOfReply;
	}

	public void setNumOfReply(int numOfReply) {
		this.numOfReply = numOfReply;
	}
	
	public String getPrettyInserted() {
		LocalDateTime now = LocalDateTime.now();
		if (now.minusHours(24).isBefore(inserted)) {
			return inserted.toLocalTime().toString();
		} else {
			return inserted.toLocalDate().toString();
		}
	}
}
