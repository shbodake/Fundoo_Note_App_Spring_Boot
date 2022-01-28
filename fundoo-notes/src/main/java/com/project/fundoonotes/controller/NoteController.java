package com.project.fundoonotes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.fundoonotes.dto.NoteDto;
import com.project.fundoonotes.model.Note;
import com.project.fundoonotes.model.Response;
import com.project.fundoonotes.service.NoteService;

/**
 * @RestController : Defining Class as a RestController
 * @RequestMapping : Defining path of URL
 * @PostMapping : Defining URL path of API and to perform POST operation
 * @GetMapping : Defining URL Path of API
 * @PutMapping : Defining URL Path of API which perform PUT operation
 * @DeleteMapping : Defining URL Path of API which perform DELETE opertion
 * @Autowired : Dependency Injection
 * @Valid : Checking Requested bean is valid or not
 */
@RestController
@RequestMapping("/note")
public class NoteController {
	
	/**
     * AutoWiring LabelInterace to Dependency Injection
     */
	@Autowired
	private NoteService noteService;

	/**
     * API for getting all note List
     * @return : ResponseEntity of Note List
     */
	@GetMapping("/getAll")
	public ResponseEntity<Response> getAllNotes() {
		List<Note> noteList = null;
		noteList = noteService.getAllNotes();
		Response respDTO = new Response("Get call success", noteList);
		return new ResponseEntity<Response>(respDTO, HttpStatus.OK);
	}
	
	 /**
     * API for Getting note by ID
     * @param id
     * @return : ResponseEntity of note
     */
	@GetMapping("/get/{id}")
	public ResponseEntity<Response> getNotesById(@PathVariable("id") int id) {
		Note noteDetails = null;
		noteDetails = noteService.geNotesById(id);
		Response respDTO = new Response("Get call success for id:" + id, noteDetails);
		return new ResponseEntity<Response>(respDTO, HttpStatus.OK);
	}

	/**
     * API for Createing note
     * @param NoteDto
     * @return : ResponseEntity of Created label and Http sattus
     */
	@PostMapping("/create")
	public ResponseEntity<Response> createNotes( @RequestBody Note noteDto) {
		
		Note createNote = noteService.createNote(noteDto);  
		Response respDTO = new Response("created Note successfully", createNote);
		return new ResponseEntity<Response>(respDTO, HttpStatus.OK);
	}

	
	/**
     * API for Updating note Details
     * @param NoteDto
     * @param id
     * @return : ResponseEntity of Updated note
     */
	@PutMapping("/update/{id}")
	public ResponseEntity<Response> updateNote(@PathVariable("id") int id,
			@RequestBody NoteDto noteDto) {
		Note createNote = null;
		createNote = noteService.updateNoteByID(id, noteDto);
		Response respDTO = new Response("Updated Note successfully", createNote);
		return new ResponseEntity<Response>(respDTO, HttpStatus.OK);
	}

	/**
     * API Deleting Note ByID
     * @param id
     * @return : Response Entity of Deleted note id
     */

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Response> deleteNote(@PathVariable("id") int id) {
		noteService.deletebyID(id);
		Response respDTO = new Response("Deleted Note Successfully",
				"deleted NoteId is :" + id);
		return new ResponseEntity<Response>(respDTO, HttpStatus.OK);
	}

}