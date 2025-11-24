package bt_01.services.impl;

import java.util.List;

import bt_01.dao.ICategoryDao;
import bt_01.dao.impl.CategoryDaoImpl;
import bt_01.models.CategoryModel;
import bt_01.services.ICategoryService;

public class CategoryServiceImpl implements ICategoryService {

	public ICategoryDao cateDao = new CategoryDaoImpl();

	@Override
	public List<CategoryModel> findAll() {
		return cateDao.findAll();
	}

	@Override
	public CategoryModel findById(int id) {
		// TODO Auto-generated method stub
		return cateDao.findById(id);
	}

	@Override
	public void insert(CategoryModel category) {
		cateDao.insert(category);
	}

	@Override
	public void update(CategoryModel category) {
		CategoryModel cate = new CategoryModel();
		cate = cateDao.findById(category.getCategoryid());
		if (cate != null) {
			cateDao.update(category);
		}
	}

	@Override
	public void delete(int id) {
		CategoryModel cate = new CategoryModel();
		cate = cateDao.findById(id);
		if (cate != null) {
			cateDao.delete(id);
		}
	}

	@Override
	public List<CategoryModel> findName(String keyword) {
		return cateDao.findName(keyword);
	}

}
