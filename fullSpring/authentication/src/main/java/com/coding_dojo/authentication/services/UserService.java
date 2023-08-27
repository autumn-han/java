package com.coding_dojo.authentication.services;

import java.util.Optional;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import com.coding_dojo.authentication.models.LoginUser;
import com.coding_dojo.authentication.models.User;
import com.coding_dojo.authentication.repositories.UserRepo;

@Service
public class UserService {
	
//	instantiate and inject User repository
	@Autowired
	private UserRepo userRepo;
	
//	register a user
	public User register(User newUser, BindingResult result) {
		Optional<User> user = userRepo.findByEmail(newUser.getEmail());
//		if user is already present in the db
		if (user.isPresent()) {
			result.rejectValue("email", "present", "Email is already taken, please use another");
		}
//		if the new user's password and confirm-password fields don't match
		else if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "match", "Password confirmation did not match password entry");
		}
//		if there are errors present
		else if (result.hasErrors()) {
			return null;
		}
//		otherwise, create user
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userRepo.save(newUser);

	}
	
//	login a user
	public User login(LoginUser newLoginObject, BindingResult result) {
		Optional<User> loginUser = userRepo.findByEmail(newLoginObject.getEmail());
		User user = loginUser.get();
//		if user is not present in the database
		if (!loginUser.isPresent()) {
			result.rejectValue("email", "present", "User is not registered");
		}
//		if passwords don't match
		else if (!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
			result.rejectValue("password", "match", "Invalid password");
		}
		else if (result.hasErrors()) {
			return null;
		}
		return user;
	}
	
//	retrieve one user
	public User findOne(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		}
		else {
			return null;
		}
	}
}
