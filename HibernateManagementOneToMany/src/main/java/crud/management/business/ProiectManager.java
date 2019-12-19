package crud.management.business;

import java.util.List;

import crud.management.commons.ProiectDTO;
import crud.management.persistence.dao.RequestStatus;
import crud.management.persistence.model.Proiect;

public interface ProiectManager {
	
	ProiectDTO getProiectById(int proiectID);
	List<Proiect> listProiecte();
	public ProiectDTO addProiect(Proiect proiect);

}



