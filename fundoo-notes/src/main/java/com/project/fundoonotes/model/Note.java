package com.project.fundoonotes.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.fundoonotes.dto.NoteDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Data : Using Lombok to Generate getters and setters
 * @GeneratedValue : To auto generate i value
 * @Id : To Describe value as a Id in MySQL
 * @GenerateValue : To auto generate id value
 * @Entity : To create class as entity
 * @Table : to Create table
 * @NoArgsConstructor : Generating No Argument Constructor using Lombok
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "note_data")
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private long userId;
	private String title;
	private String description;
	@JsonFormat(pattern = "dd MMM yyyy")
	private Date createdDate;
	private Date modifiedDate;

	/**
     * Defining custom Constructor 
     * @param noteDto
    */
	public Note(NoteDto note) {
		this.updateNote(note);
	}

	public void updateNote(NoteDto noteDto) {
		this.title = noteDto.getTitle();
		this.description = noteDto.getDescription();
		this.createdDate = new Date();
		this.modifiedDate = new Date();
	}

}
