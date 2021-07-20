//新規登録用サーブレット

package contolollers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Task;
import utils.DBUtil;

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
	    EntityManager em = DBUtil.createEntityManager();
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

	}
}
