import java.util.ArrayList;

public class Saboteur extends Player {
	public Saboteur(int id, Moveable onMoveable, Pipe carriedPipe) {
		super(id, onMoveable, carriedPipe);
	}
    
    /**
     * Átállítja a pipe slippery értékét 5-re. Különben kivételt dob “Már csúszós volt a cső” üzenettel.
     * @param p
     */
    public void MakeSlippery(Pipe p) {
    	try {
    		p.MakeSlippery();
    	}
    	catch (PipeSlipperyException e) {
			e.printOutMessage();
		}
    }
}
