
public class PumpInputException extends Exception{
String error;
	
	PumpInputException()
	{
		error = "Ez a cső nincs csatlakoztatva ehhez a pumpához!";
	}
	
	void printOutMessage()
	{
		System.out.println(error);
	}
}
