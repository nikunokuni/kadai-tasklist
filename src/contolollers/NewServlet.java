//新規登録用サーブレット

package contolollers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Task;

/**
 * Servlet implementation class NewServlet
 */
@WebServlet("/new")
public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //CSRF　セキュリティ対策
	    request.setAttribute("_token",request.getSession().getId());

	    request.setAttribute("task",new Task());

	    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/tasks/new.jsp");
        rd.forward(request, response);
	    /*EntityManager em = DBUtil.createEntityManager();
	    em.getTransaction().begin();

	    Task t = new Task();

	    String content = new java.util.Scanner(System.in).nextLine();
	    t.setContent(content);

	    Timestamp currentTime = new Timestamp(System.currentTimeMillis());
	    t.setCreated_at(currentTime);
	    t.setUpdetad_at(currentTime);

	    em.persist(t);
	    em.getTransaction().commit();

	    em.close();
	    */

	}
}
