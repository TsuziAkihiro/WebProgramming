package contoroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO 未実装：ログインセッションがない場合、ログイン画面にリダイレクトさせる
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfo") == null) {
		// ログイン画面のサーブレットにリダイレクト
			response.sendRedirect("LoginServlet");
			return;
		}
		// URLからGETパラメータとしてIDを受け取る
		String id = request.getParameter("id");

		// 確認用：idをコンソールに出力
		System.out.println(id);
		UserDao dao = new UserDao();
		User user = dao.detailDao(id);
		request.setAttribute("user",user);

		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserUpdate.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		// リクエストパラメータの入力項目を取得
		String id = request.getParameter("id");
		System.out.println(id);

		String passworda = request.getParameter("passworda");
		String passwordb = request.getParameter("passwordb");
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");


		boolean bool1 = name.isEmpty();
		boolean bool2 = birthday.isEmpty();

		if(bool1|| bool2|| !passworda.equals(passwordb)) {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg", "入力された内容は正しくありません。");

			// 新規登録jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserUpdate.jsp");
			dispatcher.forward(request, response);
			return;
		}
		/** 条件を満たした場合 **/
		UserDao user = new UserDao();
		user.InsertUserDao(id,passworda,name,birthday);

	// ユーザ一覧のサーブレットにリダイレクト
	response.sendRedirect("UserListServlet");
	}
}
