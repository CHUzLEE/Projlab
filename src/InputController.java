import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Bemenet kezelése
 */
public class InputController extends MouseAdapter{
	
	@Override
	/**
	 * Egérkattintás kezelése
	 */
	public void mouseClicked(MouseEvent e)
	{
		GameMap map = MainFrame.GetMap();
		
		if(e.getButton() == MouseEvent.BUTTON1)
		{
			map.HandleLeftClick(e.getX(), e.getY());
		}
		if(e.getButton() == MouseEvent.BUTTON3)
		{
			map.HandleRightClick(e.getX(), e.getY());
		}
		if(e.getButton() == MouseEvent.BUTTON2)
		{
			map.HandleMiddleClick(e.getX(), e.getY());
		}
	}
}
