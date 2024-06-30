import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Pump extends Element implements Fixable, PumpController {
	
	// A pumpa kimeneti csövét tárolja, ahová a vizet pumpálja
    private Pipe outputId;
    // A pumpa bemeneti csövét tárolja, ahonnan a vizet kapja
    private Pipe inputId;
    // A pumpában eltárolt víz mennyisége 
    private int storedWater;
    // A pumpa tárolójának maximum vízmennyisége
    private int maxStorage;
    // működik-e vagy nem
    private boolean working;
    
    
    /**
     * Construktor, létrehoz egy pumpát a megadott paraméterekkel
     * @param output
     * @param input
     * @param storedWater
     * @param maxStorage
     * @param pipes
     * @param maxPipes
     * @param working
     */
    public Pump(Pipe output, Pipe input, int storedWater, int maxStorage, boolean working, ArrayList<Pipe> pipes, int maxPipes) {
    	super(maxPipes, pipes);
    	this.outputId = output;
    	this.inputId = input;
    	this.storedWater = storedWater;
    	this.maxStorage = maxStorage;
    	this.working = working;
    }
    
    public Pipe getOutputId() {
		return outputId;
	}

	public void setOutputId(Pipe outputId) {
		this.outputId = outputId;
	}

	public Pipe getInputId() {
		return inputId;
	}

	public void setInputId(Pipe inputId) {
		this.inputId = inputId;
	}

	public int getStoredWater() {
		return storedWater;
	}

	public void setStoredWater(int storedWater) {
		this.storedWater = storedWater;
	}

	public int getMaxStorage() {
		return maxStorage;
	}

	public void setMaxStorage(int maxStorage) {
		this.maxStorage = maxStorage;
	}

	public boolean isWorking() {
		return working;
	}

	public void setWorking(boolean working) {
		this.working = working;
	}

	/**
     * Ha a working változó igaz, akkor meghívja az output csőnek a
     * FillWater függvényét storedWater paraméterrel. Majd visszakap a FillWater fgv.-től
     * egy számot és ezt kivonja a storedWater változóból. (Amit visszakap érték, az azt
     * jelenti, hogy mennyi vizet tudott elvinni a cső). Ezután a input csőnek meghívja az
     * AbsorbWater függvényét maxStorage-storedWater értékkel (vagyis hogy mennyi
     * vizet tud még eltárolni). Az AbsorbWater visszatérési értékével növeli a storedWater
     * értékét. Ha working hamis, akkor nem pumpál vizet.
     */
    public void WaterFlow() {
    	if(working) {
			int backflow = outputId.FillWater(storedWater);
			storedWater = 0;
			storedWater += backflow;

    		int inflow = inputId.AbsorbWater(maxStorage-storedWater);
    		storedWater += inflow;
    	}
    }
    
    /**
     * Megjavítja a hibás pumpát. Átállítja a working változót igazzá.
     */
    public void Fix() {
    	working = true;
    }

    /**
     * 
     */
    public void Disable() {
    	working = false;
    }
    
    /**
     * Beállítja az output változót a paraméterben megadott
     * csőre. Ha nincs csatlakoztatva a paraméterrel megadott cső a pumpára, akkor
     * kivételt dob “Nincs a cső csatlakoztatva” üzenettel.
     * @param id
     */
    public void SetInputId(Pipe id) throws PumpInputException {    
    	if(pipes.contains(id)) {
            inputId = id;
    	}
    	else {
    		throw new PumpInputException();
    	}
    }

    /**
     * Beállítja az input változót a paraméterben megadott
     * csőre. Ha nincs csatlakoztatva a paraméterrel megadott cső a pumpára, akkor
     * kivételt dob “Nincs a cső csatlakoztatva” üzenettel.
     * @param id
     * @throws Exception
     */
    public void SetOutputId(Pipe id) throws PumpOutputException {	
    	if(pipes.contains(id)) {
            outputId = id;
    	}
    	else {
    		throw new PumpOutputException();
    	}
    }

    /**
     * TODO
     * Hogyha a random paraméter hamis, átállítja
     * a working változót hamisra. Különben véletlenszerűen átállítja a working változót
     * hamisra vagy nem.
     * @param random
     */
    public void RandomDisable(boolean random) {
		if(!random) {
    		working = false;
    	}
    	else {
        	Random rng = new Random();
        	if(rng.nextInt(100) < 3) {
        		working = false;
        	}
    	}	
	}
    
    public boolean canMoveAway() {
    	return true;
    }
}
