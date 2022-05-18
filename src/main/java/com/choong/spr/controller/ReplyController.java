package com.choong.spr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.choong.spr.domain.ReplyDto;
import com.choong.spr.service.ReplyService;

@Controller
@RequestMapping
public class ReplyController {

	@Autowired
	private ReplyService service;

	@PostMapping("reply/add")
	public String addReply(ReplyDto reply) {
		boolean success = service.addReply(reply);

		return "redirect:/board/" + reply.getBoardId();
	}

	@PostMapping("reply/remove")
	public String removeReply(ReplyDto reply) {
		boolean success = service.removeReplyById(reply.getId());

		return "redirect:/board/" + reply.getBoardId();
	}

	@PostMapping("reply/modify")
	public String modifyReply(ReplyDto reply) {
		boolean success = service.modifyReply(reply);

		return "redirect:/board/" + reply.getBoardId();
	}
}
