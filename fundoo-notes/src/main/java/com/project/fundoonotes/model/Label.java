package com.project.fundoonotes.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.project.fundoonotes.dto.LabelDto;
import com.project.fundoonotes.dto.UserDto;

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
@Table(name = "label")
public class Label {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int userId;
	
	private String name;
	private Date createdDate;
	private Date modifiedDate;

	public void updateLabel(LabelDto labelDto) {
		this.name = labelDto.getName();
		this.createdDate = new Date();
		this.modifiedDate = new Date();

	}
	
	/**
     * Defining custom Constructor 
     * @param labelDto
    */
	public Label(LabelDto labelDto) {
		this.updateLabel(labelDto);
		}
  
}
