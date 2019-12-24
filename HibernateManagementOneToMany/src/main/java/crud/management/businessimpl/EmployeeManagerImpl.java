package crud.management.businessimpl;

import java.util.List;

import crud.management.business.EmployeeManager;
import crud.management.commons.EmployeeDTO;
import crud.management.persistence.dao.EmployeeDAO;
import crud.management.persistence.model.Employee;

public class EmployeeManagerImpl  implements EmployeeManager{
	
	EmployeeDAO EmployeeDao;
	EmployeeDTO EmployeeDTO;

	@Override
	public EmployeeDTO getEmployeeById(int EmployeeID) {
	
		 Employee Employee = EmployeeDao.getEmployeeById(EmployeeID);
		  EmployeeDTO.setName(Employee.getName());
		  return EmployeeDTO;
	}

	@Override
	public List<Employee> listEmployees() {
	
		return EmployeeDao.listEmployees();
	}

	@Override
	public EmployeeDTO addEmployee(Employee Employee) {
		EmployeeDTO.setForname(Employee.getForname());
		return EmployeeDTO;
	}
	    
}
