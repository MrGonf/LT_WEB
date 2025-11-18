package bt_01.services.impl;

import bt_01.dao.IUserDAO;
import bt_01.dao.impl.UserDaoImpl;
import bt_01.models.UserModel;
import bt_01.services.IUserService;

public class UserService implements IUserService {

    IUserDAO userDao = new UserDaoImpl();

    @Override
    public UserModel login(String username, String password) {
        UserModel user = userDao.findByUserName(username);

        if (user == null) return null;

        // Tránh lỗi null
        if (password != null && password.equals(user.getPassword())) {
            return user;
        }

        return null;
    }

    @Override
    public UserModel FindByUserName(String username) {
        return userDao.findByUserName(username);
    }

    @Override
    public boolean insert(UserModel user) {
        try {
            userDao.insert(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean signup(String email, String password, String username, String fullname, String phone) {

        // Check trùng dữ liệu
        if (userDao.checkExistUsername(username)) return false;
        if (userDao.checkExistEmail(email)) return false;
        if (userDao.checkExistPhone(phone)) return false;

        long millis = System.currentTimeMillis();

        // Constructor chuẩn phải có đủ: username, password, email, fullname, images, roleid, phone, createDate
        UserModel user = new UserModel(
                0,
                username,
                password,
                email,
                fullname,
                "",       // images rỗng
                1,        // roleid mặc định
                phone,
                new java.util.Date(millis)
        );

        userDao.insert(user);
        return true;
    }

    @Override
    public boolean checkExistEmail(String email) {
        return userDao.checkExistEmail(email);
    }

    @Override
    public boolean checkExistUsername(String username) {
        return userDao.checkExistUsername(username);
    }

    @Override
    public boolean checkExistPhone(String phone) {
        return userDao.checkExistPhone(phone);
    }
}
