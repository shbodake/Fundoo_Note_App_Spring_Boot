package com.fundoonotes.user.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request DTO Class 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {
	

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long userId;
		
		@Pattern(regexp = "^[1-9]{2}\\s{1}[0-9]{10}$", message = "phone Number is invalid")
		@NotBlank(message = "phone Number can not be null")
		private String mobileNumber;
		private String password;
	}


