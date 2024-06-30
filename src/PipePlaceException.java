
public class PipePlaceException extends Exception{
	String error;
	
	PipePlaceException()
	{
		error = "Nincs hely a csőnek már a játékelemen!";
	}
	
	void printOutMessage()
	{
		System.out.println(error);
	}
}
