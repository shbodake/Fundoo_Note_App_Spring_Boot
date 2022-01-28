package com.fundoonotes.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fundoonotes.user.dto.RequestDto;
import com.fundoonotes.user.exception.UserException;
import com.fundoonotes.user.model.User;
import com.fundoonotes.user.repository.UserRepository;
import com.fundoonotes.user.util.JwtTokenUtil;

/**
 * @Service : creating service layer
 * @Autowired : enabling automatic dependency Injection
 * @Override : Overriding implemented methods from interface
 */
@Service
public class UserService implements IUserService {

	/**
     * Autowiring UserRepository to Dependency injection to save in DB
     */
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	/**
     * implementing method to create user in DB
     */
	@Override
    public User createUser(User user){
        return userRepository.save(user);
    }
	
	/**
     * implementing method to delete user in DB
     */
	@Override
	public void deletebyID(Long id) {
		userRepository.deleteById(id);
	}

	/**
     * implementing method to update user in DB
     */
	@Override
	public User updateUser(Long id, RequestDto requestDto) {
		User user = userRepository.findById(id).get();
		user.updateUser(requestDto);
		return userRepository.save(user);

	}
	
	/**
	 * implementing method generatingToken
	 */
	
	@Override
	public String generateToken(User user) {
		 Optional<User> userOptional = userRepository.getDetails(user.getMobileNumber() , user.getPassword());
	        if(userOptional.isPresent()){

	            return jwtTokenUtil.generateToken(user.getMobileNumber());
	        }
	        else{
	            throw new UserException("User Not Found");
	        }   
	}
	
	/**
     * implementing method to generate user in DB
     */
	@Override
	public User generateUser(long id,String token) {
		// TODO Auto-generated method stub
		  if (jwtTokenUtil.isValidToken(token)){
	            return userRepository.findByUserId(id);
	        }
	        else throw new UserException("Not Valid Token");
	    }
	@Override
	public User getUser(long id) {
		// TODO Auto-generated method stub
	            return userRepository.findByUserId(id);
	      
	    }
}
