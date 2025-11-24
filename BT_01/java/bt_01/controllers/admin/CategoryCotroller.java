package bt_01.controllers.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import bt_01.models.CategoryModel;
import bt_01.services.ICategoryService;
import bt_01.services.impl.CategoryServiceImpl;
import bt_01.ultis.Constant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(urlPatterns = { "/admin/categories", "/admin/categories/add", "/admin/categories/insert",
		"/admin/categories/edit", "/admin/categories/update", "/admin/categories/delete", "/admin/categories/search" })
public class CategoryCotroller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ICategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		switch (path) {
		// ==================== add ==================== //
		case "/admin/categories/add":
			req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
			break;

		// ==================== categories ==================== //
		case "/admin/categories":
			List<CategoryModel> list = cateService.findAll();
			req.setAttribute("listcate", list);
			req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
			break;

		// ==================== edit ==================== //
		case "/admin/categories/edit":
			int id = Integer.parseInt(req.getParameter("id"));

			CategoryModel category = cateService.findById(id);

			req.setAttribute("cate", category);

			req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
			break;

		default:
			resp.sendError(404);
			break;
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String path = req.getServletPath();

	    req.setCharacterEncoding("UTF-8");
	    resp.setCharacterEncoding("UTF-8");

	    String categoryname = req.getParameter("categoryname");
	    String statusStr = req.getParameter("status");
	    int _status = 0;
	    try {
	        _status = Integer.parseInt(statusStr);
	    } catch (NumberFormatException e) {
	        _status = 0; // mặc định khóa
	    }

	    String imageLink = req.getParameter("images1");
	    String uploadPath = Constant.Path.DIR;
	    File uploadDir = new File(uploadPath);
	    if (!uploadDir.exists()) uploadDir.mkdir();

	    CategoryModel category = new CategoryModel();

	    switch (path) {
	        // ==================== INSERT ====================
	        case "/admin/categories/insert":
	            category.setCategoryname(categoryname);
	            category.setStatus(_status);

	            try {
	                Part part = req.getPart("images");
	                if (part != null && part.getSize() > 0) {
	                    // Upload file
	                    String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
	                    int index = filename.lastIndexOf(".");
	                    String ext = (index > 0) ? filename.substring(index + 1) : "";
	                    String newName = System.currentTimeMillis() + (ext.isEmpty() ? "" : "." + ext);
	                    part.write(uploadPath + "/" + newName);
	                    category.setImages(newName);
	                } else if (imageLink != null && !imageLink.trim().isEmpty()) {
	                    // Dùng link ảnh
	                    category.setImages(imageLink.trim());
	                } else {
	                    category.setImages("error.png");
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	                category.setImages("error.png");
	            }

	            cateService.insert(category);
	            resp.sendRedirect(req.getContextPath() + "/admin/categories");
	            break;

	        // ==================== UPDATE ====================
	        case "/admin/categories/update":
	            int categoryid = 0;
	            try {
	                categoryid = Integer.parseInt(req.getParameter("categoryid"));
	            } catch (NumberFormatException e) {
	                resp.sendError(400, "Invalid category ID");
	                return;
	            }

	            category.setCategoryid(categoryid);
	            category.setCategoryname(categoryname);
	            category.setStatus(_status);

	            // Lưu file cũ
	            CategoryModel cateOld = cateService.findById(categoryid);
	            String fileOld = (cateOld != null) ? cateOld.getImages() : "error.png";

	            try {
	                Part part = req.getPart("images");
	                if (part != null && part.getSize() > 0) {
	                    // Upload file mới
	                    String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
	                    int index = filename.lastIndexOf(".");
	                    String ext = (index > 0) ? filename.substring(index + 1) : "";
	                    String newName = System.currentTimeMillis() + (ext.isEmpty() ? "" : "." + ext);
	                    part.write(uploadPath + "/" + newName);
	                    category.setImages(newName);

	                    // Xóa file cũ
	                    if (!fileOld.equals("error.png")) {
	                        File oldFile = new File(uploadPath + "/" + fileOld);
	                        if (oldFile.exists()) oldFile.delete();
	                    }
	                } else if (imageLink != null && !imageLink.trim().isEmpty()) {
	                    // Dùng link ảnh
	                    category.setImages(imageLink.trim());
	                } else {
	                    // Giữ file cũ
	                    category.setImages(fileOld);
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	                category.setImages(fileOld);
	            }

	            cateService.update(category);
	            resp.sendRedirect(req.getContextPath() + "/admin/categories");
	            break;

	        default:
	            resp.sendError(404);
	            break;
	    }
	}
}
