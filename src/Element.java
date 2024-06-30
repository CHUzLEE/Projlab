import java.util.ArrayList;

public abstract class Element implements WaterFlow, Moveable {
    // Az elemhez maximálisan csatlakoztatható csövek száma.
    protected int maxPipes;
    // Az elemhez csatlakozó csövek, csatlakoztatás időbeli sorrendjében.
    protected ArrayList<Pipe> pipes;

    
    
    public int getMaxPipes() {
		return maxPipes;
	}

	public void setMaxPipes(int maxPipes) {
		this.maxPipes = maxPipes;
	}

	public ArrayList<Pipe> getPipes() {
		return pipes;
	}

	public void setPipes(ArrayList<Pipe> pipes) {
		this.pipes = pipes;
	}

	/**
     * Létrehoz egy Elementet a megadott paraméterekkel.
     * @param maxPipes Maximum hány cső csatlakozhat a játékelemhez.
     */
    Element(int maxPipes, ArrayList<Pipe> pipes) {
        this.maxPipes = maxPipes;
        if (pipes == null)
            this.pipes = new ArrayList<>();
        else
            this.pipes = pipes;
    }

    /**
     * Absztrakt függvény, amelyet a leszármazott játékelemek definiálnak.
     * A víz folyását szimuláljuk ezzel a függvénnyel. Az egyes elemek esetében más-más a hatása.
     */
    public abstract void WaterFlow();

    /**
     * Nem csinál semmit csak az interface miatt kell megvalósítani.
     */
    public void MoveAway() { }

    /**
     * Ha a from paraméter benne van a pipes listában, vagyis össze van kötve ezzel a hellyel ahonnan ide akar mozogni a játékos,
     * meghívja a from MoveAway függvényét és visszatér a this értékével.
     * Különben kivételt dob “Nem lehet ide lépni” üzenettel.
     * @param from Ahonnan érkezik a játékos.
     * @return Visszaadja saját magát. Ide fog lépni a játékos.
     * @throws Exception Ha nem lehet ide lépni, kivételt dob.
     */
    public Moveable MoveHere(Moveable from) throws MoveException {
        if (pipes.contains(from)) {
            from.MoveAway();
            return this;
        } else {
            throw new MoveException();
        }
    }

    /**
     * Kitörli a pipes változóból a megadott pipe csövet, ezzel lecsatlakoztatva azt.
     * @param pipe A kitörlendő cső.
     */
    public void RemovePipe(Pipe pipe) {
        try {
			pipe.RemoveEndPoint(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    /**
     * Hozzáadja a pipes változóhol a megadott pipe csövet a lista végére,
     * ezzel felcsatlakoztatva azt és csatlakozás szerint időrendi sorrendben tartva a listát, ha még van hely a játékelemen.
     * @param pipe
     */
    public void Addpipe(Pipe pipe) throws PipePlaceException {
        if (pipes.size() < maxPipes)
            pipes.add(pipe);
        else
            throw new PipePlaceException();
    }
}
