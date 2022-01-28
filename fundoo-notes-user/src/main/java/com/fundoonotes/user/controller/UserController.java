package com.fundoonotes.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundoonotes.user.dto.RequestDto;
import com.fundoonotes.user.dto.ResponseDTO;
import com.fundoonotes.user.model.User;
import com.fundoonotes.user.service.UserService;

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
@RequestMapping("/user")
public class UserController {

	/**
     * AutoWiring UserInterace to Dependency Injection
     */
	@Autowired
	private UserService userService;

	/**
     * API for register the user-fundoonotes
     * @param User
     * @return : ResponseEntity of registered user-fundoonotes
     */
	@PostMapping("/register")
	public ResponseEntity<ResponseDTO> registerUser(@Valid @RequestBody User user) {
		User userDetailUser = userService.createUser(user);
		ResponseDTO responseDTO = new ResponseDTO("Create Call Success ", userDetailUser, HttpStatus.CREATED);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
	}

	/**
     * API for generate token of user-fundoonotes
     * @param User
     * @return : ResponseEntity of generated token of user-fundoonotes
     */
	@PostMapping("/token")
	public ResponseEntity<ResponseDTO> generateUser(@RequestBody User user) {
		String userDetailUser = userService.generateToken(user);
		ResponseDTO responseDTO = new ResponseDTO("Create Call Success ", userDetailUser, HttpStatus.ACCEPTED);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.ACCEPTED);

	}
	
	/**
     * API for gettig user of user-fundoonotes
     * @param User
     * @return : ResponseEntity of user of user-fundoonotes
     */
	/*
	 * @GetMapping("/getUser/{id}") public User generateUser(@PathVariable("id")
	 * long id,@RequestHeader String token) { User userDetailUser =
	 * userService.generateUser(id,token); //ResponseDTO responseDTO = new
	 * ResponseDTO("Get User data", userDetailUser, HttpStatus.ACCEPTED); return
	 * userDetailUser; }
	 */
	@GetMapping("/getUser/{id}")
	public User getUser(@PathVariable("id") long id) {
		User userDetailUser = userService.getUser(id);
		//ResponseDTO responseDTO = new ResponseDTO("Get User data", userDetailUser, HttpStatus.ACCEPTED);
		return userDetailUser;
	}

	/**
     * API for update of user-fundoonotes
     * @param User
     * @return : ResponseEntity of update of user-fundoonotes
     */
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateUser(@Valid @PathVariable("id") long id , @RequestBody RequestDto requestDto) {
		User user = userService.updateUser(id, requestDto);
		ResponseDTO responseDTO = new ResponseDTO("Create Call Success ", user, HttpStatus.CREATED);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
	}

	/**
     * API for delete user of user-fundoonotes
     * @param User
     * @return : ResponseEntity of deleted user of user-fundoonotes
     */
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<ResponseDTO> deleteUser(@PathVariable("id") Long id) {
		userService.deletebyID(id);
		ResponseDTO responseDTO = new ResponseDTO("Deleted id successfully ", id, HttpStatus.CREATED);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);

	}
}