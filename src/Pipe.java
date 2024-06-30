import java.util.ArrayList;
import java.util.Random;

public class Pipe implements Fixable, Moveable, Stepable {
	// Az aktuális vízmennyiséget mutatja a csőben.
	private int waterLevel;


	// A cső működik vagy nem.
	private boolean working;
	// Az adott cső kapacitása, amennyi víz maximálisan lehet benne egyszerre.
	private int capacity;
	// Vannak-e a csövön éppen.
	private boolean occupied;
	// Fel van-e véve legalább egy vége a csőnek.
	private boolean pickedup;
	// Ha nulla az értéke ki lehet lyukasztani a csövet. Különben megadja mennyi idő van még, ameddig újra kilyukasztható lesz a cső.
	private int sabotageable;
	// Ha nulla az értéke nem ragad a cső. Különben megadja mennyi ideig ragad még.
	private int sticky;
	// Ha nulla az értéke nem csúszós a cső. Különben megadja mennyi ideig csúszós még.
	private int slippery;
	// Egy maximum két elemű lista, amiben a cső két végpontja van tárolva.
	private ArrayList<Element> endPoints;

	/**
	 * Construktor, létrehoz egy csövet a megadott parameterekkel
	 *
	 * @param waterLevel
	 * @param working
	 * @param capacity
	 * @param occupied
	 * @param sabotageable
	 * @param sticky
	 * @param slippery
	 * @param endPoints
	 */
	public Pipe(int waterLevel, boolean working, int capacity, boolean occupied, int sabotageable, int sticky, int slippery, ArrayList<Element> endPoints) {
		this.waterLevel = waterLevel;
		this.working = working;
		this.capacity = capacity;
		this.occupied = occupied;
		this.sabotageable = sabotageable;
		this.sticky = sticky;
		this.slippery = slippery;
		this.endPoints = endPoints;
	}

	public int getWaterLevel() {
		return waterLevel;
	}

	public boolean isNeighbor(Moveable m) {
		return endPoints.contains(m);
	}

	public void setWaterLevel(int waterLevel) {
		this.waterLevel = waterLevel;
	}

	public boolean isWorking() {
		return working;
	}

