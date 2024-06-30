
public class PumpOutputException extends Exception{
String error;
	
	PumpOutputException()
	{
		error = "Ez a cső nincs csatlakoztatva ehhez a pumpához!";
	}
	
	void printOutMessage()
	{
		System.out.println(error);
	}
}


