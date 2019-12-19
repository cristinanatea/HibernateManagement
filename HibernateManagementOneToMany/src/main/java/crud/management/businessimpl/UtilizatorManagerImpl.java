package crud.management.businessimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import crud.management.business.UtilizatorManager;
import crud.management.commons.LoginDTO;
import crud.management.commons.UtilizatorDTO;
import crud.management.persistence.dao.UtilizatorDAO;
import crud.management.persistence.model.Utilizator;

public class UtilizatorManagerImpl implements UtilizatorManager {


	static Session sessionObj;

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}
	/*
	UtilizatorDTOep utilizatorDTO;

	
	public UtilizatorDTOep getUtilizatorById(int utilizatorID) {
		Utilizator utilizator = utilizatorDao.getUtilizatorById(utilizatorID);
		utilizatorDTO.setEmail(utilizator.getEmail());
		return utilizatorDTO;
	}
	

	public List<Utilizator> listUtilizatori() {
	
		return utilizatorDao.listUtilizatori();
	}

	@Override
	public UtilizatorDTOep addUtilizator(Utilizator utilizator) {
		utilizatorDTO.setEmail(utilizator.getEmail());
		return utilizatorDTO;
	}
	
	public UtilizatorDTOep loginUtilizator(String email, String password) {
		UtilizatorDTOep utilizatorDTO = new UtilizatorDTOep();
		UtilizatorDTOep userLogin = utilizatorDao.loginUtilizator(email, password);
		utilizatorDTO.setEmail(userLogin.getEmail());
		return utilizatorDTO;
	}
*/

	public UtilizatorDTO getUserInfo(LoginDTO loginInfo) {

		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		UtilizatorDAO userDAO = (UtilizatorDAO) factory.getBean("utilizatorDAO");
		
		Utilizator uti = userDAO.getUser(loginInfo);
		
		if (uti != null) {
			return new UtilizatorDTO(uti.getEmail(), uti.getNume());
		}
		
		return null;
	}
}
