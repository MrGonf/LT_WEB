package bt_01.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bt_01.configs.DBMySQLConnect;
import bt_01.dao.IUserDAO;
import bt_01.models.UserModel;

public class UserDaoImpl extends DBMySQLConnect implements IUserDAO {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    @Override
    public List<UserModel> findAll() {
        String sql = "SELECT * FROM users";
        List<UserModel> list = new ArrayList<>();

        try {
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new UserModel(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getString("fullname"),
                    rs.getString("images"),
                    rs.getInt("roleid"),
                    rs.getString("phone"),
                    rs.getDate("createDate")
                ));
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return null;
    }

    @Override
    public UserModel findById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try {
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                UserModel user = new UserModel();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setFullname(rs.getString("fullname"));
                user.setImages(rs.getString("images"));
                user.setRoleid(rs.getInt("roleid"));
                user.setPhone(rs.getString("phone"));
                user.setCreateDate(rs.getDate("createDate"));
                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return null;
    }

    @Override
    public void insert(UserModel user) {
        String sql = "INSERT INTO users(username, password, email, fullname, images, roleid, phone, createDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getFullname());
            ps.setString(5, user.getImages());
            ps.setInt(6, user.getRoleid());
            ps.setString(7, user.getPhone());
            ps.setDate(8, new java.sql.Date(user.getCreateDate().getTime()));

            ps.executeUpdate();
            System.out.println("✅ Thêm user thành công!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    @Override
    public UserModel findByUserName(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try {
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();

            if (rs.next()) {
                UserModel user = new UserModel();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setFullname(rs.getString("fullname"));
                user.setImages(rs.getString("images"));
                user.setRoleid(rs.getInt("roleid"));
                user.setPhone(rs.getString("phone"));
                user.setCreateDate(rs.getDate("createDate"));
                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return null;
    }

    private void closeResources() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();

        // Thêm 1 user mẫu
        UserModel newUser = new UserModel(0, "Gonf", "123", "G@gmail.com", "MG", "", 1, "0123456789", new java.util.Date());
        userDao.insert(newUser);

        // Tìm theo id
        UserModel userfind = userDao.findById(1);
        if (userfind != null) {
            System.out.println("Tìm thấy: " + userfind);
        } else {
            System.out.println("Không tìm thấy người dùng có id = 1");
        }

        // In toàn bộ danh sách
        List<UserModel> list = userDao.findAll();
        for (UserModel user : list) {
            System.out.println(user);
        }
    }
}
