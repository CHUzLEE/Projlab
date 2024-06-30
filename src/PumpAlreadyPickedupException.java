
public class PumpAlreadyPickedupException extends Exception{
String error;
	
PumpAlreadyPickedupException()
	{
		error = "Van már egy felvett pumpa a játékosnál!";
	}
	
	void printOutMessage()
	{
		System.out.println(error);
	}
}
