package crud.management.persistence.model;

public class Team {
	
	private int teamID;
	private String teamName;

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
		return "TeamDTO [teamID=" + teamID + ", teamName=" + teamName + "]";
	}


}
