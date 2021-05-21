package com.notepad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notepad.entity.Notes;
import com.notepad.repository.NotesRepository;

@Service
public class NotesService {

	@Autowired NotesRepository notesRepository;
	
	public Iterable<Notes> getNotes() {
		return this.notesRepository.findAll();
	}
	
}
