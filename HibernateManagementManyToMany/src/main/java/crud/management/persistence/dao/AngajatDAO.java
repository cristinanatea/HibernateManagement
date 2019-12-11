package crud.management.persistence.dao;

import java.util.List;

import crud.management.persistence.model.Angajat;

public interface AngajatDAO {

	public void addAngajat(Angajat angajat);
	public void updateAngajat(Angajat angajat);
	public List<Angajat> listAngajati();
	public Angajat getAngajatById(int angajatID);
	public void removeAngajat(int angajatID);
}
