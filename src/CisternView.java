import java.awt.*;

/**
 * Ciszterna objektum kirajzolása
 */
public class CisternView extends GameObject{
	Cistern cistern;

	/**
	 * konstruktor
	 * @param triangle a megadott háromszög.
	 * @param cistern a modellbeli Cistern objektum, amelyet reprezentál.
	 */
	CisternView(Polygon triangle, Cistern cistern) {
		super(triangle);
		this.cistern = cistern;
	}

	@Override
	/**
	 * Balklikkelés, ha az objektum határain kívüli x, y paramétereket kap akkor egyből visszatér.
	 * Ide mozog az éppen irányított játékos.
	 * @param p kattintás helyének pontja.
	 */
	public void LeftClick(Point p) {
		if (!polygon.contains(p)) return;
		MainFrame.GetMap().plumber.plumber.Move(cistern);
	}

	@Override
	/**
	 * Jobbklikkelés, ha az objektum határain kívüli x, y paramétereket kap akkor egyből visszatér.
	 * Ha az irányított játékos épp az objektumon van és nincs nála pumpa, akkor felvesz egy pumpát a játékos.
	 * Ha az irányított játékos épp az objektumon van és van nála lecsatolt cső, akkor a csövet az ciszternához csatolja.
	 * Ha a ciszternán van újonnan létrejött csővég, akkor a játékos felvesz egyet.
	 * @param p kattintás helyének pontja.
	 */
	public void RightClick(Point p) {
		if (!polygon.contains(p)) return;
		if (MainFrame.GetMap().plumber.plumber.getOnMoveable() != cistern) return;

		if (MainFrame.GetMap().plumber.plumber.GetCarriedPump() == null) {
			try {
				MainFrame.GetMap().plumber.plumber.GetPump(cistern);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else if (cistern.getNumberOfFreePipes() != 0) {
			try {
				MainFrame.GetMap().plumber.plumber.AddCarriedPipe(cistern.GetFreePipe());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	/**
	 * nem implementáljuk
	 */
	public void MiddleClick(Point p) {}

	@Override
	/**
	 * Létrejön egy szabad csővég és meghívódik a waterflow függvény.
	 */
	public void Tick() {
		try {
			cistern.CreateNewPipe();
			cistern.WaterFlow();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	/**
	 * Kirajzoilja a ciszternát
	 */
	public void Draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(10));
		g2.setColor(Color.GRAY);
		g.drawPolygon(polygon);
	}

	@Override
	public Object getViewOf() {
		return cistern;
	}

}
