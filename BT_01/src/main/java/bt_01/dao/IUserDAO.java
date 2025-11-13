package bt_01.dao;

import java.util.List;

import bt_01.models.UserModel;

public interface IUserDAO {

	List<UserModel> findAll();
	
	UserModel findById(int id);
	
	void insert(UserModel user);
	
	UserModel findByUserName(String username);
	
	
	
}
