
public class PipeStickyException extends Exception{
String error;
	
	PipeStickyException()
	{
		error = "Ez a cső már ragadós!";
	}
	
	void printOutMessage()
	{
		System.out.println(error);
	}
}