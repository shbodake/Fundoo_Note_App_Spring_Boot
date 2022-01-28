package com.project.fundoonotes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.fundoonotes.dto.ResponseTemplateDto;
import com.project.fundoonotes.service.ResponseService;

/**
 * @RestController : Defining Class as a RestController
 * @RequestMapping : Defining path of URL
 * @GetMapping : Defining URL Path of API
 * @Autowired : Dependency Injection
 * @Valid : Checking Requested bean is valid or not
 */
@RestController
@RequestMapping("/response")
public class ResponseController {
	
	@Autowired
	private ResponseService ResponseService;
	
	/**
     * API for getting all data from user
     * @return : id
     */
	@GetMapping("/getAllData/{id}")
	public ResponseTemplateDto getLablesAndNotesByUser(@PathVariable("id") long userId) {
		
		return ResponseService.getLablesAndNotesWithUser(userId);
	}
}
