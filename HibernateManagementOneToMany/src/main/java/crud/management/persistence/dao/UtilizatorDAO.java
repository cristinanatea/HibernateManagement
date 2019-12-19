package crud.management.persistence.dao;


import java.util.List;

import crud.management.commons.UtilizatorDTOep;
import crud.management.persistence.model.Utilizator;

public interface UtilizatorDAO {

	public RequestStatus addUtilizator(Utilizator utilizator);
	public RequestStatus updateUtilizator(Utilizator utilizator);
	public List<Utilizator> listUtilizatori();
	public Utilizator getUtilizatorById(int utilizatorID);
	public RequestStatus removeUtilizator(int utilizatorID);
	public UtilizatorDTOep loginUtilizator(String email, String password);
    /*public UtilizatorDTO  signupUtilizator(String nume, String companyName, String phoneNumber, String password);*/
}
