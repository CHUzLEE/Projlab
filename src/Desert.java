import java.util.ArrayList;

public class Desert implements PointCounter {
    // A pálya forrása.
    private Source source;
    // A játékelemek.
    private ArrayList<Element> elements;
    // A csövek.
    private ArrayList<Pipe> pipes;
    // A Desert singleton példánya, amit létrehoz a program indításánál.
    private static Desert instance = new Desert();

    /**
     * Mivel singleton nem lehet a konstruktorát kívülről meghívni.
     */
    private Desert() {}

    /**
     * Visszaadja a Desert singleton példányát.
     * @return A visszaadott példány.
     */
    public static Desert GetDesert() {
    	return instance;
    }

    /**
     * Növeli a szabotőrök pontját amount értékkel.
     * @param amount A pontmennyiség.
     */
    public void IncreasePoints(int amount) {
        Controller.saboteurPoints += amount;
    }

    /**
     * Megkapja az elfolyt vizet a csövekből paraméterként és meghívja az IncreasePoints függvényt az amount étrékkel.
     * @param amount A megkapott vízmennyiség.
     */
    public void GetWater(int amount) {
        IncreasePoints(amount);
    }
}
