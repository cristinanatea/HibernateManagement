package crud.management.business;

import crud.management.commons.LoginDTO;
import crud.management.commons.SignUpDTO;
import crud.management.commons.UtilizatorDTO;

public interface UtilizatorManager {
	/*
	UtilizatorDTOep getUtilizatorById(int utilizatorID);
	List<Utilizator> listUtilizatori();
	public UtilizatorDTOep  addUtilizator(Utilizator utilizator);
	public UtilizatorDTOep loginUtilizator(String email, String password);

*/

	public UtilizatorDTO getUserInfo(LoginDTO loginInfo);
	public UtilizatorDTO addUtilizator(SignUpDTO SignUpinfo);
}
