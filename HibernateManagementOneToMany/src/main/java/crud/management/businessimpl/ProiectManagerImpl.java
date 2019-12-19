package crud.management.businessimpl;

import java.util.List;

import crud.management.business.ProiectManager;
import crud.management.commons.ProiectDTO;
import crud.management.persistence.dao.ProiectDAO;
import crud.management.persistence.model.Proiect;

public class ProiectManagerImpl implements ProiectManager {
	
	ProiectDAO proiectDao;
	ProiectDTO proiectDTO;

	@Override
	public ProiectDTO getProiectById(int proiectID) {
		Proiect proiect = proiectDao.getProiectById(proiectID);
		proiectDTO.setCoordonatorID(proiect.getCoordonatorID());
		return proiectDTO;
	}

	public List<Proiect> listProiecte() {
		// TODO Auto-generated method stub
		return proiectDao.listProiecte();
	}

	@Override
	public ProiectDTO addProiect(Proiect proiect) {
		proiectDTO.setCoordonatorID(proiect.getCoordonatorID());
		return proiectDTO;
	}

}
