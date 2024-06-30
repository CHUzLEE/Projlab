
public class MoveException extends Exception{
	
	String error;
	
	MoveException()
	{
		error = "Nem lehet ide lépni!";
	}
	
	void printOutMessage()
	{
		System.out.println(error);
	}
}
