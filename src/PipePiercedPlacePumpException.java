
public class PipePiercedPlacePumpException extends Exception{
String error;
	
	PipePiercedPlacePumpException()
	{
		error = "Kilyukasztott csore nem lehet pumpat rakni!";
	}
	
	void printOutMessage()
	{
		System.out.println(error);
	}
}


