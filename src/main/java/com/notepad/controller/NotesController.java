package com.notepad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.notepad.entity.Notes;
import com.notepad.service.NotesService;

@RestController
@RequestMapping("/api/v1")
public class NotesController {

	@Autowired
	NotesService notesService;

	@RequestMapping(value = "/getMessage", method = RequestMethod.GET)
	public String getMessage() {
		return "Hola";
	}

	@GetMapping("/notes")
	public ResponseEntity<Object> getNotes() {
		Iterable<Notes> notesList = notesService.getNotes();
		return new ResponseEntity<Object>(notesList, HttpStatus.OK);
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to Notepad App";
	}
}
