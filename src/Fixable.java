public interface Fixable {
    /**
     * Megjavítja az elromlott elemet.
     */
    void Fix();

    /**
     * Elrontja a működő elemet.
     */
    void Disable();
    
    /**
     * Működik-e az elem?
     */
    boolean isWorking();
}
