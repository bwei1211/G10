package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Option extends JPanel {
	
	ImageIcon X = new ImageIcon("resources/image/X.png");
	JLabel exit;
	
	String player1 = "playerone";
	String player2 = "playertwo";
	
	JTextField p1 = new JTextField(player1,10);
	JTextField p2 = new JTextField(player2,10);
	
	ImageIcon bgm1 = new ImageIcon("resources/image/check1.png");
	ImageIcon bgm2 = new ImageIcon("resources/image/check2.png");
	JLabel BGM;
	JLabel BGM2;
	JLabel BGMtext = new JLabel();
	
	Image pro;
	
	boolean closeBGM = false;
	
	public Option() {
		setLayout(null);
		setBackground(Color.DARK_GRAY);
		
		Image imgX = X.getImage();
		exit = new JLabel(new ImageIcon(imgX.getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH)));
		exit.setBounds(712, 15, 50, 50);
		add(exit);
		
		p1.setBounds(300, 50, 300, 80);
		p1.setFont(new Font(Font.SERIF, Font.PLAIN, 40));
		p1.setHorizontalAlignment(JTextField.RIGHT);  //��r�a�k
		p1.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent arg0) {
			}
			public void keyReleased(KeyEvent arg0) {
			}
			public void keyTyped(KeyEvent arg0) {
				player1 = p1.getText();
			}
		});
		add(p1);
		
		p2.setBounds(300, 150, 300, 80);
		p2.setFont(new Font(Font.SERIF, Font.PLAIN, 40));
		p2.setHorizontalAlignment(JTextField.RIGHT);  //��r�a�k
		p2.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent arg0) {
			}
			public void keyReleased(KeyEvent arg0) {
			}
			public void keyTyped(KeyEvent arg0) {
				player2 = p2.getText();
			}
		});
		add(p2);
		
		pro = bgm1.getImage();
		BGM = new JLabel(new ImageIcon(pro.getScaledInstance(100,100,java.awt.Image.SCALE_SMOOTH)));
		BGM.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
				closeBGM = true;
				setbgm();
			}
			public void mouseReleased(MouseEvent e) {
			}
		});
		BGM.setBounds(50, 350, 100, 100);
		add(BGM);
		
		pro = bgm2.getImage();
		BGM2 = new JLabel(new ImageIcon(pro.getScaledInstance(100,100,java.awt.Image.SCALE_SMOOTH)));
		BGM2.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
				closeBGM = false;
				setbgm();
			}
			public void mouseReleased(MouseEvent e) {
			}
		});
		BGM2.setBounds(50, 350, 100, 100);
	}

	protected void setbgm() {
		if(closeBGM){
			remove(BGM);
			add(BGM2);
		}
		else{
			remove(BGM2);
			add(BGM);
		}
		this.revalidate();
		this.repaint();
	}
}
