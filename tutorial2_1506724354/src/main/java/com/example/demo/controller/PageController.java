package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PageController {
	@RequestMapping("/hello")
	public String index () {
		return "hello";
	}
	
	@RequestMapping ( "/greeting")
	public String greeting ( @RequestParam ( value = "name" , required = false ) String name , Model model)
	{
		model. addAttribute ( "name" , name );
		return "greeting";
	}
	
	@RequestMapping ( value = { "/greeting" , "greeting/{name}" })
	public String greetingPath ( @PathVariable Optional<String> name , Model model ) {
		if ( name . isPresent ()) {
			model . addAttribute ( "name" , name . get ());
		} else {
			model . addAttribute ( "name" , "dengklek" );
		}
		return "greeting";
	}
	
	@RequestMapping ("/perkalian")
	public String perkalian(
			@RequestParam (value = "name", required = false, defaultValue = "0") String name, 
			@RequestParam (value = "name2", required = false, defaultValue = "0") String name2,
			Model model){
		if (name != null && name2 != null) {
			model.addAttribute("name", name);
			model.addAttribute("name2", name2);
			model.addAttribute("result" , Integer.parseInt(name) * Integer.parseInt(name2));
		}
		return "perkalian";
	}
	
}
