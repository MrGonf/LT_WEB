package bt_01.services;

import java.util.List;

import bt_01.models.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> findAll();

	CategoryModel findById(int id);

	void insert(CategoryModel category);

	void update(CategoryModel category);

	void delete(int id);

	List<CategoryModel> findName(String keyword);
}
