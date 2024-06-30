
import java.awt.*;


public class PipeView extends GameObject{
	Pipe pipe;
	/**
	 * konstruktor
	 * @param cn hány koordináta szükséges az objektum kirajzolásához
	 * @param pipe a modellbeli Pipe objektum, amelyet reprezentál.
	 */
	PipeView(Polygon cn, Pipe pipe) {
		super(cn);
		this.pipe = pipe;
	}

	@Override
	/**
	 * Balklikkelés, ha az objektum határain kívüli x, y paramétereket kap akkor egyből visszatér.
	 * Az irányított játékost az objektumra mozgatjuk.
	 * Ha a játékos a csövön van és a cső nem lyukas és szabotőrt irányítunk akkor kilyukasztja.
	 * Ha a játékos a csövön van és a cső nem lyukas és szerelőt irányítunk akkor lehelyezünk egy pumpát a csőre.
	 * @param p kattintás helyének pontja.
	 */
	public void LeftClick(Point p) {
		if (!polygon.contains(p)) return;
		MainFrame.GetMap().plumber.plumber.Move(pipe);
	}

	@Override
	/**
	 * Jobbklikkelés, ha az objektum határain kívüli x, y paramétereket kap akkor egyből visszatér.
	 * Ha a játékos a csövön van és a cső lyukas és szerelőt irányítunk akkor megjavítja.
	 * Ha a játékos a csövön van és a cső nem lyukas akkor ragadóssá teszi.
	 * Ha a játékos egy aktív elemen tartózkodik és az aktív elemhez csatlakozik a cső akkor lecsatlakoztatja.
	 * @param p kattintás helyének pontja.
	 */
	public void RightClick(Point p) {
		if (!polygon.contains(p)) return;

		if (!pipe.isWorking() && MainFrame.GetMap().plumber.plumber.getOnMoveable() == pipe) {
			MainFrame.GetMap().plumber.plumber.Fix(pipe);
		} else if (pipe.isWorking() && MainFrame.GetMap().plumber.plumber.getOnMoveable() == pipe) {
			try {
				MainFrame.GetMap().plumber.plumber.MakeSticky(pipe);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else if (pipe.isNeighbor(MainFrame.GetMap().plumber.plumber.getOnMoveable())) {
			MainFrame.GetMap().plumber.plumber.DetachPipe(pipe, (Element) MainFrame.GetMap().plumber.plumber.getOnMoveable());
		}
	}

	@Override
	/**
	 * Középső klikkelés, ha az objektum határain kívüli x, y paramétereket kap akkor egyből visszatér.
	 * Ha a játékos a csövön van  és szabotőrt irányítunk akkor csúszóssá teszi a csövet.
	 * @param p kattintás helyének pontja.
	 */
	public void MiddleClick(Point p) {
		if (!polygon.contains(p)) return;
		if (MainFrame.GetMap().saboteur.saboteur.getOnMoveable() != pipe) return;
		try {
			MainFrame.GetMap().saboteur.saboteur.MakeSticky(pipe);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	/**
	 * Nem implementáljuk.
	 */
	public void Tick() {}

	@Override
	/**
	 * Cső kirajzolása.
	 */
	public void Draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		g2.setFont(new Font("TimesRoman", Font.PLAIN, 15));
		if (pipe.getWaterLevel() > 0)
			g2.setColor(Color.BLUE);
		else if (pipe.getSlippery() > 0)
			g2.setColor(Color.YELLOW);
		else if (pipe.getSticky() > 0)
			g2.setColor(Color.GREEN);
		else if (!pipe.isWorking())
			g2.setColor(Color.RED);
		else
			g2.setColor(Color.BLACK);

		Polygon p1 = MainFrame.GetMap().getPolygonOf(pipe.getEndPoints().get(0));
		Polygon p2 = MainFrame.GetMap().getPolygonOf(pipe.getEndPoints().get(1));

		polygon = new Polygon();

		if (p1 == null && p2 == null) {

		} else if (p1 == null) {
			polygon.addPoint(p2.xpoints[0] - 30, p2.ypoints[0] + 5);
			polygon.addPoint(p2.xpoints[1] - 30, p2.ypoints[1] - 5);
			polygon.addPoint(p2.xpoints[1], p2.ypoints[1] - 5);
			polygon.addPoint(p2.xpoints[0], p2.ypoints[0] + 5);
		} else if (p2 == null) {
			polygon.addPoint(p1.xpoints[3], p1.ypoints[3] + 5);
			polygon.addPoint(p1.xpoints[2], p1.ypoints[2] - 5);
			polygon.addPoint(p1.xpoints[2] + 30, p1.ypoints[2] - 5);
			polygon.addPoint(p1.xpoints[3] + 30, p1.ypoints[3] + 5);
		} else {
			polygon.addPoint(p1.xpoints[3], p1.ypoints[3] + 5);
			polygon.addPoint(p1.xpoints[2], p1.ypoints[2] - 5);
			polygon.addPoint(p2.xpoints[1], p2.ypoints[1] - 5);
			polygon.addPoint(p2.xpoints[0], p2.ypoints[0] + 5);
		}


		g2.drawPolygon(polygon);
		g2.setColor(Color.BLACK);
		g2.drawString("~" + pipe.getWaterLevel() + " %" + pipe.getSlippery() + " %" + pipe.getSticky() + " $" + pipe.getSabotageable(),
				polygon.xpoints[0] + 5, polygon.ypoints[0] - 5);
	}

	@Override
	public Object getViewOf() {
		return pipe;
	}

}
