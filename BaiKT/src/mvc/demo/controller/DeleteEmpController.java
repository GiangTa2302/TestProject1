package mvc.demo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.demo.bean.EmpBean;
import mvc.demo.dao.EmployeeModel;

/**
 * Servlet implementation class DeleteEmpController
 */
@WebServlet("/delete")
public class DeleteEmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEmpController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id1 = request.getParameter("id");
		Long id = Long.parseLong(id1);
		
		EmpBean emp = new EmpBean();
		emp.setId(id);
		
		EmployeeModel delete = new EmployeeModel();
		delete.removeEmployee(emp);
		
		response.sendRedirect("employee");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
