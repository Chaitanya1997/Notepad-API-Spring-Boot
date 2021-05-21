package com.notepad;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.notepad.entity.Notes;
import com.notepad.repository.NotesRepository;

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
			notesRepository.save(new Notes("Notes1", "This is Notes1 Text"));
			notesRepository.save(new Notes("Notes2", "This is Notes2 Text"));
			notesRepository.save(new Notes("Notes3", "This is Notes3 Text"));
		};
	}

}