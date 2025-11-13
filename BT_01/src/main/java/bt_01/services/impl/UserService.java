package bt_01.services.impl;

import bt_01.dao.IUserDAO;
import bt_01.dao.impl.UserDaoImpl;
import bt_01.models.UserModel;
import bt_01.services.IUserService;

public class UserService implements IUserService{
	IUserDAO userDao = new UserDaoImpl();
	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.FindByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}

		return null;
	}

	@Override
	public UserModel FindByUserName(String username) {

		return userDao.findByUserName(username);
	}

}
