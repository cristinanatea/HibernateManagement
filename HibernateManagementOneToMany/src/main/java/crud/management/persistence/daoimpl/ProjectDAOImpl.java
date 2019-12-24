package crud.management.persistence.daoimpl;

import crud.management.persistence.dao.ProjectDAO;
import crud.management.persistence.dao.RequestStatus;
import crud.management.persistence.model.Project;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProjectDAOImpl implements ProjectDAO {

	private static final Logger logger = LoggerFactory.getLogger(ProjectDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public RequestStatus addProject(Project Project) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(Project);
		logger.info("Project saved successfully, Project Details=" + Project);
		return new RequestStatus();
	}

	public RequestStatus updateProject(Project Project) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(Project);
		logger.info("Project updated successfully, Project Details=" + Project);
		return new RequestStatus();
	}

	@SuppressWarnings("unchecked")

	public List<Project> listProjects() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Project> ProjectsList = session.createQuery("from Project").list();
		for (Project Project : ProjectsList) {
			logger.info("Project List::" + Project);
		}
		return ProjectsList;
	}

	public Project getProjectById(int ProjectID) {
		Session session = this.sessionFactory.getCurrentSession();
		Project Project = (Project) session.load(Project.class, new Integer(ProjectID));
		logger.info("Project loaded successfully, Project details=" + Project);
		return Project;
	}

	public RequestStatus removeProject(int ProjectID) {
		Session session = this.sessionFactory.getCurrentSession();
		Project Project = (Project) session.load(Project.class, new Integer(ProjectID));
		if (null != Project) {
			session.delete(Project);
		}
		logger.info("Employee deleted successfully, angajat details=" + Project);
		return new RequestStatus();
	}

}
