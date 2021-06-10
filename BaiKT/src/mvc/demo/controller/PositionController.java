package mvc.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.demo.bean.PositionBean;
import mvc.demo.dao.EmployeeModel;

/**
 * Servlet implementation class PositionController
 */
@WebServlet("/position")
public class PositionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PositionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeModel empModel = new EmployeeModel();
		List<PositionBean> pos = empModel.getListPosition();
		request.setAttribute("pos", pos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
		dispatcher.forward(request, response);
	}

}
