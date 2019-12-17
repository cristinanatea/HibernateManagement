package crud.management.persistence.dao;

import java.sql.SQLException;
import java.util.List;

import crud.management.commons.UtilizatorDTO;
import crud.management.persistence.model.Utilizator;

public interface UtilizatorDAO {

	public RequestStatus addUtilizator(Utilizator utilizator);
	public RequestStatus updateUtilizator(Utilizator utilizator);
	public List<Utilizator> listUtilizatori();
	public Utilizator getUtilizatorById(int utilizatorID);
	public RequestStatus removeUtilizator(int utilizatorID);
	public UtilizatorDTO loginUtilizator(String email, String password) ;
    public UtilizatorDTO  signupUtilizator(String nume, String companyName, String phoneNumber, String password);
}
