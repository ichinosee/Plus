package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PlusServlet
 */
@WebServlet("/PlusServlet")
public class PlusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String num1 = request.getParameter("value1");
		String num2 = request.getParameter("value2");
		if(num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
			showNotEnterdError(out);
			return;
		}

		int answer = 0;
		try {
		int i1 = Integer.parseInt(num1);
		int i2 = Integer.parseInt(num2);
		answer = i1 + i2;
		}catch(NumberFormatException e) {

			showNotIntegerError(out);
			return;
		}

		out.println("<html><head><title>Plus</title></head><body>");
		out.println(num1 + " + " + num2 + "=" + answer);
		out.println("</body></head>");
	}

	private void showNotEnterdError(PrintWriter out) {
		out.println("<html><head><title>Plus</title></head><body>");
		out.println("<h1>整数を２つ入力してください</h1>");
		out.println("</body></head>");
	}

	private void showNotIntegerError(PrintWriter out) {
		out.println("<html><head><title>Plus</title></head><body>");
		out.println("<h1>整数でない値が入力されました</h1>");
		out.println("</body></head>");
	}

}
