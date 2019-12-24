package crud.management.business;

import java.util.List;

import crud.management.commons.EmployeeDTO;
import crud.management.persistence.model.Employee;

public interface EmployeeManager {
	
	
	EmployeeDTO getEmployeeById(int EmployeeID);
	List<Employee> listEmployees();
	public EmployeeDTO addEmployee(Employee Employee);

}
