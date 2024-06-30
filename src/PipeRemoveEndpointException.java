
public class PipeRemoveEndpointException extends Exception{
String error;
	
	PipeRemoveEndpointException()
	{
		error = "A paraméterben megadott element nincs eleve csatlakozva a csőre!";
	}
	
	void printOutMessage()
	{
		System.out.println(error);
	}
}