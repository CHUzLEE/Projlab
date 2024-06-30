import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
 * Ez a panel fog megjelenni, ha a felhasznalo a help gombra megy
 */
public class HelpPanel extends JFrame{
	JFrame help = new JFrame("Help");
	JButton back = new JButton();

	JLabel head = new JLabel("Leiras");
	JLabel text = new JLabel("<html>Itt lesz a jatek reszletes leirasa"
			+ "<br/>itt is "
			+ "<br/>itt is"
			+ "<br/>itt is"
			+ "</html>", SwingConstants.CENTER );
	
	
	HelpPanel(){
		
		help.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        help.setVisible(true);
		help.setLayout(null);
		help.setSize(950,550);
       
        back.setBounds(0, 0, 200, 40);
        back.setText("Back to menu");
        back.setFont(new Font("Times new Roman",Font.BOLD,20));
        back.setBackground(Color.LIGHT_GRAY );
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	help.setVisible(false);
                
            }
        });
        
        text.setBounds(50, 0, 940, 490);
        text.setFont(new Font("Times new Roman",Font.LAYOUT_LEFT_TO_RIGHT ,25));
        text.setBackground(Color.GREEN );
        
        head.setBounds(400, 0, 250, 40);
        head.setFont(new Font("Times new Roman",Font.BOLD,40));
        head.setBackground(Color.cyan );
        
        
        help.add(text);
        help.add(head);
        help.add(back);
		
	}
	
	
	
}
