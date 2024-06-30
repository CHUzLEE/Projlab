
public class PipeGetEndpointException extends Exception{
String error;
	
	PipeGetEndpointException()
	{
		error = "Az adott cső nincs sehova csatlakoztatva!";
	}
	
	void printOutMessage()
	{
		System.out.println(error);
	}
	
}