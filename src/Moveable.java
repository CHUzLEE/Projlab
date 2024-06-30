public interface Moveable {
    /**
     * Visszaadja a helyet, hogyha tud idemozogni a játékos.
     * @return Ahova kerül majd a játékos.
     * @throws Exception 
     */
    Moveable MoveHere(Moveable from) throws MoveException;

    /**
     * Elmozgatja a játékost az elemről.
     */
    void MoveAway();
    
    public boolean canMoveAway();
}
