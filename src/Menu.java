import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
/**
 *Menü megjelenítése.
 */
public class Menu extends JPanel{
	
	JFrame startmenu = new JFrame("The Desert of Drukmakor");
	JLabel mylabel; 
	ImageIcon backgroundpic;
	
	JButton exitbutton = new JButton();
	JButton helpbutton = new JButton();
	JButton playbutton = new JButton();
	/**
	 * Elindítja a játékot.
	 */
	public void Start()
	{
		playbutton.setBounds(100, 240, 270, 130);
		playbutton.setOpaque(false);
		playbutton.setContentAreaFilled(false);
		playbutton.setBorderPainted(false);
		playbutton.addActionListener( e -> {
			GameMap gamemap = new GameMap();

			Pipe pipe1 = new Pipe(0, true, 10, false, 0, 0, 0, null);
			Pipe pipe2 = new Pipe(0, true, 10, false, 0, 0, 0, null);
			Cistern cistern = new Cistern(0, null, null, 10);
			Pump pump = new Pump(pipe2, pipe1, 0, 20, false, null, 10);
			Source source = new Source(null, 10);

			pump.pipes.add(pipe1);
			pump.pipes.add(pipe2);
			source.pipes.add(pipe1);
			cistern.pipes.add(pipe2);

			pipe1.setEndPoints(new ArrayList<>(Arrays.asList(source, pump)));
			pipe2.setEndPoints(new ArrayList<>(Arrays.asList(pump, cistern)));

			Plumber plumber = new Plumber(1, source, null, false, null);
			Saboteur saboteur = new Saboteur(2, cistern, null);

			Polygon plumberPoint = new Polygon();
			plumberPoint.addPoint(20, 0);
			Polygon saboteurPoint = new Polygon();
			saboteurPoint.addPoint(900, 0);

			gamemap.plumber = new PlumberView(plumberPoint, plumber);
			gamemap.saboteur = new SaboteurView(saboteurPoint, saboteur);

			Polygon sourceRec = new Polygon();
			sourceRec.addPoint(20,275);
			sourceRec.addPoint(20,325);
			sourceRec.addPoint(70,325);
			sourceRec.addPoint(70,275);

			Polygon cisternTri = new Polygon();
			cisternTri.addPoint(900,275);
			cisternTri.addPoint(900,325);
			cisternTri.addPoint(950,325);
			cisternTri.addPoint(950,275);

			Polygon pumpRec = new Polygon();
			pumpRec.addPoint(520,275);
			pumpRec.addPoint(520,325);
			pumpRec.addPoint(570,325);
			pumpRec.addPoint(570,275);

			Polygon pipe1Line = new Polygon();
			pipe1Line.addPoint(70, 290);
			pipe1Line.addPoint(520, 290);
			pipe1Line.addPoint(520, 310);
			pipe1Line.addPoint(70, 310);

			Polygon pipe2Line = new Polygon();
			pipe2Line.addPoint(570, 290);
			pipe2Line.addPoint(900, 290);
			pipe2Line.addPoint(900, 310);
			pipe2Line.addPoint(570, 310);

			gamemap.objects.add(new CisternView(cisternTri, cistern));
			gamemap.objects.add(new PumpView(pumpRec, pump));
			gamemap.objects.add(new SourceView(sourceRec, source));
			gamemap.objects.add(new PipeView(pipe1Line, pipe1));
			gamemap.objects.add(new PipeView(pipe2Line, pipe2));

			JFrame gameFrame = new JFrame("Game");
			gameFrame.setVisible(true);
			gameFrame.setLayout(null);
			gameFrame.setSize(1000,600);
			gamemap.setVisible(true);
			gamemap.setLayout(null);
			gamemap.setSize(1000,600);
			gamemap.setBackground(new Color(211, 199, 162));
			MainFrame.AddMap(gamemap);
			gameFrame.add(gamemap);
			gameFrame.addMouseListener(new InputController());

			gamemap.StartGame();
		});
		
		mylabel.add(playbutton);
		
	}
	/**
	 * Kilépés a programból.
	 */
	public void Exit()
	{
		exitbutton.setBounds(850, 475, 90, 45);
		exitbutton.setOpaque(false);
		exitbutton.setContentAreaFilled(false);
		exitbutton.setBorderPainted(false);
		/*exitbutton.setText("Exit");
		exitbutton.setFont(new Font("Times new Roman",Font.BOLD,25));
		exitbutton.setBackground(Color.LIGHT_GRAY );*/
		exitbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JComponent comp = (JComponent) e.getSource();
            	  Window win = SwingUtilities.getWindowAncestor(comp);
            	  win.dispose();
                
            }
        });
		
		mylabel.add(exitbutton);
	}
	
	/**
	 * Játékleírás megjelenítése.
	 */
	public void Help()
	{
		helpbutton.setBounds(840, 420, 100, 50);
		
		helpbutton.setOpaque(false);
		helpbutton.setContentAreaFilled(false);
		helpbutton.setBorderPainted(false);
		helpbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               new HelpPanel();

            }
        });
		
		
		mylabel.add(helpbutton);
	}
	
	public void initmenu() {
		
			backgroundpic = new ImageIcon( "hatter.jpg" );
			mylabel = new JLabel(backgroundpic);
			mylabel.setSize(960,540);
			
		
			startmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			startmenu.setVisible(true);
			startmenu.setLayout(null);
			startmenu.setSize(960,560);
			startmenu.add(mylabel);

			
			Start();	
			Help();
			Exit();
	}
	
	
	
}
