package crud.management.persistence.dao;

import java.sql.SQLException;
import java.util.List;

import crud.management.persistence.model.Utilizator;

public interface UtilizatorDAO {

	public RequestStatus addUtilizator(Utilizator utilizator);
	public RequestStatus updateUtilizator(Utilizator utilizator);
	public List<Utilizator> listUtilizatori();
	public Utilizator getUtilizatorById(int utilizatorID);
	public RequestStatus removeUtilizator(int utilizatorID);
	public Utilizator loginUtilizator(String email, String password) throws SQLException, ClassNotFoundException;

}
