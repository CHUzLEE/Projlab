
public class PipeSlipperyException extends Exception{
String error;
	
	PipeSlipperyException()
	{
		error = "Ez a cső már csúszós!";
	}
	
	void printOutMessage()
	{
		System.out.println(error);
	}
}