	public void setWorking(boolean working) {
		this.working = working;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public boolean isPickedup() {
		return pickedup;
	}

	public void setPickedup(boolean pickedup) {
		this.pickedup = pickedup;
	}

	public int getSabotageable() {
		return sabotageable;
	}

	public void setSabotageable(int sabotageable) {
		this.sabotageable = sabotageable;
	}

	public int getSticky() {
		return sticky;
	}

	public void setSticky(int sticky) {
		this.sticky = sticky;
	}

	public int getSlippery() {
		return slippery;
	}

	public void setSlippery(int slippery) {
		this.slippery = slippery;
	}

	public ArrayList<Element> getEndPoints() {
		return endPoints;
	}

	public void setEndPoints(ArrayList<Element> endPoints) {
		this.endPoints = endPoints;
	}


	/**
	 * Igazra állítja a working változót és átállítja a sabotageable változó értékét véletlen számra.
	 */
	public void Fix() {
		working = true;
		Random randI = new Random();
		sabotageable = randI.nextInt(2) + 1;
	}


	/**
	 * Hamisra állítja a working változót.
	 */
	public void Disable() {
		working = false;
	}

	/**
	 * Hamisra állítja a working változót. Elmozgot a játékos, így szabad a cső
	 */
	public void MoveAway() {
		occupied = false;
	}

	/**
	 * Ha az occupied változó hamis és a from paraméter benne van az endpoints listában, igazra állítja az occupied-ot, meghívja a
	 * from MoveAway függvényét és visszatér a this értékével.
	 * és a slippery tagváltozó értéke 0-nál nagyobb, akkor valamelyik endpointjával tér vissza. (randommal dontjuk el). Különben kivételt dob “Nem lehet ide lépni” üzenettel.
	 *
	 * @param from ahonnan a játékos akar jönni
	 */
	public Moveable MoveHere(Moveable from) throws MoveException {
		if (!occupied && endPoints.contains(from) && !isDetached()) {
			if (slippery != 0) {
				Random randI = new Random();
				return endPoints.get(randI.nextInt(2));
			} else {
				occupied = true;
				from.MoveAway();
				return this;
			}
		} else {
			throw new MoveException();
		}
	}

	/**
	 * Ha mindkét endpoint null, az elsőt átírja az
	 * element-re. Hogyha csak az egyik null akkor ezt átírja az e-re. Hogyha egyiksem null,
	 * akkor kivételt dob “Nincs szabad vége a csőnek” üzenettel.
	 *
	 * @param e az element amit ráakarunk csatlakoztatni a csőre
	 */
	public void AddEndPoint(Element e) throws PipeSetEndpointException {
		if (endPoints.get(0) == null) {
			endPoints.set(0, e);
		} else if (endPoints.get(1) == null) {
			endPoints.set(1, e);
		} else {
			throw new PipeSetEndpointException();
		}
	}

	/**
	 * Ha az egyik endpoint sem null, visszadja az elsőt. Ha
	 * csak az egyik null, akkor visszaadja a nem null endpoint-ot. Különben kivételt dob
	 * “A cső nincs csatlakoztatva sehova” üzenettel.
	 *
	 * @return
	 */
	public Element GetEndPoint() throws PipeGetEndpointException {
		if (endPoints.get(0) != null) {
			return endPoints.get(0);
		} else if (endPoints.get(1) != null) {
			return endPoints.get(1);
		} else {
			throw new PipeGetEndpointException();
		}
	}

	/**
	 * Kitörli a megadott element játékelemet
	 * az endpoints változóból.
	 *
	 * @param e Kitörlendő element
	 */
	public void RemoveEndPoint(Element e) throws PipeRemoveEndpointException {
		if (endPoints.contains(e)) {
			if (endPoints.get(0) == e) {
				endPoints.set(0, null);
			} else if (endPoints.get(1) == e) {
				endPoints.set(1, null);
			}
		} else {
			throw new PipeRemoveEndpointException();
		}

	}

	/**
	 * Ha a working változó false, akkor a desert GetDesert().GetWater-t meghívja. Feltölti a waterLevel értékét amount-tal maximálisan a
	 * capacity értékéig, majd visszaadja, hogy mennyivel növekedett a waterLevel értéke.
	 *
	 * @param amount
	 */
	public int FillWater(int amount) {
		if (!working || isDetached()) {
			Desert.GetDesert().GetWater(amount);
			return amount;
		} else {
			if (amount + waterLevel > capacity) {
				int temp = capacity - waterLevel;
				waterLevel += temp;
				amount -= temp;
				//System.out.println("!debug: capacity - waterlevel:" + temp );
				//System.out.println("!debug: amount - (capacity - waterlevel):" + amount );
				//waterLevel = capacity;
				return (amount);
			} else {
				waterLevel += amount;
				return amount;
			}
		}
	}

	/**
	 * Lecsökkenti a waterLevel értékét requested-del maximálisan nulláig, majd visszaadja, hogy mennyivel csökkent a waterLevel értéke.
	 *
	 * @param requested
	 * @return
	 */
	public int AbsorbWater(int requested) {
		if (requested > waterLevel) {
			int ret = waterLevel;
			waterLevel = 0;
			return ret;
		} else {
			waterLevel = waterLevel - requested;
			return requested;
		}
	}

	/**
	 * Csökkenti eggyel a sabotageable, sticky és slippery változók értékét maximum 0 értékig.
	 */
	public void Step() {
		if (sabotageable != 0) {
			--sabotageable;
		}
		if (sticky != 0) {
			sticky--;
		}
		if (slippery != 0) {
			--slippery;
		}
	}

	// Getterek, setterek
	public int GetCapacity() {
		return capacity;
	}

	public void SetPlayersOnPipe(Pipe p) {
	}

	public void SetOccupied(boolean o) {
		occupied = o;
	}

	public boolean GetOccupied() {
		return occupied;
	}

	public void setwaterLevel(int amount) {
		waterLevel = amount;
	}

	void MakeSticky() throws PipeStickyException {
		if (sticky != 0) {
			throw new PipeStickyException();
		} else {
			sticky += 5;
		}
	}

	void MakeSlippery() throws PipeSlipperyException {
		if (slippery != 0) {
			throw new PipeSlipperyException();
		} else {
			slippery += 5;
		}
	}


	public int getsabotageable() {
		return sabotageable;
	}

	public boolean isDetached() {

		if (endPoints.get(0) == null || endPoints.get(1) == null) {
			return true;
		}
		return false;
	}

	public boolean canMoveAway() {
		if (sticky == 0) {
			return true;
		}
		return false;
	}
}
