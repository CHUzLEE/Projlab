
public class PipeSetEndpointException extends Exception{
	String error;
	
	PipeSetEndpointException()
	{
		error = "Az adott csőnek mindkét vége csatalakoztatva van!";
	}
	
	void printOutMessage()
	{
		System.out.println(error);
	}
	
}
