package bt_01.dao;

import java.util.List;

import bt_01.models.UserModel;

public interface IUserDAO {

	List<UserModel> findAll();

	UserModel findById(int id);

	void insert(UserModel user);

	UserModel findByUserName(String username);

	boolean signup(String email, String password, String username, String fullname, String phone);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);

}
