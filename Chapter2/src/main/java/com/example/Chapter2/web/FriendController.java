package com.example.Chapter2.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Chapter2.domain.Friend;

@Controller
public class FriendController {
	private List<Friend> friends = new ArrayList<>();

	@GetMapping("/index")
	public String greetFriends(Model model) {	
		model.addAttribute("friends", friends);
		return "index";
	}

	@PostMapping("/add-index")
	public String addFriend(@RequestParam("name")String name, Model model) {
		friends.add(new Friend(name));
		return "redirect:/index";
	}

}
