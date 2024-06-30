import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

/**
 * Szerelő megjelenítése
 */
public class PlumberView extends GameObject{
	Plumber plumber;
	
	/**
	 * konstruktor
	 * @param cn hány koordináta szükséges az objektum kirajzolásához
	 * @param plumber a modellbeli Plumber objektum, amelyet reprezentál.
	 */
	PlumberView(Polygon cn, Plumber plumber) {
		super(cn);
		this.plumber = plumber;
	}

	@Override
	/**
	 * Nem implementáljuk.
	 *@param p kattintás helyének pontja.
	 */
	public void LeftClick(Point p) {}

	@Override
	/**
	 * Nem implementáljuk.
	 * @param p kattintás helyének pontja.
	 */
	public void RightClick(Point p) {}

	@Override
	/**
	 * Nem implementáljuk.
	 * @param p kattintás helyének pontja.
	 */
	public void MiddleClick(Point p) {}

	@Override
	/**
	 * Nem implementáljuk.
	 */
	public void Tick() {}

	@Override
	/**
	 * A szerelő kirajzolása.
	 */
	public void Draw(Graphics g) {
		try {
			polygon = MainFrame.GetMap().getPolygonOf(plumber.getOnMoveable());
			g.drawImage(ImageIO.read(new File("repairman.png")), (polygon.xpoints[0] + polygon.xpoints[3]) / 2, polygon.ypoints[0], 30, 70,null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public Object getViewOf() {
		return plumber;
	}
}
