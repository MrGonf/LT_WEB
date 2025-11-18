package bt_01.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bt_01.configs.DBMySQLConnect;
import bt_01.dao.ICategoryDao;
import bt_01.models.CategoryModel;

public class CategoryDaoImpl implements ICategoryDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<CategoryModel> findAll() {
		String sql = "SELECT * FROM categories";
		List<CategoryModel> list = new ArrayList<>();
		try {
			conn = DBMySQLConnect.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				list.add(category);
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
	public CategoryModel findById(int id) {
		String sql = "SELECT * FROM categories WHERE categoryid=?";
		try {
			conn = DBMySQLConnect.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				return category;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
		return null;
	}

	@Override
	public void insert(CategoryModel category) {
		String sql = "INSERT INTO * FROM categories(categoryname, iamges, stautus) VALUES (?,?,?)";
		try {
			conn = DBMySQLConnect.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

	@Override
	public void update(CategoryModel category) {
		String sql = "UPDATE categories SET categoryname = ?, iamges = ?, stautus = ? WHERE categoryid = ?";
		try {
			conn = DBMySQLConnect.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());
			ps.setInt(4, category.getCategoryid());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM categories WHERE categoryid = ?";
		try {
			conn = DBMySQLConnect.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

	@Override
	public List<CategoryModel> findName(String keyword) {
		String sql = "SELECT * FROM categories WHERE categoryname LIKE ?";
		List<CategoryModel> list = new ArrayList<>();
		try {
			conn = DBMySQLConnect.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				list.add(category);
			}

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
		return null;
	}

	private void closeResources() {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
