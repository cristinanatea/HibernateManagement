package crud.management.businessimpl;

import java.util.List;

import crud.management.business.AngajatManager;
import crud.management.commons.AngajatDTO;
import crud.management.persistence.dao.AngajatDAO;
import crud.management.persistence.model.Angajat;

public class AngajatManagerImpl  implements AngajatManager{
	
	AngajatDAO angajatDao;
	AngajatDTO angajatDTO;

	@Override
	public AngajatDTO getAngajatById(int angajatID) {
	
		 Angajat angajat = angajatDao.getAngajatById(angajatID);
		  angajatDTO.setNume(angajat.getNume());
		  return angajatDTO;
	}

	@Override
	public List<Angajat> listAngajati() {
	
		return angajatDao.listAngajati();
	}

	@Override
	public AngajatDTO addAngajat(Angajat angajat) {
		angajatDTO.setPrenume(angajat.getPrenume());
		return angajatDTO;
	}
	    
}
