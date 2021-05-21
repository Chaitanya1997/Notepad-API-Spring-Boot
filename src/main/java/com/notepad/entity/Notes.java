package com.notepad.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Notes{
	@Id
	@GeneratedValue
	private Long id;

	private String notesTitle;

	private String notesText;

	public Notes() {
	}

	public Notes(String notesTitle, String notesText) {
		super();
		this.notesTitle = notesTitle;
		this.notesText = notesText;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNotesTitle() {
		return notesTitle;
	}

	public void setNotesTitle(String notesTitle) {
		this.notesTitle = notesTitle;
	}

	public String getNotesText() {
		return notesText;
	}

	public void setNotesText(String notesText) {
		this.notesText = notesText;
	}

	@Override
	public String toString() {
		return "Notes [id=" + id + ", notesTitle=" + notesTitle + ", notesText=" + notesText + "]";
	}

}
