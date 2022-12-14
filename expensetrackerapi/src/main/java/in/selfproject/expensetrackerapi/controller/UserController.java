package in.selfproject.expensetrackerapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.selfproject.expensetrackerapi.entity.User;
import in.selfproject.expensetrackerapi.entity.UserModel;
import in.selfproject.expensetrackerapi.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/getProfile")
	public ResponseEntity<User> readUser() {
		return new ResponseEntity<User>(userService.readUser(), HttpStatus.OK);
	}

	@PutMapping("/updateProfile")
	public ResponseEntity<User> updateUser(@RequestBody UserModel userModel) {
		return new ResponseEntity<User>(userService.updateUser(userModel), HttpStatus.OK);
	}

	@DeleteMapping("/deactivateProfile")
	public ResponseEntity<User> deleteUser(@RequestBody UserModel userModel) {
		userService.deleteUser();
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

}
