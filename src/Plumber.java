import java.util.ArrayList;

public class Plumber extends Player {

	// van-e a kezeben pumpa
    private boolean hasPump;
    // a pumpa amit hordoz
    private Pump carriedPump;

    /**
     * construktor, letrehoz egy szerelot a megadott adatokkal
     * @param id id
     * @param onMoveable tartózkodási hely
     * @param carriedPipe hordozott csővég
     * @param hasPump van-e nála pumpa
     * @param carriedPump hordozott pumpa
     */
    public Plumber(int id, Moveable onMoveable, Pipe carriedPipe, boolean hasPump, Pump carriedPump) {
    	super(id, onMoveable, carriedPipe);
    	this.hasPump = hasPump;
    	this.carriedPump = carriedPump;
    }
    

	public boolean IsHasPump() {
		return hasPump;
	}

	public void SetHasPump(boolean hasPump) {
		this.hasPump = hasPump;
	}

	public Pump GetCarriedPump() {
		return carriedPump;
	}

	public void SetCarriedPump(Pump carriedPump) {
		this.carriedPump = carriedPump;
	}
    
    /**
     * Egy javítható játékelem megjavítása/befoltozása. Meghívja a fixable paraméter Fix függvényét.
     * @param f
     */
    public void Fix(Fixable f) {	
    	f.Fix();
    }
    
    /** TODO Nem tudom, hogy miert kell az AddCarriedPump ide (doksiban ez le van irva
     * Ha a carriedPump null, akkor meghívja a cistern
     * GivePump függvényét, ami vissza ad egy új pumpát.
     * @param c
     * @throws Exception
     */
    public void GetPump(Cistern c) throws PumpAlreadyPickedupException{
        if (carriedPump == null) {
            carriedPump = c.GivePump();
        }
        else {
        	throw new PumpAlreadyPickedupException();
        }
    }
    
    /**
     * Ha a carriedPump null, kivételt dob “Nincs letehető pumpa” üzenettel. Ha van akkor, létrehoz egy új csövet newPipe néven és összecsatlakozza a az új csövet a pumpára
     * @param p
     * @throws Exception
     */
    public void PlacePump(Pipe p) throws NoPumpPickedupException, PipePiercedPlacePumpException{
    	if(carriedPump == null) {
    		throw new NoPumpPickedupException();
    	}
    		else if (!p.isWorking())
    		{
    			throw new PipePiercedPlacePumpException();
    		}
    	
    	else {
    		ArrayList<Element> createdPipes = new ArrayList<Element>();
    		createdPipes.add(null);
    		createdPipes.add(null);
    		Pipe newPipe = new  Pipe(0, true, 10, false, 0, 0,0, createdPipes);
    		Element oldEndPoint = null;
			try {
				oldEndPoint = p.GetEndPoint();
			} catch (PipeGetEndpointException e) {
				e.printOutMessage();
			}
    		try {
				p.RemoveEndPoint(oldEndPoint);
			} catch (PipeRemoveEndpointException e) {
				e.printOutMessage();
			}
    		try {
				p.AddEndPoint(carriedPump);
			} catch (PipeSetEndpointException e) {
				e.printOutMessage();
			}
    		try {
				newPipe.AddEndPoint(carriedPump);
			} catch (PipeSetEndpointException e) {
				e.printOutMessage();
			}
    	    try {
				newPipe.AddEndPoint(oldEndPoint);
			} catch (PipeSetEndpointException e) {
				e.printOutMessage();
			}
    	    carriedPump = null;
    	}
    }
}
