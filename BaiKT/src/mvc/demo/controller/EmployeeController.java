package mvc.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.demo.bean.EmpBean;
import mvc.demo.bean.PositionBean;
import mvc.demo.dao.EmployeeModel;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/employee")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeModel empModel = new EmployeeModel();
		List<EmpBean> emps = empModel.getListEmployee();
		List<PositionBean> pos = empModel.getListPosition();
		for(int i = 0; i < emps.size();i++) {
			for(int j = 0; j <pos.size(); j++) {
				if(emps.get(i).getPosition_id().equals(pos.get(j).getId())) {
					emps.get(i).setStastus(pos.get(j).getName());
				}
			}
		}
		
		request.setAttribute("emps", emps);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
