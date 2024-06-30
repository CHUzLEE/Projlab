import java.awt.*;

/**
 *Forrás objektum megjelenítése
 */
public class SourceView extends GameObject{
	Source source;
	
	/**
	 * konstruktor
	 * @param cn hány koordináta szükséges az objektum kirajzolásához
	 * @param source a modellbeli Source objektum, amelyet reprezentál.
	 */
	SourceView(Polygon cn, Source source) {
		super(cn);
		this.source = source;
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * Balklikkelés, ha az objektum határain kívüli x, y paramétereket kap akkor egyből visszatér.
	 * Az irányított játékost az objektumra mozgatjuk.
	 * @param p kattintás helyének pontja.
	 */
	public void LeftClick(Point p) {
		if (!polygon.contains(p)) return;
		MainFrame.GetMap().plumber.plumber.Move(source);
		
	}

	@Override
	/**
	 * Nem implementáljuk.
	 * @param p kattintás helyének pontja.
	 */
	public void RightClick(Point p) {
		if (!polygon.contains(p)) return;
		try {
			MainFrame.GetMap().plumber.plumber.AttachPipe(source);
		} catch (NoPickedupPipeException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	/**
	 * Nem implementáljuk.
	 * @param p kattintás helyének pontja.
	 */
	public void MiddleClick(Point p) {}

	@Override
	/**
	 * Meghívódik a waterflow függvény.
	 */
	public void Tick() {
		source.WaterFlow();
	}

	@Override
	/**
	 * Kirajzolódik a forrás.
	 */
	public void Draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(10));
		g2.setColor(Color.BLUE);
		g2.drawPolygon(polygon);
	}

	@Override
	public Object getViewOf() {
		return source;
	}

}
