import java.util.ArrayList;

public class Game {
    // A játékban lévő szabotőrök listája belépési sorrendben.
    private ArrayList<Saboteur> saboteurs;
    // A játékban lévő szerelők listája belépési sorrendben.
    private ArrayList<Plumber> plumbers;

    /**
     * Játékost ad hozzá a szabotőr csapathoz.
     */
    public void JoinSaboteurs() {}

    /**
     * Játékost ad hozzá a szerelő csapathoz.
     */
    public void JoinPlumbers() {}

    /**
     * Ha van elegendő játékos elindítja a játékot.
     */
    public void StartGame() {}

    /**
     * Leállítja a játékot. Kiírja melyik csapat nyert.
     */
    public void EndGame() {}

    /**
     * Visszaadja, hogy mennyi szabotőr van a játékban.
     * @return A szabotőrök száma.
     */
    public int SaboteurCount() {
        return saboteurs.size();
    }

    /**
     * Visszaadja, hogy mennyi szerelő van a játékban.
     * @return A szerelők száma.
     */
    public int PlumberCount() {
        return plumbers.size();
    }
}
