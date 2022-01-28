package com.project.fundoonotes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fundoonotes.dto.NoteDto;
import com.project.fundoonotes.model.Note;
import com.project.fundoonotes.repo.NoteRepository;

/**
* @Service : creating service layer
* @Autowired : enabling automatic dependency Injection
* @Override : Overriding implemented methods from interface
*/
@Service
public class NoteService implements INoteService {

	 /**
     * Autowiring Noterepository to Dependency injection to save in DB
     */
	@Autowired
	private NoteRepository noteRepository;

	/**
     * implementing method to update Note
     */
	@Override
	public Note updateNoteByID(int id, NoteDto noteDto) {
	Note note = this.geNotesById(id);
	note.updateNote(noteDto);
		return noteRepository.save(note);
	}

	/**
     * implementing method to delete Note by id in DB
     */
	@Override
	public void deletebyID(int id) {
		noteRepository.deleteById(id);
	}

	/**
     * implementing method to get all Notes
     */
	@Override
	public List<Note> getAllNotes() {
		return noteRepository.findAll();
	}

	/**
     * implementing method to get note by its ID
     */
	@Override
	public Note geNotesById(int id) {
		return noteRepository.findById(id).get();
	}

	/**
     * implementing method to crete Note in table
     */
	@Override
	public Note createNote(NoteDto noteDto) {
		Note note = null;
		note = new Note(noteDto);
		return noteRepository.save(note);
	}

}
