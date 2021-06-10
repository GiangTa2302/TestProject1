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
 * Servlet implementation class AddEmpController
 */
@WebServlet("/add")
public class AddEmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmpController() {
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
		String emp_code = request.getParameter("emp_code");
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String position_id = request.getParameter("position_id");
		
		
		EmpBean emp = new EmpBean();
		emp.setEmp_code(emp_code);
		emp.setName(name);
		emp.setBirthday(birthday);
		emp.setAddress(address);
		emp.setGender(gender);
		emp.setPosition_id(position_id);
		
		EmployeeModel create = new EmployeeModel();
		create.addEmployee(emp);
		response.sendRedirect("employee");
	}

}
