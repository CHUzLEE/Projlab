
public class NoPumpPickedupException extends Exception{
	String error;
	
	NoPumpPickedupException()
		{
			error = "Nincs pumpa a játékosnál!";
		}
		
		void printOutMessage()
		{
			System.out.println(error);
		}
}
