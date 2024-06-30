
public class PipeSabotageableException extends Exception{
	String error;
	
	PipeSabotageableException()
		{
			error = "Még nem lehet ezt a csövet újra kilyukasztani!";
		}
		
		void printOutMessage()
		{
			System.out.println(error);
		}
}
