package crud.management.businessimpl;

import java.util.List;

import crud.management.business.ManagerManager;
import crud.management.commons.ManagerDTO;
import crud.management.persistence.dao.ManagerDAO;
import crud.management.persistence.model.Manager;

public class ManagerManagerImpl implements ManagerManager {

	ManagerDAO managerDao;
	ManagerDTO managerDTO;

	@Override
	public ManagerDTO getManagerById(int managerID) {
		Manager manager = managerDao.getManagerById(managerID);
		managerDTO.setName(manager.getName());
		return managerDTO;
	}

	@Override
	public List<Manager> listManageri() {
		
		return managerDao.listManagers();
	}

	@Override
	public ManagerDTO addManager(Manager manager) {
		managerDTO.setName(manager.getName());
		return managerDTO;
	}
}
