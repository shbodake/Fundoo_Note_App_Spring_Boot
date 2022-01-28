package com.project.fundoonotes.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Note DTO Class 
 * @Data : To auto Generate Getters and Setters
 * @NoArgumentConstructor : To Generate No Argument Constructer
 * @AllArgumentConstructor : To Generate All Argument Constructer
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteDto {

	private int id;
	private String title;
	private String Description;
	private LocalDate createdDate;
	private LocalDate modifiedDate;
	private long userId;
}
