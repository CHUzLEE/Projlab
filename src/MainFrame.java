import java.awt.*;
import java.util.ArrayList;

import javax.swing.JFrame;

/**
 * Megjeleníti a menüt vagy a pályát.
 */
public class MainFrame extends JFrame{
	/**
	 * A pályák eltárolása
	 */
	private static ArrayList<GameMap> maps = new ArrayList<>();
	private static int current_map;
	/**
	 * Menü eltárolása.
	 */
	private static Menu menu = new Menu();
	
	public static GameMap GetMap() {
		return maps.get(current_map);
	}

	public static void AddMap(GameMap map) {
		maps.add(map);
	}
	
	public static void main(String[] args){
		menu.initmenu();
	}
}
