import java.awt.*;

/**
 *Pumpa objektum megjelenítése
 */
public class PumpView extends GameObject{
	Pump pump;
	
	/**
	 * konstruktor
	 * @param cn hány koordináta szükséges az objektum kirajzolásához
	 * @param pump a modellbeli Pump objektum, amelyet reprezentál.
	 */
	PumpView(Polygon cn, Pump pump) {
		super(cn);
		this.pump = pump;
	}

	@Override
	/**
	 * Balklikkelés, ha az objektum határain kívüli x, y paramétereket kap akkor egyből visszatér.
	 * Az irányított játékost az objektumra mozgatjuk.
	 * @param p kattintás helyének pontja.
	 */
	public void LeftClick(Point p) {
		if (!polygon.contains(p)) return;
		MainFrame.GetMap().plumber.plumber.Move(pump);
	}

	@Override
	/**
	 * Jobbklikkelés, ha az objektum határain kívüli x, y paramétereket kap akkor egyből visszatér.
	 * Ha a pumpán van a játékos és szerelőt irányítunk és a pumpa nem működik akkor megjavítja a pumpát.
	 * Ha a pumpán van a játékos és a pumpa működik és a játékosnál van lecsatolt csővég akkor csatlakoztatja a pumpához.
	 * @param p kattintás helyének pontja.
	 */
	public void RightClick(Point p) {
		if (!polygon.contains(p)) return;
		if (MainFrame.GetMap().plumber.plumber.getOnMoveable() != pump) return;
		if(!pump.isWorking()) pump.Fix();
		else {
			try {
				MainFrame.GetMap().plumber.plumber.AttachPipe(pump);
			} catch (NoPickedupPipeException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	/**
	 * nem implementáljuk
	 * @param p kattintás helyének pontja.
	 */
	public void MiddleClick(Point p) {}

	@Override
	/**
	 * Meghívódik a waterflow függvény.
	 */
	public void Tick() {
		pump.WaterFlow();
	}

	@Override
	/**
	 * Kirajzolódik a pumpa.
	 */
	public void Draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(10));
		g2.setFont(new Font("TimesRoman", Font.PLAIN, 15));
		if (pump.isWorking())
			g2.setColor(Color.BLACK);
		else
			g2.setColor(Color.RED);
		g.drawPolygon(polygon);
		g2.setColor(Color.BLACK);
		g2.drawString(pump.getStoredWater() + "/" + pump.getMaxStorage(), polygon.xpoints[0] + 7, polygon.ypoints[0] + 30);
	}

	@Override
	public Object getViewOf() {
		return pump;
	}

}
