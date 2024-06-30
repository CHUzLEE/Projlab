import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *Pálya megjelenítésére szolgáló osztály.
 */
public class GameMap extends JPanel implements IView {
	/**
	 * Pályán elhelyezkedő objektumok.
	 */
	ArrayList<GameObject> objects = new ArrayList<>();
	/**
	 * Az aktuálisan használt játékos.
	 */
	PlumberView plumber;
	SaboteurView saboteur;
	
	public Polygon getPolygonOf(Object o) {
		for(GameObject i : objects) {
			if(i.getViewOf().equals(o)) {
				return i.polygon;
			}
		}
		return null;
	}

	public void StartGame() {
		Thread gameThread = new Thread(this::GameLoop);
		gameThread.start();
	}

	private void GameLoop() {
		while (true) {
			for (GameObject gameObject : objects) {
				gameObject.Tick();
			}
			invalidate();
			validate();
			repaint();
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			g.drawImage(ImageIO.read(new File("sand.jpg")), 0, 0, getWidth(), getHeight(), this);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		for (GameObject gameObject : objects) {
			gameObject.Draw(g);
		}

		plumber.Draw(g);
	}

	/**
	 * Bal klikkerlés kezelése (összes objektum LeftClick függvényét meghívja)
	 * @param x kattintás helyének x koordinátája
	 * @param y kattintás helyének y koordinátája
	 */
	public void HandleLeftClick(int x, int y)
	{
		for (GameObject gameObject : objects) {
			gameObject.LeftClick(new Point(x,y));
		}
	}
	
	/**
	 * Jobb klikkerlés kezelése (összes objektum RightClick függvényét meghívja)
	 * @param x kattintás helyének x koordinátája
	 * @param y kattintás helyének y koordinátája
	 */
	public void HandleRightClick(int x, int y)
	{
		for (GameObject gameObject : objects) {
			gameObject.RightClick(new Point(x,y));
		}
	}
	
	/**
	 * Középső klikkerlés kezelése (összes objektum MiddleClick függvényét meghívja)
	 * @param x kattintás helyének x koordinátája
	 * @param y kattintás helyének y koordinátája
	 */
	public void HandleMiddleClick(int x, int y)
	{
		for (GameObject gameObject : objects) {
			gameObject.MiddleClick(new Point(x,y));
		}
	}
	
	/**
	 * Tick kezelése(összes objektum Tick() függvényét meghívja)
	 */
	public void HandleTick()
	{
		for (GameObject gameObject : objects) {
			gameObject.Tick();
		}
	}

	@Override
	/**
	 * Pumpa objektum felvétele a pályára.
	 * @param pump a modellbeli objektum
	 */
	public void CreatePumpView(Pump pump) {
		Polygon p = new Polygon();
		objects.add(new PumpView(p, pump));
		
	}

	@Override
	/**
	 * Cső objektum felvétele a pályára.
	 * @param pipe a modellbeli objektum
	 */
	public void CreatePipeView(Pipe pipe) {
		Polygon p = new Polygon();
		objects.add(new PipeView(p, pipe));
	}

	@Override
	/**
	 * Forrás objektum felvétele a pályára.
	 * @param source a modellbeli objektum
	 */
	public void CreateSourceView(Source source) {
		Polygon p = new Polygon();
		objects.add(new SourceView(p, source));
		
	}

	@Override
	/**
	 * Ciszterna objektum felvétele a pályára.
	 * @param cistern a modellbeli objektum
	 */
	public void CreateCisternView(Cistern cistern) {
		Polygon p = new Polygon();
		p.addPoint(0,0);
		p.addPoint(0,0);
		p.addPoint(0,0);
		objects.add(new CisternView(p, cistern));
		
	}

	@Override
	/**
	 * Szerelő objektum felvétele a pályára.
	 * @param plumber a modellbeli objektum
	 */
	public void CreatePlumberView(Plumber plumber) {
		Polygon p = new Polygon();
		objects.add(new PlumberView(p, plumber));
		
	}

	@Override
	/**
	 * Szabotőr objektum felvétele a pályára.
	 * @param saboteur a modellbeli objektum
	 */
	public void SaboteurView(Saboteur saboteur) {
		Polygon p = new Polygon();
		objects.add(new SaboteurView(p, saboteur));
		
	}
}
