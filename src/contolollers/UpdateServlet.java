package contolollers;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Task;
import models.validators.TaskValidator;
import utils.DBUtil;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
    }
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //CSRF対策
	    String _token = request.getParameter("_token");
	    if(_token!=null&&_token.equals(request.getSession().getId())) {
	         EntityManager em = DBUtil.createEntityManager();
	         Task t = em.find(Task.class,(Integer)request.getSession().getAttribute("task_id"));
	         //それぞれ上書き
	         String content = request.getParameter("content");
	         t.setContent(content);

	         Timestamp currentTime = new Timestamp(System.currentTimeMillis());
	         t.setUpdated_at(currentTime);
	         //入力確認
	         List errors = TaskValidator.validate(t);
	            if(errors.size()>0) {
	                em.close();
	                request.setAttribute("_token",request.getSession().getId());
	                request.setAttribute("task",t);
	                request.setAttribute("errors",errors);

	                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tasks/edit.jsp");
	                rd.forward(request, response);
	            }else {

	         //DB更新
	         em.getTransaction().begin();
	         em.getTransaction().commit();
	         request.getSession().setAttribute("flush","更新が完了しました");
	         em.close();

	         //不要データの削除
	         request.getSession().removeAttribute("task_id");

	         //リダイレクト
	         response.sendRedirect(request.getContextPath()+"/index");
	            }
	    }
	}
}
