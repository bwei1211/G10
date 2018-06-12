package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Option extends JPanel {
	
	ImageIcon X = new ImageIcon("resources/image/X.png");
	JLabel exit;
	
	JTextField p1 = new JTextField("playerone",10);
	JTextField p2 = new JTextField("playertwo",10);
	
	public Option() {
		setLayout(null);
		setBackground(Color.DARK_GRAY);
		
		Image imgX = X.getImage();
		exit = new JLabel(new ImageIcon(imgX.getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH)));
		exit.setBounds(712, 15, 50, 50);
		add(exit);
		
		p1.setBounds(300, 50, 300, 80);
		p1.setFont(new Font(Font.SERIF, Font.PLAIN, 40));
		p1.setHorizontalAlignment(JTextField.RIGHT);  //¤å¦r¾a¥k
		add(p1);
		
		p2.setBounds(300, 150, 300, 80);
		p2.setFont(new Font(Font.SERIF, Font.PLAIN, 40));
		p2.setHorizontalAlignment(JTextField.RIGHT);  //¤å¦r¾a¥k
		add(p2);
	}
}
