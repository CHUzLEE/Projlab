
public class NoPickedupPipeException extends Exception{
String error;
	
	NoPickedupPipeException()
	{
		error = "Nincs felvéve cső!";
	}
	
	void printOutMessage()
	{
		System.out.println(error);
	}
}

