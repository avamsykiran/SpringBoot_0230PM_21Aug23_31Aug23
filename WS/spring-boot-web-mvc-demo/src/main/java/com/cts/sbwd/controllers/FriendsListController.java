package com.cts.sbwd.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/friends")
@Scope("session")
public class FriendsListController {
	
	private List<String> friends;
	
	public FriendsListController() {
		friends = new ArrayList<>();
	}

	@GetMapping
	public ModelAndView showFriendsList(@RequestParam(name = "friend",required = false) String friend) {
		if(friend!=null) {
			friends.add(friend);
		}
		return new ModelAndView("friends-page","friends",friends);
	}
}
