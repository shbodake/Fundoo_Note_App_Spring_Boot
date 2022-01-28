package com.project.fundoonotes.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.fundoonotes.dto.NoteDto;
import com.project.fundoonotes.model.Note;

/**
 * @Repository : Creating Repository to store data in DataBase
 */
@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {

	Note save(NoteDto note);

	List<Note> findByUserId(long userId);

}
