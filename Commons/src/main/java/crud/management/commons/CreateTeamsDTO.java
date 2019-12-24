package crud.management.commons;

public class CreateTeamsDTO {
	private int employeeID;
	private int positionID;
	private int projectID;
	private int managerID;
	private String managerName;
	private String employeeName;
	private String employeeForname;
	private int teamID;
	private String teamName;

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public int getPositionID() {
		return positionID;
	}

	public void setPositionID(int positionID) {
		this.positionID = positionID;
	}

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

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeForname() {
		return employeeForname;
	}

	public void setEmployeeForname(String employeeForname) {
		this.employeeForname = employeeForname;
	}

	public int getTeamID() {
		return teamID;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	@Override
	public String toString() {
		return "CreateTeamsDTO [employeeID=" + employeeID + ", positionID=" + positionID + ", projectID=" + projectID
				+ ", managerID=" + managerID + ", managerName=" + managerName + ", employeeName=" + employeeName
				+ ", employeeForname=" + employeeForname + ", teamID=" + teamID + ", teamName=" + teamName + "]";
	}

}