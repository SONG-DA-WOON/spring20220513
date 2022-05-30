package com.choong.spr.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardDto {
	private int id;
	private String title;
	private String body;
	private LocalDateTime inserted;
	private int numOfReply;
	private String type;
	private String keyword;

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
