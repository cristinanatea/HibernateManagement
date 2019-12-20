package crud.management.persistence.dao;


import java.util.List;

import crud.management.commons.LoginDTO;
import crud.management.commons.SignUpDTO;
import crud.management.persistence.model.Utilizator;

public interface UtilizatorDAO {

	public Utilizator addUtilizator(Utilizator utilizator);
	public RequestStatus updateUtilizator(Utilizator utilizator);
	public List<Utilizator> listUtilizatori();
	public Utilizator getUtilizatorById(int utilizatorID);
	public RequestStatus removeUtilizator(int utilizatorID);
	public Utilizator loginUtilizator(String email, String password);
	
	public Utilizator getUser(LoginDTO info);
    public Utilizator addUtilizator(SignUpDTO info);
}
