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
		managerDTO.setNume(manager.getNume());
		return managerDTO;
	}

	@Override
	public List<Manager> listManageri() {
		
		return managerDao.listManageri();
	}

	@Override
	public ManagerDTO addManager(Manager manager) {
		managerDTO.setNume(manager.getNume());
		return managerDTO;
	}
}
