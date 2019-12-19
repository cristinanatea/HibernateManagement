package crud.management.businessimpl;

import java.util.List;

import crud.management.business.UtilizatorManager;
import crud.management.commons.UtilizatorDTOep;
import crud.management.persistence.dao.UtilizatorDAO;
import crud.management.persistence.model.Utilizator;

public class UtilizatorManagerImpl implements UtilizatorManager {
	
	UtilizatorDAO utilizatorDao;
	UtilizatorDTOep utilizatorDTO;

	
	public UtilizatorDTOep getUtilizatorById(int utilizatorID) {
		Utilizator utilizator = utilizatorDao.getUtilizatorById(utilizatorID);
		utilizatorDTO.setEmail(utilizator.getEmail());
		return utilizatorDTO;
	}
	

	public List<Utilizator> listUtilizatori() {
	
		return utilizatorDao.listUtilizatori();
	}

	@Override
	public UtilizatorDTOep addUtilizator(Utilizator utilizator) {
		utilizatorDTO.setEmail(utilizator.getEmail());
		return utilizatorDTO;
	}
	
	public UtilizatorDTOep loginUtilizator(String email, String password) {
		UtilizatorDTOep utilizatorDTO = new UtilizatorDTOep();
		UtilizatorDTOep userLogin = utilizatorDao.loginUtilizator(email, password);
		utilizatorDTO.setEmail(userLogin.getEmail());
		return utilizatorDTO;
	}

}
