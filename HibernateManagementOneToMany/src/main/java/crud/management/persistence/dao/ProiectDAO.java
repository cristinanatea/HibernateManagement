package crud.management.persistence.dao;


import java.util.List;

import crud.management.persistence.model.Proiect;

public interface ProiectDAO {

	public RequestStatus addProiect(Proiect proiect);
	public RequestStatus updateProiect(Proiect proiect);
	public List<Proiect> listProiecte();
	public Proiect getProiectById(int proiectID);
	public RequestStatus removeProiect(int proiectID);
}
