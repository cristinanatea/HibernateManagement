package crud.management.persistence.dao;

public class RequestStatus {
	
	int  status;
	String errorMessage;
	
	public RequestStatus()
	{
		status = 0;
		errorMessage = "OK";
    }
}
