package crud.management.persistence.dao;


import java.util.List;

import crud.management.persistence.model.Manager;

public interface ManagerDAO {

	public RequestStatus addManager(Manager manager);
	public RequestStatus updateManager(Manager manager);
	public List<Manager> listManageri();
	public Manager getManagerById(int managerID);
	public RequestStatus removeManager(int managerID);
}
