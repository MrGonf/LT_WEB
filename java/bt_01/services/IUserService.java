package bt_01.services;

import bt_01.models.UserModel;

public interface IUserService {
	UserModel login(String username, String password);
	

	UserModel FindByUserName(String username);
	
	boolean insert(UserModel user);
	boolean signup(String email, String password, String username, String
	fullname, String phone);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);
}
