package crud.management.business;

import java.util.List;


import crud.management.commons.UtilizatorDTOep;
import crud.management.persistence.dao.RequestStatus;
import crud.management.persistence.model.Utilizator;

public interface UtilizatorManager {
	
	UtilizatorDTOep getUtilizatorById(int utilizatorID);
	List<Utilizator> listUtilizatori();
	public UtilizatorDTOep  addUtilizator(Utilizator utilizator);
	public UtilizatorDTOep loginUtilizator(String email, String password);


}
