package crud.management.business;

import java.util.List;

import crud.management.commons.AngajatDTO;
import crud.management.persistence.model.Angajat;

public interface AngajatManager {
	
	
	AngajatDTO getAngajatById(int angajatID);
	List<Angajat> listAngajati();
	public AngajatDTO addAngajat(Angajat angajat);

}
