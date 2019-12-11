package crud.management.persistence.dao;


import java.util.List;

import crud.management.persistence.model.Manager;

public interface ManagerDAO {

	public void addManager(Manager manager);
	public void updateManager(Manager manager);
	public List<Manager> listManageri();
	public Manager getManagerById(int managerID);
	public void removeManager(int managerID);
}
