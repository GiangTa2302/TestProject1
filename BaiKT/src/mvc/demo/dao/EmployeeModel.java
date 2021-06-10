package mvc.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mvc.demo.ConnectionUtils.ConnectionUtils;
import mvc.demo.bean.EmpBean;
import mvc.demo.bean.PositionBean;

public class EmployeeModel {
	
	public List<EmpBean> getListEmployee() {
		try(Connection conn = ConnectionUtils.getConnection();){
			Statement ppstm = conn.createStatement();
			
			ResultSet rs = ppstm.executeQuery("select * from employee");
			
			List<EmpBean> listEmp = new ArrayList<>();
			while(rs.next()) {
				EmpBean emp = new EmpBean();
				emp.setId(rs.getLong("id"));
				emp.setEmp_code(rs.getString("emp_code"));
				emp.setName(rs.getString("name"));
				emp.setBirthday(rs.getString("birthday"));
				emp.setAddress(rs.getString("address"));
				emp.setGender(rs.getString("gender"));
				emp.setPosition_id(rs.getString("position_id"));
				emp.setStastus(rs.getString("stastus"));
				listEmp.add(emp);
			}
			return listEmp;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public void addEmployee(EmpBean emp) {
		try(Connection conn = ConnectionUtils.getConnection();){
			PreparedStatement ppstm = conn.prepareStatement("insert into employee (emp_code, name, birthday, address, gender, position_id)\r\n"
					+ "values (?,?,?,?,?,?)");
			ppstm.setString(1, emp.getEmp_code());
			ppstm.setString(2, emp.getName());
			ppstm.setString(3, emp.getBirthday());
			ppstm.setString(4, emp.getAddress());
			ppstm.setString(5, emp.getGender());
			ppstm.setString(6, emp.getPosition_id());
			
			ppstm.executeUpdate();

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public EmpBean getEmpById(EmpBean emp) {
		try(Connection conn = ConnectionUtils.getConnection();){
			PreparedStatement ppstm = conn.prepareStatement("select * from employee where id=?");
			ppstm.setLong(1, emp.getId());
			
			ResultSet rs =  ppstm.executeQuery();
			while(rs.next()) {
				emp.setId(rs.getLong("id"));
				emp.setEmp_code(rs.getString("emp_code"));
				emp.setName(rs.getString("name"));
				emp.setBirthday(rs.getString("birthday"));
				emp.setAddress(rs.getString("address"));
				emp.setGender(rs.getString("gender"));
				emp.setPosition_id(rs.getString("position_id"));
				emp.setStastus(rs.getString("stastus"));
			}
			return emp;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void editEmployee(EmpBean emp) {
		try(Connection conn = ConnectionUtils.getConnection();){
			PreparedStatement ppstm = conn.prepareStatement("update employee set emp_code=?,name=?,birthday=?,address=?,gender=?,position_id=? where id=?");
			
			ppstm.setString(1, emp.getEmp_code());
			ppstm.setString(2, emp.getName());
			ppstm.setString(3, emp.getBirthday());
			ppstm.setString(4, emp.getAddress());
			ppstm.setString(5, emp.getGender());
			ppstm.setString(6, emp.getPosition_id());
			ppstm.setLong(7, emp.getId());
			
			ppstm.executeUpdate();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void removeEmployee(EmpBean emp) {
		try(Connection conn = ConnectionUtils.getConnection();){
			PreparedStatement ppstm = conn.prepareStatement("delete from employee where id=?");
			ppstm.setLong(1, emp.getId());
			
			ppstm.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<PositionBean> getListPosition() {
		try(Connection conn = ConnectionUtils.getConnection();){
			Statement ppstm = conn.createStatement();
			
			ResultSet rs = ppstm.executeQuery("select * from position");
			List<PositionBean> listPosition = new ArrayList<>();
			while(rs.next()) {
				PositionBean position = new PositionBean();
				position.setId(rs.getString("id"));
				position.setName(rs.getString("name"));
				position.setStatus(rs.getString("status"));
				listPosition.add(position);
			}
			return listPosition;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
