package contoroller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import dao.UserDao;

/**
 * Servlet implementation class UserSignUp
 */
@WebServlet("/UserSignUpServlet")
public class UserSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSignUpServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		if(session.getAttribute("userInfo") == null) {
		// ログイン画面のサーブレットにリダイレクト
			response.sendRedirect("LoginServlet");
			return;
		}
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserSignUp.jsp");
		dispatcher.forward(request, response);

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		// リクエストパラメータの入力項目を取得
		String loginId = request.getParameter("loginID");
		String passworda = request.getParameter("passworda");
		String passwordb = request.getParameter("passwordb");
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");

		boolean bool1 = loginId.isEmpty();
		boolean bool2 = passworda.isEmpty();
		boolean bool3 = passwordb.isEmpty();
		boolean bool4 = name.isEmpty();
		boolean bool5 = birthday.isEmpty();

		if(bool1|| bool2|| bool3|| bool4|| bool5|| !passworda.equals(passwordb)) {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg", "入力された内容は正しくありません。");

			// 新規登録jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserSignUp.jsp");
			dispatcher.forward(request, response);
			return;
		}
		/** 条件を満たした場合 **/
		UserDao user = new UserDao();

		//ハッシュを生成したい元の文字列
		String source = passworda;
		//ハッシュ生成前にバイト配列に置き換える際のCharset
		Charset charset = StandardCharsets.UTF_8;
		//ハッシュアルゴリズム
		String algorithm = "MD5";

		//ハッシュ生成処理
		byte[] bytes = null;
		try {
			bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		String result = DatatypeConverter.printHexBinary(bytes);
		//標準出力
		System.out.println(result);

		user.InsertUserDao(loginId,result,name,birthday);

	// ユーザ一覧のサーブレットにリダイレクト
	response.sendRedirect("UserListServlet");
	}

}
