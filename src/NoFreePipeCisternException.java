
public class NoFreePipeCisternException extends Exception{
String error;
	
	NoFreePipeCisternException()
	{
		error = "Nincs szabad csoveg a ciszternanal!";
	}
	
	void printOutMessage()
	{
		System.out.println(error);
	}
}
