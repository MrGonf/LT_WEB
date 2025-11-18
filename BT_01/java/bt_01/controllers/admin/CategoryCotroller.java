package bt_01.controllers.admin;

import java.io.IOException;
import java.util.List;

import bt_01.models.CategoryModel;
import bt_01.services.ICategoryService;
import bt_01.services.impl.CategoryServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/admin/categories" })
public class CategoryCotroller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ICategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CategoryModel> list = cateService.findAll();
		req.setAttribute("listcate", list);
		req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
	}
}
