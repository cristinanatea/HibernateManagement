package crud.management.commons;
import java.io.Serializable;


public class ProjectDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	 private int projectID;
	 private int managerID;
	 private String description;
	 private String startDate;
	 private String endDate;
	 
	public int getProjectID() {
		return projectID;
	}
	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}
	public int getManagerID() {
		return managerID;
	}
	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "ProiectDTO [projectID=" + projectID + ", managerID=" + managerID + ", description=" + description
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	 
   
	
	
}