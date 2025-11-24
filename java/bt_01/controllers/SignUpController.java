package bt_01.controllers;

import java.io.IOException;

//import bt_01.models.UserModel;
import bt_01.services.IUserService;
import bt_01.services.impl.UserService;
import bt_01.ultis.Constant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/signup" })
public class SignUpController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	IUserService service = new UserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);

		// Kiểm tra session
		if (session != null && session.getAttribute("username") != null) {
			resp.sendRedirect(req.getContextPath() + "/admin");
			return;
		}

//        // Kiểm tra cookie
//        Cookie[] cookies = req.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if ("username".equals(cookie.getName())) {
//                    session = req.getSession(true);
//                    session.setAttribute("username", cookie.getValue());
//                    resp.sendRedirect(req.getContextPath() + "/admin");
//                    return;
//                }
//            }
//        }

		// Mở trang đăng ký
		req.getRequestDispatcher(Constant.Path.SIGNUP).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String fullname = req.getParameter("fullname");
		String phone = req.getParameter("phone");

		String alertMsg = "";

		// Validate null
		if (username == null || password == null || email == null || fullname == null || phone == null
				|| username.isEmpty() || password.isEmpty() || email.isEmpty() || fullname.isEmpty()
				|| phone.isEmpty()) {

			alertMsg = "Vui lòng nhập đầy đủ thông tin!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(Constant.Path.SIGNUP).forward(req, resp);
			return;
		}

		// Kiểm tra email
		if (service.checkExistEmail(email)) {
			alertMsg = "Email đã tồn tại!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(Constant.Path.SIGNUP).forward(req, resp);
			return;
		}

		// Kiểm tra username
		if (service.checkExistUsername(username)) {
			alertMsg = "Tài khoản đã tồn tại!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(Constant.Path.SIGNUP).forward(req, resp);
			return;
		}

		// Kiểm tra phonr
		if (service.checkExistPhone(phone)) {
			alertMsg = "Số điện thoại đã tồn tại!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(Constant.Path.SIGNUP).forward(req, resp);
			return;
		}

		// Tạo user mới
		boolean isSuccess = service.signup(email, password, username, fullname, phone);

		if (isSuccess) {
			resp.sendRedirect(req.getContextPath() + "/login?register=success");
		} else {
			alertMsg = "Đăng ký thất bại!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(Constant.Path.SIGNUP).forward(req, resp);
		}
	}
}
