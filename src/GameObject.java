import java.awt.*;

/**
 *Különböző objektumok belőle származnak.
 */
abstract public class GameObject implements Interactions, Drawable {
	/**
	 * a polygon reprezentálja a játéktéren az elemet.
	 */
	Polygon polygon;


	GameObject(Polygon polygon)
	{
		this.polygon = polygon;
	}
	
	abstract public Object getViewOf();
	
	/**
	 * Balklikkelés, ha az objektum határain kívüli x, y paramétereket kap akkor egyből visszatér.
	 * @param p kattintás helyének pontja.
	 */
	abstract public void LeftClick(Point p);
	
	/**
	 * Jobbklikkelés, ha az objektum határain kívüli x, y paramétereket kap akkor egyből visszatér.
	 * @param p kattintás helyének pontja.
	 */
	abstract public void RightClick(Point p);
	
	/**
	 * Középső klikkelés, ha az objektum határain kívüli x, y paramétereket kap akkor egyből visszatér.
	 * @param p kattintás helyének pontja.
	 */
	abstract public void MiddleClick(Point p);
	
	/**
	 * Tick esemény kezelése.
	 */
	abstract public void Tick();
	
	/**
	 * Objektum kirajzolása
	 */
	abstract public void Draw(Graphics g);
}
