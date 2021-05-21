package com.notepad;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class NotepadBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotepadBackendApplication.class, args);
	}

	@Configuration
	@EnableWebMvc
	public class WebConfig implements WebMvcConfigurer {

		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**");
		}
	}

	@Bean
	ApplicationRunner applicationRunner(NotesRepository notesRepository) {
		return args -> {
			notesRepository.save(new Note("Notes1"));
			notesRepository.save(new Note("Notes2"));
			notesRepository.save(new Note("Notes3"));
		};
	}

}

@RestController
class NotepadController {

	@Autowired
	NotesRepository notesRepository;

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to Notepad App";
	}

	@GetMapping("/notes")
	public Iterable<Note> getNotes() {
		return notesRepository.findAll();
	}

}

@Entity
class Note {
	@Id
	@GeneratedValue
	private Long id;

	private String notes;

	public Note() {
	}

	public Note(String notes) {
		this.notes = notes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}

interface NotesRepository extends CrudRepository<Note, Long> {
}