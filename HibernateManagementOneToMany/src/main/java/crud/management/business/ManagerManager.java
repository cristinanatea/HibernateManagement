package crud.management.business;


import java.util.List;

import crud.management.commons.ManagerDTO;
import crud.management.persistence.dao.RequestStatus;
import crud.management.persistence.model.Manager;

public interface ManagerManager {
	
	
	ManagerDTO getManagerById(int managerID);
	List<Manager> listManageri();
	public ManagerDTO addManager(Manager manager);

}