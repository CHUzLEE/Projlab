import java.awt.*;

public interface Interactions {
	
	/**
	 * Balklikkelés, ha az objektum határain kívüli x, y paramétereket kap akkor egyből visszatér.
	 * @param p kattintás helyének pontja.
	 */
	public void LeftClick(Point p);
	
	/**
	 * Jobbklikkelés, ha az objektum határain kívüli x, y paramétereket kap akkor egyből visszatér.
	 * @param p kattintás helyének pontja.
	 */
	public void RightClick(Point p);
	
	/**
	 * Középső klikkelés, ha az objektum határain kívüli x, y paramétereket kap akkor egyből visszatér.
	 * @param p kattintás helyének pontja.
	 */
	public void MiddleClick(Point p);
	
	/**
	 * Tick esemény kezelése.
	 */
	public void Tick();
}
