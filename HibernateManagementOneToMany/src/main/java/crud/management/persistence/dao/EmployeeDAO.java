package crud.management.persistence.dao;

import java.util.List;

import crud.management.persistence.model.Employee;

public interface EmployeeDAO {

	public RequestStatus addEmployee(Employee Employee);
	public RequestStatus updateEmployee(Employee Employee);
	public List<Employee> listEmployees();
	public Employee getEmployeeById(int EmployeesD);
	public RequestStatus removeEmployee(int EmployeesD);

}
	

