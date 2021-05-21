package com.notepad.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.notepad.entity.Notes;


@Repository
public interface NotesRepository extends CrudRepository<Notes, Long> {
}
