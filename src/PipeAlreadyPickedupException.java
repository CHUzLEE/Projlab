
public class PipeAlreadyPickedupException extends Exception{
String error;
	
PipeAlreadyPickedupException()
	{
		error = "Más cső van a játékosnál már!";
	}
	
	void printOutMessage()
	{
		System.out.println(error);
	}
}
