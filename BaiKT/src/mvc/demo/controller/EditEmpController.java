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
 * Servlet implementation class EditEmpController
 */
@WebServlet("/edit")
public class EditEmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmpController() {
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
		
		EmployeeModel edit = new EmployeeModel();
		EmpBean e = edit.getEmpById(emp);
		
		List<PositionBean> pos = edit.getListPosition();
		request.setAttribute("pos", pos);
		
		request.setAttribute("emp", e);
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id1 = request.getParameter("id");
		Long id = Long.parseLong(id1);
		String emp_code = request.getParameter("emp_code");
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String position_id = request.getParameter("position_id");
		EmpBean emp = new EmpBean();
		emp.setId(id);
		emp.setEmp_code(emp_code);
		emp.setName(name);
		emp.setBirthday(birthday);
		emp.setGender(gender);
		emp.setAddress(address);
		emp.setPosition_id(position_id);
		
		EmployeeModel editDao = new EmployeeModel();
		editDao.editEmployee(emp);
		
		response.sendRedirect("employee");
	}

}
