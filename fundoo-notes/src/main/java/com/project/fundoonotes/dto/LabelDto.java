package com.project.fundoonotes.dto;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Label DTO Class 
 * @Data : To auto Generate Getters and Setters
 * @NoArgumentConstructor : To Generate No Argument Constructer
 * @AllArgumentConstructor : To Generate All Argument Constructer
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LabelDto {

	
	private int id;

	private String name;
	private LocalDate createdDate;
	private LocalDate modifiedDate;
    private int userId;

	
}
