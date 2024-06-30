import java.util.ArrayList;
import java.util.Iterator;

public class Source extends Element implements WaterFlow {
	
	/**
	 * Construktor Beállítja az adatokat a létrejövő forrásnak.
	 * @param pipes: Azok a csovek, amiket hozza akarunk csatlakoztani a letrejoco forrasra
	 * @param maxPipes:  Azaz ertek, ami megmondja mennyi cso lehet csatlakoztatva egyszerre 
	 */
	Source(ArrayList<Pipe> pipes, int maxPipes){
		super(maxPipes, pipes);
	}
	
	/**
	 * Meghívja az összes pipes-ban lévő csőre a FillWater-t. A cső max kapacitását adja be paraméterként. Azaz annyi vizet adunk amennyit a cső elbír
	 */
    public void WaterFlow() {
    	for (int i = 0; i < pipes.size(); i++) {       
            int capacity = pipes.get(i).GetCapacity();
            pipes.get(i).FillWater(capacity);
		}
    }
    
    public boolean canMoveAway() {
    	return true;
    }
}
