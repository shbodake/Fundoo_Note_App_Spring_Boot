package com.project.fundoonotes.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User DTO Class
 * @Data : To auto Generate Getters and Setters
 * @NoArgumentConstructor : To Generate No Argument Constructer
 * @AllArgumentConstructor : To Generate All Argument Constructer 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	private long userId;
	private String mobileNumber;
	private String password;
}
