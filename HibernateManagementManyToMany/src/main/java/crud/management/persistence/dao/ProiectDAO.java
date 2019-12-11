package crud.management.persistence.dao;


import java.util.List;

import crud.management.persistence.model.Proiect;

public interface ProiectDAO {

	public void addProiect(Proiect m);
	public void updateProiect(Proiect proiect);
	public List<Proiect> listProiecte();
	public Proiect getProiectById(int proiectID);
	public void removeProiect(int proiectID);
}
