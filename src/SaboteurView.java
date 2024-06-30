import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

/**
 * Szabotőr megjelenítése
 */
public class SaboteurView extends GameObject {
	Saboteur saboteur;
	/**
	 * konstruktor
	 * @param cn hány koordináta szükséges az objektum kirajzolásához
	 * @param saboteur a modellbeli Saboteur objektum, amelyet reprezentál.
	 */
	SaboteurView(Polygon cn, Saboteur saboteur) {
		super(cn);
		this.saboteur = saboteur;
	}
	
	public void setPolygon(Polygon cn) {
		this.polygon = cn;
	}

	@Override
	/**
	 * Nem implementáljuk.
	 * @param p kattintás helyének pontja.
	 */
	public void LeftClick(Point p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * Nem implementáljuk.
	 * @param p kattintás helyének pontja.
	 */
	public void RightClick(Point p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * Nem implementáljuk.
	 * @param p kattintás helyének pontja.
	 */
	public void MiddleClick(Point p) {}

	@Override
	/**
	 * Nem implementáljuk.
	 * @param x kattintás helyének x koordinátája
	 * @param y kattintás helyének y koordinátája
	 */
	public void Tick() {}

	@Override
	/**
	 * A szabotőr kirajzolása.
	 */
	public void Draw(Graphics g) {
		try {
			polygon = MainFrame.GetMap().getPolygonOf(saboteur.getOnMoveable());
			g.drawImage(ImageIO.read(new File("bandit.png")), polygon.xpoints[0], polygon.ypoints[0], 30, 70,null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public Object getViewOf() {
		return saboteur;
	}

}
