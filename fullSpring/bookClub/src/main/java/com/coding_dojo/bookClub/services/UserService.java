package com.coding_dojo.bookClub.services;

import java.util.List;
import java.util.Optional;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import com.coding_dojo.bookClub.models.LoginUser;
import com.coding_dojo.bookClub.models.User;
import com.coding_dojo.bookClub.repositories.UserRepo;

@Service
public class UserService {
	
//	inject UserRepo
	@Autowired
	private UserRepo userRepo;
	
//	register user
	public User register(User newUser, BindingResult result) {
		Optional<User> user = userRepo.findByEmail(newUser.getEmail());
//		if user is already registered
		if (user.isPresent()) {
			result.rejectValue("email", "alreadyPresent", "Email is already taken, please use another");
			return null;
		}
//		if the password confirmation does not match password entry
		else if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("password", "match", "Password confirmation does not match password entry");
			return null;
		}
//		if form data does not pass model-level validations
		else if (result.hasErrors()) {
			return null;
		}
//		else: hash entered password and set user password to hash before registering/saving to db
		else {
			String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashed);
			return userRepo.save(newUser);
		}
	}
	
//	login a user
	public User login(LoginUser newLogin, BindingResult result) {
		Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
		User user = potentialUser.get();
//		if the user is not registered
		if (!potentialUser.isPresent()) {
			result.rejectValue("email", "notPresent", "User is not registered");
			return null;
		}
//		if the password login fails to match any password in the db
		else if (!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "match", "Invalid password");
			return null;
		}
//		if the form data does not pass model-level validations
		else if (result.hasErrors()) {
			return null;
		}
		else {
			return user;
		}
	}
	
//	retrieve one user
	public User findOne(Long id) {
		Optional<User> user = userRepo.findById(id);
		if (user.isPresent()) {
			return user.get();
		}
		else {
			return null;
		}
	}
	
//	retrieve all users
	public List<User> getAll() {
		return userRepo.findAll();
	}
}
