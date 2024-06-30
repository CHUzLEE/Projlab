import java.util.ArrayList;

public class Cistern extends Element implements PointCounter  {
	// A szabad csöveket tárolja, amik a ciszternában jönnek létre, a létrejövés idejének sorrendjében.
	private ArrayList<Pipe> createdPipes;
    // Hány szabad végű cső van még a ciszternában.
    private int numberOfFreePipes;


    public ArrayList<Pipe> getCreatedPipes() {
		return createdPipes;
	}

	public void setCreatedPipes(ArrayList<Pipe> createdPipes) {
		this.createdPipes = createdPipes;
	}

	public int getNumberOfFreePipes() {
		return numberOfFreePipes;
	}

	public void setNumberOfFreePipes(int numberOfFreePipes) {
		this.numberOfFreePipes = numberOfFreePipes;
	}

	/**
     * Lérehoz egy ciszternát a megadott paraméterekkel.
     */
    Cistern(int numberOfFreePipes, ArrayList<Pipe> createdPipes, ArrayList<Pipe> pipes, int maxPipes) {
        super(maxPipes, pipes);
        this.numberOfFreePipes = numberOfFreePipes;
        if (createdPipes == null)
            this.createdPipes = new ArrayList<>();
        else
            this.createdPipes = createdPipes;
    }

    /**
     * Minden a pipes változójában lévő csőre meghívja az AbsorbWater függvényt 10 értékű paraméterrel, mivel ez a csövek kapacitása, ennél több nem jöhet belőle.
     * Ez a függvény visszaad minden csőnél egy értéket, amennyivel növelni kell a szerelők pontját és meghívódik az IncreasePoints függvény az előző visszatérési értékkel.
     */
    public void WaterFlow() {
    	for(Pipe i : pipes) {
    		int water = i.AbsorbWater(10);
        	this.IncreasePoints(water);
    	}
    }

    /**
     * Visszaadja a pump változóját és új pumpát hoz létre annak a pump változóba.
     * @return Visszaadja a pump változó értékét.
     */
    public Pump GivePump() {
        return new Pump(null, null, 0, 15, true, null, 20);
    }

    /**
     * Megnöveli a szerelők pontját amount értékkel.
     * @param amount A pont növelésének értéke.
     */
    public void IncreasePoints(int amount) {
        Controller.plumberPoints += amount;
    }

    /**
     * Létrehoz egy új csövet, majd meghívja az AddEndpoint függvényét saját magával paraméterként, és ezzel hozzácsatlakoztatja a csövet magához.
     * Utána hozzáadja a createdPipes változó legvégére a létrehozott csövet az időrendi sorrend megtartásához.
     * Ezt az egészet egy try-catchben kell megvalósítani, mivel a cső csatlakozása dobhat kivételt, ha már mindkét vége volt csatlakoztatva a csőnek.
     */
    public void CreateNewPipe() throws PipeSetEndpointException {
        try {
        	ArrayList<Element> endPoints = new ArrayList<Element>();
        	endPoints.add(this);
        	endPoints.add(null);
            Pipe newPipe = new Pipe(0, true, 10, false, 0, 0,0, endPoints);
            newPipe.AddEndPoint(this);
            createdPipes.add(newPipe);
            ++numberOfFreePipes;
        } catch (PipeSetEndpointException e) {
            e.printOutMessage();
            throw new PipeSetEndpointException();
        }
    }

    /**
     * Visszaadja a createdPipes legelső elemét, ami a legrégebben jött létre és kitörli azt a listából.
     * @return A kiválasztott szabad cső.
     */
    public Pipe GetFreePipe() throws NoFreePipeCisternException{
    	if(!createdPipes.isEmpty())
    	{
    		--numberOfFreePipes;
    		return createdPipes.remove(0);
    		
    	}
    	else
    	{
    		throw new NoFreePipeCisternException();
    	}
        
    }
    
    public boolean canMoveAway() {
    	return true;
    }
}
