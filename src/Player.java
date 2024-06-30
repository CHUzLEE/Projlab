import java.util.ArrayList;
import java.util.Arrays;

public abstract class Player {
	// jatekos unique ID-je
    private int id;
    // a jatekos pozicioja
    private Moveable onMoveable;
    // A csovek, amik a kezeben van
    private Pipe carriedPipe;
    
    /**
     * letrehozza a jatkeost a megadott parameterekkel
     * @param id
     * @param onMoveable
     * @param carriedPipe
     */
    public Player(int id,Moveable onMoveable, Pipe carriedPipe) {
    	this.id = id;
    	this.onMoveable = onMoveable;
    	this.carriedPipe = carriedPipe;
    }
    
    public int getId() { return id; }
    
    public Moveable getOnMoveable() {
    	return onMoveable;
    }
    
    public Pipe getCarriedPipe() {
    	return carriedPipe;
    }

    /**
     * A megadott destination paraméterre meghívja
     * a MoveHere-t és az onMoveable-t beállítja a visszakapott értékre. Ezt egy try-catch
     * blokkba kell tenni, mivel ha nem lehet a destination paraméterre lépni, kivételt fog
     * dobni a program.
     * @param m
     */
    public void Move(Moveable m) {
    	try {		
    		if(onMoveable.canMoveAway()) {
    			onMoveable = m.MoveHere(onMoveable) ;
    		}
        }
        catch(MoveException e) {
        	e.printOutMessage();
        }
    }
    
    /**
     * Meghívja a SetOutput fgv.t a
     * paraméterben megadott pumpára pipe paraméterrel.
     * @param pump
     * @param pipe
     */
    public void ChangePumpOutput(Pump pump, Pipe pipe) {     
        try {
			pump.SetOutputId(pipe);
		} catch (PumpOutputException e) {
			e.printOutMessage();
		}
    }
    
    /**
     * Meghívja a SetInput fgv.t a
     * paraméterben megadott pumpára pipe paraméterrel.
     * @param pump
     * @param pipe
     */
    public void ChangePumpInput(Pump pump, Pipe pipe) {
        try {
			pump.SetInputId(pipe);
		} catch (PumpInputException e) {
			e.printOutMessage();
		}
    }
    
    /**
     * Meghívja az AddCarriedPipe-ot a
     * pipe paraméterrel. Ezután meghívja a RemovePipe-ot a paraméterben megadott
     * elementre pipe paraméterrel. Ezt egy try-catch blokkban kell megvalósítani, mivel az
     * AddCarriedPipe kivételt dobhat, ha már van felvéve másik cső a játékosnál.
     * @param p
     * @param e
     */
    public void DetachPipe(Pipe p, Element e)  {
    	try {
			e.RemovePipe(p);
    		this.AddCarriedPipe(p);
    	}
    	catch (PipeAlreadyPickedupException e1) {
    		e1.printOutMessage();
		}
         
    }
    
    /**
     * Ha a carriedPipe null, akkor
     * Exception-t dob “Nincs felvéve cső” üzenettel. Különben meghívja a AddPipe-ot a
     * paraméterben megadott Elementre. Aztán hívja magára a RemoveCarriedPipe
     * függvényt pipe paraméterrel.
     * @param p
     * @param e
     * @throws Exception
     */
    public void AttachPipe(Element e) throws NoPickedupPipeException {
    	if(carriedPipe == null) {
    		throw new NoPickedupPipeException();
    	}
    	try
    	{
    		e.Addpipe(carriedPipe);
			if (carriedPipe.getEndPoints().get(0) == null)
				carriedPipe.setEndPoints(new ArrayList<>(Arrays.asList(e, carriedPipe.getEndPoints().get(1))));
			else if (carriedPipe.getEndPoints().get(1) == null)
				carriedPipe.setEndPoints(new ArrayList<>(Arrays.asList(carriedPipe.getEndPoints().get(0), e)));
    		this.RemoveCarriedPipe(carriedPipe);
        	
    	}
    	catch(PipePlaceException g)
    	{
    		g.printOutMessage();
    		throw new NoPickedupPipeException();
    	}
    	

    }
    
    /**
     * Hogyha nincs még elem a carriePipe-ban
     * hozzáadja, különben kivételt dob “Más cső van a játékosnál” üzenettel.
     * @param p A cső amelyet a játékos felvesz.
     */
    public void AddCarriedPipe(Pipe p) throws PipeAlreadyPickedupException {
    	if(carriedPipe != null) {
    		//exception throw
    		throw new PipeAlreadyPickedupException();
    	}
    	carriedPipe = p;
    }
    
    /**
     * Kitörli a pipe csövet a carriedPipe listából.
     * Kivételt dob, ha a pipe cső nincs a listában “Nincs ilyen cső felvéve” üzenettel.
     * @param p
     */
    public void RemoveCarriedPipe(Pipe p){
    	carriedPipe = null;
    }
    /**
     * Ha a pipe sabotageable változója 0, vagyis ki lehet
     * lyukasztani a csövet, meghívja a pipe Disable fgv-ét. Különben kivételt dob “Nem
     * lehet még kilyukasztani a csövet” üzenettel.
     * @param pipe
     */
    public void Sabotage(Pipe pipe) throws PipeSabotageableException {
    	if(pipe.getsabotageable() == 0) {
    		pipe.Disable();
    	}
    	else {
    		throw new PipeSabotageableException();
    	}
    }
    
    /**
     * Meghívja a pipe slippery értéke 0, átállítja a pipe sticky
     * értékét 5-re. Különben kivételt dob “Már ragadós volt a cső” üzenettel.
     * @param pipe
     * @throws Exception
     */
    public void MakeSticky(Pipe pipe) throws PipeStickyException {
    	if(pipe.getSticky() == 0) {
    		pipe.MakeSticky();
    	}
    	else {
    		throw new PipeStickyException();
    	}
    }
    
}
