package crud.management.persistence.dao;


import java.util.List;

import crud.management.commons.LoginDTO;
import crud.management.persistence.model.Utilizator;

public interface UtilizatorDAO {

	public RequestStatus addUtilizator(Utilizator utilizator);
	public RequestStatus updateUtilizator(Utilizator utilizator);
	public List<Utilizator> listUtilizatori();
	public Utilizator getUtilizatorById(int utilizatorID);
	public RequestStatus removeUtilizator(int utilizatorID);
	public Utilizator loginUtilizator(String email, String password);
	
	public Utilizator getUser(LoginDTO info);
    /*public UtilizatorDTO  signupUtilizator(String nume, String companyName, String phoneNumber, String password);*/
}
