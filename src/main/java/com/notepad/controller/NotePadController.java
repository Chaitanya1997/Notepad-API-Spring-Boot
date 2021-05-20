package com.notepad.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotePadController {

	@RequestMapping(value = "/getMessage", method = RequestMethod.GET)
	public String getMessage() {
		return "Hola";
	}
}
