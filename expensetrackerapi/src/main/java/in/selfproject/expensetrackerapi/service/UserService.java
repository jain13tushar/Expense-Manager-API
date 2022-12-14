package in.selfproject.expensetrackerapi.service;

import in.selfproject.expensetrackerapi.entity.User;
import in.selfproject.expensetrackerapi.entity.UserModel;

public interface UserService {

	User createUser(UserModel user);

	User readUser();

	User updateUser(UserModel user);

	void deleteUser();

	User getLoggedInUser();

}
