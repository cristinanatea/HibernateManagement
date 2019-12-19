package crud.management.persistence.dao;

import java.util.List;

import crud.management.persistence.model.Angajat;

public interface AngajatDAO {

	public RequestStatus addAngajat(Angajat angajat);
	public RequestStatus updateAngajat(Angajat angajat);
	public List<Angajat> listAngajati();
	public Angajat getAngajatById(int angajatID);
	public RequestStatus removeAngajat(int angajatID);

}
	

